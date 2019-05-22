package com.example.servlets;

import com.example.dao.ContactDao;
import com.example.domain.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private ContactDao contactDao = ContactDao.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);

        Contact contact = new Contact(firstname, lastname, email);
        contactDao.add(contact);
        req.setAttribute("contact", contact);

        String dynamicpath = "registrationresponse";
        String staticpath = dynamicpath + ".html";
        String path = staticpath;

        // RequestDispatcher rq = req.getRequestDispatcher("/" + path);
        // rq.forward(req, resp);
        // or
        resp.sendRedirect(path + "?email=" + contact.getEmail());
    }
}
