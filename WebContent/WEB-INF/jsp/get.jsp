<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get params</title>
</head>
<body>
	<c:forEach var="get" items="${gets}">
    	${get}
    </c:forEach>
</body>
</html>