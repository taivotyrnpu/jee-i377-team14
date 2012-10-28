<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get params</title>
</head>
<body>

<form method="get" action="/searchGuard">
    Otsi valvurit:<br />
    Nimi: <input type="text" name="nimi" /><br />
    Vanus: <input type="text" name="vanus" /><br />
    <input type="submit" value="Otsi" />
</form>
<c:if test="${not empty nimed}">
    <c:forEach var="nimi" items="${nimed}">
        ${nimi}<br/>
    </c:forEach>
</c:if>

</body>
</html>