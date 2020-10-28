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

@WebServlet(name = "UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取修改人的编号
        int sno = Integer.parseInt(request.getParameter("sno"));
        //获取修改的信息
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        String scalss = request.getParameter("sclass");
        String major = request.getParameter("smajor");
        //将修改后的内容封装到一个实体类中
        Student student = new Student(name,age,address,scalss,major);
        IStudentService service = new StudentServiceImpl();
        boolean result = service.updateStudentBySno(sno,student);
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
//        if (result){
////            response.getWriter().println("修改成功");
//              response.sendRedirect("QueryAllStudentServlet");//修改完毕后再跳回查询并显示
//        }else {
//            response.getWriter().println("修改失败");
//        }
        if (result){
            request.setAttribute("errorUp","succeed");
        }else{
            request.setAttribute("errorUp","failure");
        }
        request.getRequestDispatcher("QueryStudentByPageServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
