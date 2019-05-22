package com.example.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveUsersListener implements HttpSessionListener {
    private static int count;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("ActiveUsers: " + count);
        // se.getSession().setAttribute("activeUsers", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        System.out.println("ActiveUsers: " + count);
        // se.getSession().setAttribute("activeUsers", count);
    }
}
