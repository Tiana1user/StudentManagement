package com.student.dao;

import com.student.entity.Student;

import java.util.List;

public interface IStudentDao {
    public boolean isExist(int sno);

    //查询全部学生
    public List<Student> queryAllStudents();

    //根据学号修改学生
    public boolean  updateStudentSno(int sno, Student student);

    //根据学号删除学生
    public boolean deleteStudentSno(int sno);

    //增加学生数据
    public boolean addStudent(Student student);

    //根据学号查询学生
    public Student queryStudentBySno(int sno);

    //查询总数据数
    public int getTotalCount();

    //currentPage：当前页（页码） pageSize：页面大小（每页显示的数据量）
    public List<Student> queryStudentsByPage(int currentPage, int pageSize);
}
