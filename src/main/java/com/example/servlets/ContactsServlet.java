package com.example.servlets;

import com.example.dao.ContactDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/contacts")
public class ContactsServlet extends HttpServlet {

    private ContactDao contactDao = ContactDao.INSTANCE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        contactDao.getAllContacts().forEach(System.out::println);
    }
}