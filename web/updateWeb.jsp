<%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/9
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.student.entity.Student" %>
    <html>
    <head>
        <title>修改页面</title>
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
        <h1>修改页面</h1>
        <form action="/UpdateStudentServlet" method="post">
        <p><table class="dataintable">
        <tr>
            <td>学号：</td>
            <td><input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="sname" value="<%=student.getSname()%>"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="sage" value="<%=student.getSage()%>"></td>
        </tr>
            <tr>
            <td>地址：</td>
            <td><input type="text" name="saddress" value="<%=student.getSaddress()%>"></td>
        </tr>
            <tr>
            <td>班级：</td>
            <td><input type="text" name="sclass" value="<%=student.getSclass()%>"></td>
        </tr>
            <tr>
            <td>科目：</td>
            <td><input type="text" name="smajor" value="<%=student.getSmajor()%>"></td>
        </tr>
    </table>
            <p class="tijiao"><input style="width: 815.2px;" class="btn btn-primary btn-lg" role="button" type="submit" value="修改"></p>

        </p>
        </form>
    <%--</div>--%>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<%--<script src="js/jquery-1.11.2.min.js"></script>--%>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<%--<script src="js/bootstrap.js"></script>--%>
</body>
</html>
