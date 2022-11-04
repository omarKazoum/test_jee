package com.example.java_ee_crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Writer writer=resp.getWriter();
        List<CharSequence> params=new ArrayList<>();
        Enumeration<String> paramsEnum=req.getParameterNames();
        writer.append("<h1>received params:</h1><ul>");
        while(paramsEnum.hasMoreElements()){
            String name=paramsEnum.nextElement();
            writer.append("<li>"+name+"=> "+req.getParameter(name)+"</li>");
        }
        writer.append("</ul>");
        HttpSession session=req.getSession(true);
        session.setAttribute("user-name",req.getParameter("user-name"));

    }
}
