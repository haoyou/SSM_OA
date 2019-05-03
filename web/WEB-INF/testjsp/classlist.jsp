<%--
  Created by IntelliJ IDEA.
  User: chenhaoyou
  Date: 2018/9/7
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>classlist</title>
</head>
<body>
<p>班级列表</p>
<table border="1">
    <tr>
        <td>ID:</td>
        <td>CNAME:</td>
        <td>COUNT:</td>

    </tr>
    <c:forEach items="${classTabs}" var="classTab">
        <tr>
            <td>${classTab.id}</td>
            <td>${classTab.cname}</td>
            <td>${classTab.count}</td>
        </tr>
    </c:forEach>
</table>
<%@include file="page.jsp"%>
</body>
</html>
