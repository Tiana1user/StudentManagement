/*
@author NB
@date 2019/3/27 - 10:39
*/

package com.student.dao.impl;

import com.student.dao.IStudentDao;
import com.student.entity.Student;
import com.student.entity.userstudent;
import com.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//数据访问层：原子性的增删改查
public class StudentDaoImpl implements IStudentDao {
    private  final String url = "jdbc:mysql://localhost:3306/studentmanagement?useUnicode = true&characterEncoding=utf8&useSSL=false";
    private  final String user = "root";
    private  final String password = "1234";

    public boolean isExist(int sno){//true此人存在 false此人不存在
        return queryStudentBySno(sno)==null? false:true;
    }

    //查询全部学生
    public List<Student> queryAllStudents(){
        List<Student> students = new ArrayList<>();
        Student student = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            String sql = "select * from student";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){
                int no = rs.getInt("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                String sclass = rs.getString("sclass");
                String major = rs.getString("smajor");
                student = new Student(no,name,age,address,sclass,major);
                students.add(student);
            }
            return students;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally{
            DBUtil.closeAll(rs,pstmt,DBUtil.con);

        }

    }

    //根据学号修改学生
    public boolean  updateStudentSno(int sno,Student student){
        String sql = "update student set sname=?,sage=?,saddress=?,sclass=?,smajor=? where sno=?";
        Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),student.getSclass(),student.getSmajor(),sno};
        return DBUtil.executeUpdate(sql,params);
    }

    //根据学号删除学生
    public boolean deleteStudentSno(int sno){
        String sql = "delete from student where sno=?";
        Object[] params = {sno};
        return DBUtil.executeUpdate(sql,params);
    }

    //增加学生数据
    public boolean addStudent(Student student){
        String sql = "insert into student (sno,sname,sage,saddress,sclass,smajor)values(?,?,?,?,?,?)";
        Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress(),student.getSclass(),student.getSmajor()};
        return DBUtil.executeUpdate(sql,params);

    }

    //根据学号查询学生
        public Student queryStudentBySno(int sno){
            Student student = null;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,user,password);
                String sql = "select * from student where sno=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, sno);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    int no = rs.getInt("sno");
                    String name = rs.getString("sname");
                    int age = rs.getInt("sage");
                    String address = rs.getString("saddress");
                    String sclass = rs.getString("sclass");
                    String major = rs.getString("smajor");
                    student = new Student(no,name,age,address,sclass,major);
                }
                return student;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }finally{
                try {
                    if(rs!=null)rs.close();
                    if(pstmt!=null)pstmt.close();
                    if(con!=null)con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
    }
    //根据班级查询学生
        public List<Student> queryStudentByClass(String sclass){
            List<Student> students = new ArrayList<>();
            Student student = null;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,user,password);
                String sql = "select * from student where sclass like'%"+sclass+"%'";
                pstmt = con.prepareStatement(sql);
//                pstmt.setString(1, sclass);
                rs = pstmt.executeQuery();
                while (rs.next()){
                    int no = rs.getInt("sno");
                    String name = rs.getString("sname");
                    int age = rs.getInt("sage");
                    String address = rs.getString("saddress");
                    String class1 = rs.getString("sclass");
                    String major = rs.getString("smajor");
                    student = new Student(no,name,age,address,class1,major);
                    students.add(student);
                }
                return students;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }finally{
                try {
                    if(rs!=null)rs.close();
                    if(pstmt!=null)pstmt.close();
                    if(con!=null)con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
    }
//注册
    public boolean queryStudent(int user, String pwd){
        String sql ="select * from userstudent where uid=? and upwd=?";
        boolean boo = false;
        userstudent ustudent = new userstudent();
        Object[] params = {user,pwd};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
        if(rs.next()){
            rs.getString("uname");
            boo = true;
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return boo;
    }
    public List<userstudent> loginQuery(int uid){
        List<userstudent> uList = new ArrayList();
        String sql = "select * from userstudent where uid=?";
        Object[] params = {uid};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try{
        if (rs.next()){
            userstudent name = new userstudent(rs.getString("uname")) ;
            uList.add(name);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return uList;
    }
    public boolean zhuce(int uid,String upwd,String uname){
        String sql = "insert into userstudent (uid,upwd,uname)values(?,?,?)";
        Object[] params = {uid,upwd,uname};
        boolean zc = DBUtil.executeUpdate(sql,params);
        return zc;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from student";
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public List<Student> queryStudentsByPage(int currentPage,int pageSize){
        String sql = "select * from student limit ?,?";
        List<Student> students = new ArrayList<>();
        Object[] params = {currentPage*pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
        while (rs.next()){
            Student student = new Student(rs.getInt("sno"),rs.getString("sname"),rs.getInt("sage"),rs.getString("saddress"),rs.getString("sclass"),rs.getString("smajor"));
            students.add(student);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;

    }

}

