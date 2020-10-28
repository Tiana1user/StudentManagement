package com.student.service;

import com.student.entity.Student;
import com.student.entity.userstudent;

import java.util.List;

public interface IStudentService {

        //根据学号查询学生
        public Student queryStudentBySno(int sno);
        //根据班级查询学生
        public List<Student> queryStudentByClass(String sclass);

        //注册
        public boolean queryStudent(int user, String pwd);
        public List<userstudent> loginQuery(int uid);
        public boolean zhuce(int uid,String upwd,String uname);

        //查询全部学生
        public List<Student> queryAllStudents();

        //修改
        public boolean updateStudentBySno(int sno, Student student);


        //删除
        public boolean deleteStudentBySno(int sno);

        public boolean addStudent(Student student);

        //查询数据总数
        public int getTotalCount();

        //页面总数 页面大小
        public List<Student> queryStudentsByPage(int currentPage, int pageSize);

}
