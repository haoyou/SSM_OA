<%--
  Created by IntelliJ IDEA.
  User: chenhaoyou
  Date: 2018/9/6
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--分页导航--%>
<div>
    <c:if test="${page.page == 1}">
        <a>首页</a>
        <a>上一页</a>
    </c:if>
    <c:if test="${page.page > 1}">
        <a href="${page.url}&page=1">首页</a>
        <a href="${page.url}&page=${page.page - 1}">上一页</a>
    </c:if>

    <%--循环遍历当前页码--%>
    <c:forEach items="${page.indexs}"  var="index">
        <c:if test="${index == page.page}">
            <a>${index}</a>
        </c:if>
        <c:if test="${index != page.page}">
            <a href="${page.url}&page=${index}">${index}</a>
        </c:if>
    </c:forEach>
    <c:if test="${page.page < page.pageSum}">
        <a href="${page.url}&page=${page.page + 1}">下一页</a>
        <a href="${page.url}&page=${page.pageSum}">尾页</a>
    </c:if>
    <c:if test="${page.page == page.pageSum}">
        <a>下一页</a>
        <a>尾页</a>
    </c:if>

    <a>当前第${page.page}页/共${page.pageSum}页</a>
</div>
