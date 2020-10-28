/*
@author NB
@date 2019/3/27 - 10:37
*/

package com.student.servlet;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStudentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt(request.getParameter("sage"));
        String saddress = request.getParameter("saddress");
        String sclass = request.getParameter("sclass");
        String smajor = request.getParameter("smajor");
        Student student = new Student(sno,sname,sage,saddress,sclass,smajor);
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.addStudent(student);

        /*
         * out request response session application
         * out: PrintWriter out = response.getWriter();
         * session: request.getSession();
         * application:	request.getServletContext();
         */


        //设置响应编码		在out响应之前设置
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
//        if(result){
//            //out:jsp内置对象
//            out = response.getWriter();
//            out.print("增加成功!");
//            response.sendRedirect("QueryAllStudentServlet");
//        }else{
//            out.print("增加失败!");
//        }
        if (!result){
            request.setAttribute("error","addError");//添加失败返回addError
        }else {
            request.setAttribute("error", "noaddError");//添加成功返回noaddError
        }
        request.getRequestDispatcher("QueryStudentByPageServlet").forward(request,response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request,response);
    }

}
