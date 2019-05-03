<%--
  Created by IntelliJ IDEA.
  User: chenhaoyou
  Date: 2018/9/6
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入口</title>
</head>
<body>
    <p>student manage page</p>
    <a href="${pageContext.request.contextPath}/classtab/list">班级管理</a>
    <a href="${pageContext.request.contextPath}/book/save">保存书籍</a>
    <a href="${pageContext.request.contextPath}/book/look">借阅书籍</a>
    <a href="${pageContext.request.contextPath}/stu/history">借阅历史</a>
    <a href="${pageContext.request.contextPath}/stu/list">查询所有</a><br>
    <a href="${pageContext.request.contextPath}/stu/del">删除学生</a>
</body>
</html>
