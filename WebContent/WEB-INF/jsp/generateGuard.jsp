<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generate guard</title>
</head>
<body>
  <form method="get" action="/generateGuards">
      Genereeri nii mitu valvurit: <input name="count" type="text"/><br /><br />
      <input type="submit" value="Genereeri!">
  </form>

   <c:if test="${not empty guardNames}">Genereerisid valvurid nimedega: <br />
   <c:forEach var="name" items="${guardNames}">
      ${name}<br/>
  </c:forEach>
   </c:if>
</body>
</html>