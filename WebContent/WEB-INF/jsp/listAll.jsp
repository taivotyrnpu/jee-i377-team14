<%--
  Created by IntelliJ IDEA.
  User: taivo
  Date: 10/14/12
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>read</title>
</head>
<body>
	<c:forEach items="${incidents}" var="incident">  
    	 ${incident.getStart}<br />
	</c:forEach>
</body>
</html>