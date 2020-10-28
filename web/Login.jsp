<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.entity.userstudent" %>
<html>
<head>
    <title>欢迎来到登陆页面</title>
    <link rel="stylesheet" href="css/index2.css" />
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="feiru">
<%
    List<userstudent> ustudent = (List<userstudent>)request.getAttribute("student");
%>
<div class="container">
    <div class="jumbotron feiru">
        <h1>欢迎</h1>
        <form action="LoginServlet" method="post">
            <p><table class="dataintable">
            <tr>
                <td>学号：</td>
                <td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="upwd"></td>
            </tr>
        </table>
            <p class="tijiao"><input style="width: 815.2px;" class="btn btn-primary btn-lg" role="button" type="submit" value="登陆"></p>
            </p>
        </form>
        <form action="zhuce.jsp">
            <p class="tijiao"><input style="width: 815.2px;" class="btn btn-primary btn-lg" role="button" type="submit" value="注册"></p>
            </p>
        </form>
        <%--</div>--%>
    </div>
</body>
</html>
