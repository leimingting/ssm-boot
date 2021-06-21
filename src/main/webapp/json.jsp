<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/5
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<button type="button" onclick="list()">查询</button>
<table id="user_table">
    <thead>
    <tr>
        <th>id</th>
        <th>账号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
</body>
<script>
    function list(){
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/jsonType",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                console.log(data);
                //请求成功时处理
                build_users_table(data);
            }
        });

        function build_users_table(data) {
            $("#user_table tbody").empty();
            const userList = data;
            $.each(userList, function (index, item) {
                const user_id = $("<td></td>").append(item.id);
                const user_code = $("<td></td>").append(item.code);
                const user_name = $("<td></td>").append(item.name);
                const user_password = $("<td></td>").append(item.password);
                const user_state = $("<td></td>").append(item.state);
                $("<tr></tr>").append(user_id).append(user_code).append(user_name).append(user_password).append(user_state).appendTo('#user_table tbody');
            })
        }
    }
</script>
</html>
