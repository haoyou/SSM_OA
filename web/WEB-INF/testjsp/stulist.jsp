<%--
  Created by IntelliJ IDEA.
  User: chenhaoyou
  Date: 2018/9/6
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>stulist</title>
</head>
<body>
    <p>学生列表</p>
    <table border="1">
        <tr>
            <td>ID:</td>
            <td>NAME:</td>
            <td>AGE:</td>
            <td>BIRTHDAY:</td>
        </tr>
        <c:forEach items="${students}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.age}</td>
                <td>${stu.birthday}</td>
            </tr>

        </c:forEach>
    </table>

<%--分页导航--%>
   <%--引入分页导航--%>
 <%@include file="page.jsp" %>
</body>
</html>
