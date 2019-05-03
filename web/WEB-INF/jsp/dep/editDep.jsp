<%--
  Created by IntelliJ IDEA.
  User: chenhaoyou
  Date: 2018/9/8
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
    <!-- Reset Stylesheet -->
    <link rel="stylesheet" href="resources/css/reset.css" type="text/css"
          media="screen" />
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="resources/css/style.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
          media="screen" />

    <!--                       Javascripts                       -->
    <!-- jQuery -->
    <script type="text/javascript"
            src="resources/scripts/jquery-1.3.2.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script>
</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">
                <table>
                    <thead>
                    <tr>

                        <th>ID</th>
                        <th>PID</th>
                        <th>DNAME</th>
                        <th>DESC</th>
                        <th>OPERATION</th>
                    </tr>
                    </thead>
                    <
                    <form action="${pageContext.request.contextPath}/dep/update?id=${deps.id}" method="post">
                        <tbody>
                        <tr>
                            <td>${deps.id}</td>
                            <td><input name="pid" type="text" value="${deps.pid}"></td>
                            <td><input name="name" type="text" value="${deps.name}"></td>
                            <td><input name="ddesc" type="text" value="${deps.ddesc}"></td>
                            <td><input name="createtime" type="text" value="${deps.createtime}"></td>
                            <td><input name="orderfield" type="text" value="${deps.orderfield}"></td>

                        </tr>
                        <tr>
                            <td><input  type="submit" value="提交"></td>
                        </tr>
                        </tbody>


                    </form>
                    <tbody>
                        <tr>
                            <td>${id}</td>
                        </tr>
                    </tbody>
                </table>


            </div>
        </div>
        <!-- End .content-box-content -->
    </div>
</div>
<!-- End #main-content -->
</body>
</html>