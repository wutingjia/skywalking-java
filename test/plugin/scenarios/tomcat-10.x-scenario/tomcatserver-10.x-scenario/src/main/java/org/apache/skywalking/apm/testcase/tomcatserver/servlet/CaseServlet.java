package org.apache.skywalking.apm.testcase.tomcatserver.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class CaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().print("wwwwwwwwwww");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
