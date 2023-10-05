<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/10/2023
  Time: 10:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="category" items="${categories}">
    <h2>
        ${category.name}
    </h2>
</c:forEach>
</body>
</html>
