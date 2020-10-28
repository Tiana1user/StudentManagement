package com.student.servlet;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据学号查询全部
        request.setCharacterEncoding("utf-8");
//        int sno = Integer.parseInt(request.getParameter("sno"));
        IStudentService service = new StudentServiceImpl();
        List<Student> students = service.queryAllStudents();
        request.setAttribute("students",students);
        //因为request域中有数据，因此跳转需要使用请求转发，重定向对丢失request域
        request.getRequestDispatcher("updateWeb.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
