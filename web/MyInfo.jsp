<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/9
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
    <link rel="stylesheet" href="css/index2.css" />
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="feiru">
<%
    Date dNow = new Date( );
    SimpleDateFormat ft =
            new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

%>
<div class="container">
    <div class="jumbotron feiru">
        <h1>欢迎<%=session.getAttribute("name")%>!</h1>
        <p><table class="dataintable">
        <tr>
            <td>用户名称</td>
            <td><%=session.getAttribute("name")%></td>
        </tr>
        <tr>
            <td>服务器系统</td>
            <td>Windows</td>
        </tr>
        <tr>
            <td>登陆时间</td>
            <td><%=ft.format(dNow)%></td>
        </tr>
    </table>
        </p>
        <!--<p><a class="btn btn-primary btn-lg" href="#" role="button">注销</a></p>-->
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.2.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
</body>
</html>
