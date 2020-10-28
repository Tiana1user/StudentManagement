<%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/10
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.entity.Student" %>
<html>
<head>
    <title>添加数据</title>
    <link rel="stylesheet" href="css/index2.css" />
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="feiru">
<%
    Student student = (Student)request.getAttribute("student");
%>
<div class="container">
    <div class="jumbotron feiru">
        <h1>添加页面</h1>
        <form action="/AddStudentServlet" method="post">
            <p><table class="dataintable">
            <tr>
                <td>学号：</td>
                <td><input type="text" name="sno"></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="sname"></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><input type="text" name="sage"></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="saddress"></td>
            </tr>
            <tr>
                <td>班级：</td>
                <td><input type="text" name="sclass" ></td>
            </tr>
            <tr>
                <td>科目：</td>
                <td><input type="text" name="smajor" ></td>
            </tr>
        </table>
            <p class="tijiao"><input style="width: 815.2px;" class="btn btn-primary btn-lg" role="button" type="submit" value="添加"></p>

            </p>
        </form>
        <%--</div>--%>
    </div>
</body>
</html>
