package com.example.java_ee_crud;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/file_form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part=request.getPart("file");
        if(!part.getName().isEmpty()) {
            BufferedInputStream bis = new BufferedInputStream(part.getInputStream());
            String path="C:\\Users\\Youcode\\uploads\\";
            File parentFolder=new File(path);
            parentFolder.mkdirs();
            File file = new File(path + System.currentTimeMillis() + "." + part.getContentType().split("/")[1]);
            OutputStream os = new FileOutputStream(file);
            int b = -1;
            while ((b = bis.read()) != -1) {
                os.write(b);
            }
            os.close();
            bis.close();
            response.getWriter().append("got:<br>" + part.getContentType() + " file");
            response.getWriter().append("description is " + request.getParameter("desc"));
        }else
            response.getWriter().append("file name was empty!");
    }
}
