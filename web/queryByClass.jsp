<%@ page import="java.util.List" %>
<%@ page import="com.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: niu781152225
  Date: 2019/4/10
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.entity.Student" %>
<html>
<head>
    <title>模糊查询</title>
    <link rel="stylesheet" href="css/index2.css" />
</head>
<body class="feiru">
<%
    //获取request域中的数据
    List<Student> students = (List<Student>) request.getAttribute("student");
//    Student students = (Student)request.getAttribute("student");
%>

<div class="index2dingbu">
    <!--输入数据-->
    <table id="表单" style="width: 1150px">
        <%--<form action="/QueryStudentServlet" method="post">--%>
            <%--<tr style="width: 20%">--%>
                <%--<td>学号：</td>--%>
                <%--<td><input type="number" id="编号" name="sno" class="frominput"></td>--%>
            <%--</tr>--%>
            <%--<tr style="width: 10%;">--%>
                <%--<td>--%>
                    <%--<button id="添加1"><input style="background-color: rgba(0,0,0,0); border: 0px; margin-right: 5px; padding: 0; font-size: 16px; color: #FFFFFF" type="submit" value="ID查询"></button>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</form>--%>
        <%--<tr style="width: 20%">--%>
            <%--<td>班级：</td>--%>
            <%--<td><input id="班级"  list="wlmslist" class="frominput" type="text" />--%>
                <%--<datalist id="wlmslist">--%>
                    <%--<option value="17中软1"></option>--%>
                    <%--<option value="18软件1"></option>--%>
                    <%--<option value="17环艺1"></option>--%>
                    <%--<option value="18电竞1"></option>--%>
                <%--</datalist></td>--%>
        <%--</tr>--%>
        <%--<tr style="width: 10%">--%>
            <%--<td>--%>
                <%--<button id="添加2">班级查询</button>--%>
            <%--</td>--%>
        <%--</tr>--%>

        <%--<tr>--%>
            <%--<td>--%>
                <%--<button id="添加3">点击添加</button>--%>
            <%--</td>--%>
        <%--</tr>--%>
    </table>
</div>
<!--输出数据-->
<div class="meihua1">

    <table border="0" cellpadding="5" cellspacing="0" class="biaoge2">
        <thead>
        <tr>
            <td class="ziti1">学号</td>
            <td class="ziti1">姓名</td>
            <td class="ziti1">班级</td>
            <td class="ziti1">年龄</td>
            <td class="ziti1">操作</td>
        </tr>
        </thead>
        <tbody id="结果">
        <%
            for (Student student : students) {%>
        <tr>
            <td class="ziti1"><a style="color: #3F3F3F;text-decoration: none" href="QueryStudentServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td><%--编号sno--%>
            <td class="ziti1"><%=student.getSname()%></td><%--姓名sname--%>
            <td class="ziti1"><%=student.getSclass()%></td><%--班级sclass--%>
            <td class="ziti1"><%=student.getSage()%></td><%--年龄sage--%>
            <td class="ziti1"><button><a style="color: #3F3F3F;text-decoration: none" href="DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></button></td>
        </tr>
        <%
            }
        %>
        <td class="ziti1"></td>
        <td class="ziti1"></td>
        <td class="ziti1"><button><a style="color: #3F3F3F;text-decoration: none" href="QueryStudentByPageServlet">返回查询列表</a></button></td>
        <td class="ziti1"></td>
        <td class="ziti1"></td>
        <%--<td>--%>
            <%--<%--%>
                <%--if (p.getCurrcentPage() == 0){//首页--%>
            <%--%>      <a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=<%=(p.getCurrcentPage()>=p.getTotalPage())?p.getTotalPage():(p.getCurrcentPage()+1)%>">下一页</a>--%>
            <%--<a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>--%>
            <%--<%  }else if (p.getCurrcentPage()==p.getTotalPage()){//尾页--%>
            <%--%>--%>
            <%--<a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=0">首页</a>--%>
            <%--<a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=<%=p.getCurrcentPage()-1%>">上一页</a>--%>
            <%--<%  }else{//中间的--%>
            <%--%>  <a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=0">首页</a>--%>
            <%--<a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=<%=p.getCurrcentPage()-1%>">上一页</a>--%>
            <%--<a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=<%=(p.getCurrcentPage()>=p.getTotalPage())?p.getTotalPage():(p.getCurrcentPage()+1)%>">下一页</a>--%>
            <%--<a style="color: #3F3F3F;text-decoration: none"  href="QueryStudentByPageServlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>--%>
            <%--<%  }--%>
            <%--%></td>--%>
        <%--<td class="ziti1"></td>--%>
        <%--<td class="ziti1"></td>--%>
        </tbody>

        <tbody>

        </tbody>
    </table>
</div>
</body>
</html>
