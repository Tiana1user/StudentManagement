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

@WebServlet(name = "QueryStudentByIdServlet")
public class QueryStudentByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据学号查询单个人
        request.setCharacterEncoding("utf-8");
        String sclass = request.getParameter("sclass");
        IStudentService service = new StudentServiceImpl();
        List<Student> student = service.queryStudentByClass(sclass);
//        System.out.println(student);
        //将此人信息传到前端jsp显示：studentInfo.jsp
        request.setAttribute("student",student);
        request.getRequestDispatcher("queryByClass.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
