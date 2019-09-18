package com.example.servlets;

import com.example.dao.ContactDao;
import com.example.domain.Contact;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registrationresponse")
public class RegistrationResponseServlet extends HttpServlet {

    private ContactDao dao = ContactDao.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Contact contact = (Contact) req.getAttribute("contact");
        String fn = contact.getFullname();

        PrintWriter pw = resp.getWriter();

        String html = """
                        <html>
                            <body>
                                <p>Thank you $fn for contacting us!</p>
                                <a href="index.jsp">Home</a>
                             </body>
                          </html>
                      """
                .replace("$fn", fn);

        pw.println(html);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Contact contact = dao.getContactByEmail(email);
        String fn = contact.getFullname();

        PrintWriter pw = resp.getWriter();

        String html = """
                        <html>
                            <body>
                                <p>Thank you $fn for contacting us from $email!</p>
                                <a href="index.jsp">Home</a>
                             </body>
                          </html>
                      """
                .replace("$fn", fn)
                .replace("$email", email);

        pw.println(html);
    }

}
