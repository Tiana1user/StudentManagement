package com.student.servlet;

import com.student.entity.Student;
import com.student.entity.userstudent;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据学号和密码查询单个人
        request.setCharacterEncoding("utf-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        String pwd = request.getParameter("upwd");
        IStudentService service = new StudentServiceImpl();
        boolean boo  = service.queryStudent(uid,pwd);
        HttpSession session = request.getSession();
        List<userstudent> name = service.loginQuery(uid);
        for (userstudent sname: name) {
            String ssname = sname.getUname();
            session.setAttribute("name", ssname);
        }
        //获取session的Id
        String sessionId = session.getId();
        //将session的Id存储到名字为JSESSIONID的cookie中
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        //设置cookie的有效路径
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
//        System.out.println(student);k
        //将此人信息传到前端jsp显示：studentInfo.jsp
        if (boo == true){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
