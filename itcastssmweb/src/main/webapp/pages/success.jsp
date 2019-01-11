<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/5
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>登录成功</h5>
<c:forEach items="${list}" var="product">
    ${product.productname}
</c:forEach>
</body>
</html>
