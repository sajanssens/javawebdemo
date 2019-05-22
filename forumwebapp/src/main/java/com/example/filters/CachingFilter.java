package com.example.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CachingFilter implements Filter {

    private static byte[] responseData;
    private long cacheTime;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (responseData == null || cacheTime < System.currentTimeMillis() - 5000) {
            // first time or cachetime is expired: do real request to servlet and cache this data
            System.out.println("Building cache");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            HttpServletResponse res = (HttpServletResponse) response;
            CachedResponse cachedResponse = new CachedResponse(res, new ServletOutputStream() {
                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {

                }

                @Override
                public void write(int b) throws IOException { bos.write(b); }
            });

            // instead of forwarding the response, forward the cachable response, so we can extract the data from it when it returns.
            chain.doFilter(request, cachedResponse);

            res.flushBuffer();
            bos.close();
            responseData = bos.toByteArray();
            cacheTime = System.currentTimeMillis();
        }
        // dont forward to servlet, but return previously cached data
        response.getOutputStream().write(responseData);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
