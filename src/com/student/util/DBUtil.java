/*
@author NB
@date 2019/3/30 - 14:05
*/

package com.student.util;


import java.sql.*;

//通用的数据操作方法
public class DBUtil {
        private static final String URL = "jdbc:mysql://localhost:3306/studentmanagement?useUnicode = true&characterEncoding=utf8&useSSL=false";
        private static final String USER = "root";
        private static final String PASSWORD = "1234";
        public static Connection con = null;
        public static PreparedStatement pstmt = null;
        public static ResultSet rs = null;


    //
    public static int getTotalCount(String sql){//select count(1) ftom student
            int count = -1;
            try {
            pstmt = createPreparedStatement(sql,null);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                closeAll(rs,pstmt,con);
            }
            return count;

    }
    //获取连接对象
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return con = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    //关闭语句
    public static void closeAll(ResultSet rs, Statement sta,Connection con){
        try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(con!=null)con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //pstmt优化
    public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws ClassNotFoundException,SQLException{
        pstmt = getConnection().prepareStatement(sql);
        if(params!=null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1,params[i]);//pstmt对象？是从1开始而数组是从0开始所以i+1
            }
        }
        return pstmt;
    }
    //通用的增删改
    public static boolean executeUpdate(String sql,Object[] params){
        try {
            //获取连接对象
            //Object[] obs = {name,age,....}
            pstmt = createPreparedStatement(sql,params);
            //setXxx()方法的个数依赖与？的个数，而？的个数又和数组params的个数一致
            //setXxx()方法的个数->数组params的个数一致
            int count = pstmt.executeUpdate();
            if(count>0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            closeAll(null,pstmt,con);

        }
    }
    //通用的查
    public static ResultSet executeQuery(String sql,Object[] params){//select xxx from xx where name=? or id=?
        try {
            //获取连接对象
//            String sql = "select * from student2;";
            createPreparedStatement(sql,params);
            rs = pstmt.executeQuery();

            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
//        finally{
//            try {
//                if(rs!=null)rs.close();
//                if(pstmt!=null)pstmt.close();
//                if(con!=null)con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }

    }

}
