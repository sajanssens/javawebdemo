package com.example.servlets;

import com.example.dao.ContactDao;
import com.example.domain.Contact;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createregistrationresponse")
public class RegistrationResponseServlet extends HttpServlet {

    private ContactDao dao = ContactDao.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Contact contact = dao.getContactByEmail(email);

        PrintWriter pw = resp.getWriter();

        String fn = contact.getFullname();
        String html = "<html><body><p> Thank you " + fn + " for contacting us</p></body></html>";

        pw.println(html);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Contact contact = dao.getContactByEmail(email);

        PrintWriter pw = resp.getWriter();

        String fn = contact.getFullname();
        String html = "<html><body><p> Thank you " + fn + " for contacting us from " + email + "</p></body></html>";

        pw.println(html);
    }

}
