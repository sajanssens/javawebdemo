package com.example.filters;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class CachedResponse extends HttpServletResponseWrapper {
    private ServletOutputStream out;
    private PrintWriter pw;

    public CachedResponse(HttpServletResponse resp, ServletOutputStream out) {
        super(resp);
        this.out = out;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return out;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (pw == null){
            pw = new PrintWriter(out);
        }
        return pw;
    }
}
