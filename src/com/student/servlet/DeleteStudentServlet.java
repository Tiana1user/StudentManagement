package com.student.servlet;

import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除
        request.setCharacterEncoding("utf-8");
        int sno = Integer.parseInt(request.getParameter("sno"));
        IStudentService service = new StudentServiceImpl();
        boolean result = service.deleteStudentBySno(sno);
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
//        if (result){
////            response.getWriter().println("删除成功");
//            response.sendRedirect("QueryAllStudentServlet");//重新查询所有学生
//        }else{
//            response.getWriter().println("删除失败");
//        }
        if (result){
            request.setAttribute("errorDe","succeed");
        }else{
            request.setAttribute("errorDe","failure");
        }
        request.getRequestDispatcher("QueryStudentByPageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
