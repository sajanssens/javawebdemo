package com.example.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveUsersListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ActiveUsers.INSTANCE.increment();

        long count = ActiveUsers.INSTANCE.count();
        System.out.println("sessionCreated; activeUsers=" + count);
        se.getSession().setAttribute("activeUsers", count);
        se.getSession().setMaxInactiveInterval(10); // each session has a timeout of 10 seconds (inactivity)
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ActiveUsers.INSTANCE.decrement();

        long count = ActiveUsers.INSTANCE.count();
        System.out.println("sessionDestroyed; activeUsers=" + count);
        se.getSession().setAttribute("activeUsers", count);
    }
}
