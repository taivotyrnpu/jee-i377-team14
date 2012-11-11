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
    <title>Intsidentide vaatamine</title>
	<style>
	table, td, th {
		border:1px solid green;
	}
	th {
		background-color:green;
		color:white;
	}
	table tr:nth-child(odd){
		background-color: lime;
	}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>Algus</th>
			<th>Lõpp</th>
			<th>Asukoht</th>
			<th>Kirjeldus</th>
			<th>Valvurite arv</th>
			<th>Staatus</th>
		</tr>
		<c:forEach items="${incidents}" var="incident">  
	    	 <tr>
	    	 	<td>${incident.getEnd}</td>
	    	 	<td>${incident.getStart}</td>
	    	 	<td>${incident.getLocation}</td>
	    	 	<td>${incident.getDescription}</td>
	    	 	<td>${incident.getInvolvedGuardCount}</td>
	    	 	<td>${incident.getStatus}</td>
	    	 </tr>
		</c:forEach>
	</table>
</body>
</html>