package com.example.java_ee_crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Writer out= response.getWriter();

        //request.setAttribute("name","omar");
        /*String[] names={"omar","khalil","agra"};
        request.setAttribute("names",names);
        request.setAttribute("o",new User());
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);*/
        /*HttpSession session=request.getSession(false);
        if(session!=null){
            out.append("the session is not null !");
            out.append("the user name from the session is "+session.getAttribute("user-name"));
            session.invalidate();
        }else{
            out.append("session was null");
        }*/
        Cookie cookie=new Cookie("dd","somedamnedata");
        response.addCookie(cookie);
        out.append("<br> present cookies are<ul>");
        for(Cookie c:request.getCookies()){
            out.append("<li>"+c.getName()+"=>"+c.getValue()+"</li>");
        }
        out.append("</ul>");
    }

    public void destroy() {
    }
}