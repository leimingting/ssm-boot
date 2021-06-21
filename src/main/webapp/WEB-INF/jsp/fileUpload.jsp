<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/28
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <script>
        function check(){
            const name = document.getElementById('name').value;
            const file=document.getElementById('file').value;
            if (name==""){
                alert("填写上传人");
                return false;
            }
            if (file==""){
                alert("请选择上传文件");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data" onsubmit="check()">
    上传人：<input id="name" type="text" name="name" ><br/>
    请选择文件：<input id="file" type="file" name="uploadFile" multiple="multiple"><br/>
    <input type="submit" value="上传">
</form>
<a href="${pageContext.request.contextPath}/download">文件下载</a>
</body>
</html>
