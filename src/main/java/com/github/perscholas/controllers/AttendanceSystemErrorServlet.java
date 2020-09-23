package com.github.perscholas.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AttendanceSystemErrorServlet")
public class AttendanceSystemErrorServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("I'm in Init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("I'm in doGet method");
        processError(req,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        // Convert request to Java object
        System.out.println("I'm in doPost method");
        processError(req,response);

    }

    private void processError(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        String s = (String) request.getAttribute("Message");
        System.out.println("I'm in AttendanceSystemErrorServlet"+s);
        request.setAttribute("Message", s);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
        requestDispatcher.forward(request, response);
    }
}


