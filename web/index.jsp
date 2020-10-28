<%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/9
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生后台管理系统</title>
    <link rel="stylesheet"  href="css/index.css"/>
  </head>
  <body>

  <div id="" class="dingbu"><span class="shuaxin">学生管理</span><p class="erji2"><%=session.getAttribute("name")%></p><p><a href="Login.jsp" target="right">登陆页</a>/<a href="MyInfo.jsp" target="right">个人页</a>/<a href="QueryStudentByPageServlet" target="right">管理页</a></p></div>
  <!--右边盒子-->
  <!--<div id="" class="boxl1"><span>首页</span></div>
  <a href="index (2).html" target="right"><div id="" class="boxl2"><span>表格</span></div></a>
  <div id="" class="boxl3"><span>表单</span></div>-->

  <div class="zhanshi">
    <iframe class="iframe1" src="MyInfo.jsp" frameborder="0"  style=" width:100%; height:900px" scrolling="auto" name="right"></iframe>
  </div>
  <%--<script type="text/javascript" src="js/jquery-2.1.0.js"></script>--%>
  <%--<script type="text/javascript" src="js/index.js"></script>--%>
  </body>
</html>
