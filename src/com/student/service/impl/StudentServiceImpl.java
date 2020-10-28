/*
@author NB
@date 2019/3/27 - 10:38
*/

package com.student.service.impl;

import com.student.dao.impl.StudentDaoImpl;
import com.student.entity.Student;
import com.student.entity.userstudent;
import com.student.service.IStudentService;

import java.util.List;

//业务逻辑层的：增删改查  增（查+增），对dao层进行的组装
public class StudentServiceImpl implements IStudentService {
    StudentDaoImpl studentDao = new StudentDaoImpl();

    //根据学号查询学生
    public Student queryStudentBySno(int sno){
        return studentDao.queryStudentBySno(sno);
    }
    //根据班级查询学生
    public List<Student> queryStudentByClass(String sclass){ return studentDao.queryStudentByClass(sclass); }
    //注册
    public boolean queryStudent(int user, String pwd){ return studentDao.queryStudent(user,pwd); }
    public List<userstudent> loginQuery(int uid){ return studentDao.loginQuery(uid); }
    public boolean zhuce(int uid,String upwd,String uname){ return studentDao.zhuce(uid,upwd,uname); }

    //查询全部学生
    public List<Student> queryAllStudents(){
        return studentDao.queryAllStudents();
    }

    //修改
    public boolean updateStudentBySno(int sno,Student student){
        if (studentDao.isExist(sno)){
            return studentDao.updateStudentSno(sno,student);
        }
            return false;
    }


    //删除
    public boolean deleteStudentBySno(int sno){
        if (studentDao.isExist(sno)){
            return studentDao.deleteStudentSno(sno);

        }else {
            return false;
        }

    }

    public boolean addStudent(Student student){
        if(!studentDao.isExist(student.getSno())){//不存在
            studentDao.addStudent(student);
            return true;
        }else{//存在
            System.out.println("此人已存在");
            return false;
        }
    }

    @Override
    public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
        return studentDao.queryStudentsByPage(currentPage,pageSize);
    }

    @Override
    public int getTotalCount(){
        return studentDao.getTotalCount();
    }
}

