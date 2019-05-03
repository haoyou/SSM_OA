<%--
  Created by IntelliJ IDEA.
  User: chenhaoyou
  Date: 2018/9/7
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            src="resources/scripts/jquery-1.8.3.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script>
    <%--弹出框JS resources/widget/dialog/jquery-ui-1.9.2.custom.min.js--%>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script type="text/javascript" src="resources/widget/dialog/jquery-ui-1.9.2.custom.min.js"></script>

    <%--引入ZTREE--%>
    <link rel="stylesheet" href="resources/widget/zTree/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="resources/widget/zTree/jquery.ztree.all.min.js"></script>

    <%--自定义脚本实现--%>
    <script type="text/javascript">
        function adddep_showdialog(){
            $("#adddep_div").dialog({
                title:"添加部门",
                width:"60%",
                height:600,

                modal:true
            });
        }
        
        function  show_depztree(button) {


                $.ajax({
                    url:"${pageContext.request.contextPath}/dep/queryAllJson",
                    type:"post",
                    success:function (data) {
                        //生成ztree
                        var setting={
                            data:{
                                //开启简单的json
                                simpleData:{
                                    enable:true,
                                    idKey:"id",
                                    pIdKey:"pid"
                                },
                                key:{
                                    name:"dname"
                                }
                            },
                            callback:{
                                onClick:function (event,treeId,treeNode) {
                                    button.value = treeNode.dname;
                                    $(".pid").val(treeNode.id);
                                    $("#depztree").dialog("close");
                                }
                            }
                        }
                        //树形根节点
                        var nodes = data;
                        //生成
                        var ztreeobj = $.fn.zTree.init($("#ztree"),setting,nodes);
                        ztreeobj.expandAll(true);
                    },
                    dataType:"json"
                });


            $("#depztree").dialog({
                title:"添加父部门",
                width:"48%",
                height:400,
                modal:true
            });
        }
    </script>
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
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>ID</th>
                        <th>PID</th>
                        <th>DNAME</th>
                        <th>DESC</th>
                        <th>CREATETIME</th>
                        <th>OPERATION</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${departments}" var="deps">
                    <tr>
                        <td><input type="checkbox" /></td>
                            <td>${deps.id}</td>
                            <td>${deps.pid}</td>
                            <td>${deps.dname}</td>
                            <td>${deps.ddesc}</td>
                            <td><fmt:formatDate value="${deps.createtime}" pattern="yyyy-MM-dd"/></td>

                        <td>
                            <a href="${pageContext.request.contextPath}/dep/depinsert" title="insert">
                                <img src="resources/images/icons/pencil.png" alt="Edit"/>
                            </a>
                            <a href="${pageContext.request.contextPath}/dep/depdel?id=${deps.id}" title="Delete">
                                <img src="resources/images/icons/cross.png" alt="Delete"/>
                            </a>
                            <a href="${pageContext.request.contextPath}/dep/edit?id=${deps.id}" title="Edit Meta">
                                <img src="resources/images/icons/hammer_screwdriver.png"
                                alt="Edit Meta"/>
                            </a>
                        </td>

                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="bulk-actions align-left">
                    <a id="adddep_button" class="mybutton" onclick="adddep_showdialog()">Apply to selected</a>
                </div>
                <div class="pagination">
                    <c:if test="${page.page ==1}">
                        <a  title="First Page"></a>
                        <a  title="Previous Page"></a>
                    </c:if>
                    <c:if test="${page.page > 1}">
                        <a href="${page.url}&page=1" title="First Page">&laquo; First</a>
                        <a href="${page.url}&page=${page.page-1}" title="Previous Page">&laquo; Previous</a>
                    </c:if>
                    <c:forEach items="${page.indexs}" var="indexs">
                        <c:if test="${indexs == page.page}">
                            <a  class="number current">${indexs}</a>
                        </c:if>
                        <c:if test="${indexs != page.page}">
                            <a href="${page.url}&page=${indexs}" class="number" >${indexs}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${page.page == page.pageSum}">
                        <a  title="Next Page"></a>
                        <a  title="Last Page"></a>
                    </c:if>
                    <c:if test="${page.page < page.pageSum}">
                        <a href="${page.url}&page=${page.page+1}" title="Next Page">Next &raquo;</a>
                        <a href="${page.url}&page=${page.pageSum}" title="Last Page">Last&raquo;</a>
                    </c:if>
            </div>
            </div>
        </div>
        <!-- End .content-box-content -->
    </div>
</div>
<!-- End #main-content -->


<!-- 添加部门的弹出框 -->
<div id="adddep_div" style="display:none;">
    <%--<div id="main-content">--%>
     <div class="content-box">
    <div class="content-box-content">
        <div class="tab-content default-tab" id="tab2">
            <form action="${pageContext.request.contextPath }/dep/save" method="post">
                <input class="pid" type="hidden" name="pid" value="-1"/>
                <fieldset>
                    <p>
                        <label>部门名称</label> <input class="text-input small-input"
                                                   type="text"  name="dname" />
                    </p>
                    <p>
                        <label>选择父部门</label> <input class="mybutton" type="button" onclick="show_depztree(this)"
                                                    value="无" />
                    </p>
                    <p>
                        <label>部门简介</label>
                        <textarea class="text-input textarea wysiwyg" id="textarea"
                                  name="ddesc" cols="79" rows="15"></textarea>
                    </p>
                    <p>
                        <label>成立时间</label> <input class="text-input small-input"
                                                   type="date" id="small-input" name="createtime" />
                    </p>
                    <p>
                        <input class="mybutton" type="submit" value="提交" />
                    </p>
                </fieldset>
                <div class="clear"></div>
                <!-- End .clear -->
            </form>
        </div>
    </div>

</div>
</div>


<%--父部门弹出框--%>
<div id="depztree" style="display: none;">
    <div id="ztree" class="ztree">

    </div>
</div>
</body>
</html>
