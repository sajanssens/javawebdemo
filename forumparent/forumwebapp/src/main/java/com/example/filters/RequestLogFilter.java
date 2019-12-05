package com.example.filters;

import javax.servlet.*;
import java.io.IOException;

public class RequestLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long duration = System.currentTimeMillis() - start;

        System.out.println(("Request took (ms): " + duration));
    }

}
