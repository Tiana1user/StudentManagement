package com.student.servlet;

import com.student.entity.Page;
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

@WebServlet(name = "QueryStudentByPageServlet")
public class QueryStudentByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentService studentService = new StudentServiceImpl();
        int count =  studentService.getTotalCount();//数据总数
        //将分页所需要的5个字段(其中1个自动计算，因此实际只需要组转4个即可)，组装到page对象中
        Page page = new Page();
        int totalCount = studentService.getTotalCount();
        //数据总数
        page.setTotalCount(totalCount);

        String cPage = request.getParameter("currentPage");
        if (cPage==null){
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrcentPage(currentPage);
//        int currentPage = 1;
        //currentPage:当前页（页码） students:当前页的数据集合（当前页的所有学生）
        int pageSize = 10;
        page.setPageSize(pageSize);

        List<Student> students = studentService.queryStudentsByPage(currentPage,pageSize);
        page.setStudents(students);
        request.setAttribute("page", page);
        request.getRequestDispatcher("ManageLists.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
