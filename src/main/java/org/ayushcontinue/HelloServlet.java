package org.ayushcontinue;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("in service");

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h2><b>Hello World</b></h2>");
    }
}
