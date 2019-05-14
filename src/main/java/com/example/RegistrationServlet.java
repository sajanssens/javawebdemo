package com.example;

import com.example.dao.ContactDao;
import com.example.domain.Contact;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private ContactDao contactDao = ContactDao.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);

        Contact contact = new Contact(firstname, lastname, email);
        contactDao.add(contact);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        contactDao.getAllContacts().forEach(System.out::println);
    }
}
