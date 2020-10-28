<%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/11
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/index2.css" />
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="feiru">

<div class="container">
    <div class="jumbotron feiru">
        <h1>注册页面</h1>
        <form action="zhuceServlet" method="post">
            <p><table class="dataintable">
            <tr>
                <td>学号：</td>
                <td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="upwd"></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="姓名" name="uname"></td>
            </tr>
        </table>
            <p class="tijiao"><input style="width: 815.2px;" class="btn btn-primary btn-lg" role="button" type="submit" value="注册"></p>
        </form>
        <form action="Login.jsp">
            <p class="tijiao"><input style="width: 815.2px;" class="btn btn-primary btn-lg" role="button" type="submit" value="返回登陆"></p>
            </p>
        </form>
        </div>
    </div>
</body>


</html>
