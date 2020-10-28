package com.student.servlet;

import com.student.entity.Student;
import com.student.entity.userstudent;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "zhuceServlet")
public class zhuceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        IStudentService studentService = new StudentServiceImpl();

        boolean result = studentService.zhuce(uid,upwd,uname);
        if (result == true){
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("zhuce.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
