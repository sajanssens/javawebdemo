package com.example.servlets;

import com.example.dao.ContactDao;
import com.example.domain.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/contacts")
public class ContactsServlet extends HttpServlet {

    private ContactDao contactDao = ContactDao.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contact> contacts = contactDao.getAllContacts();
        contacts.forEach(System.out::println);

        req.setAttribute("contacts", contacts);
        req.getRequestDispatcher("contacts.jsp").forward(req, resp);
    }
}