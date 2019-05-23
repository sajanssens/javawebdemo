package com.example.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

public class RegisterUser implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Principal userPrincipal = httpServletRequest.getUserPrincipal();
        if (userPrincipal != null) {
            request.setAttribute("username", userPrincipal.getName());
        } else {
            request.setAttribute("username", "unknown...");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
