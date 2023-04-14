<%--
  Created by IntelliJ IDEA.
  User: STY
  Date: 2023/2/23
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json-1</title>
</head>
<body>

<script type="text/javascript">
    //编写一个js的对象
    var user = {
        name:"秦疆",
        age:3,
        sex:"男"
    };
    //将js对象转换成json字符串
    var str = JSON.stringify(user);
    console.log(str);

    //将json字符串转换为js对象
    var user2 = JSON.parse(str);
    console.log(user2.age,user2.name,user2.sex);

</script>
</body>
</html>
