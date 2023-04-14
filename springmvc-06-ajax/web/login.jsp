<%--
  Created by IntelliJ IDEA.
  User: STY
  Date: 2023/3/3
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.3.js">
    </script>
    <script>
        function a1(){
            $.post({
                url:"/a1",
                //键值对（k:v）
                data: {"name":$("#name").val()},
                success:function (data){

                    if (data.toString()==="ok")
                    {
                        $("username").css("color","green");
                    }
                    else {
                        $("username").css("color","red");
                    }
                    $("username").html(data);
                }
            })
        }



    </script>
</head>
<body>
<p>
    用户名: <input type="text" id="name" onblur="a1()">
    <span id="username"></span>
</p>

</body>
</html>
