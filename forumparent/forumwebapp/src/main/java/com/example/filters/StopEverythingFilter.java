package com.example.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Turn on to bypass everything and stop the application from working
// @WebFilter("/*")
public class StopEverythingFilter implements Filter {
    @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        System.out.println("STOPPING THE WORLD....");
        // chain.doFilter();
    }
}