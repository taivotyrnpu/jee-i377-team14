<%--
  Created by IntelliJ IDEA.
  User: taivo
  Date: 10/14/12
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auastmed</title>
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
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/res/border.js"></script>
</head>
<body>
<form action="/auaste" method="POST">
    <table>
        <tr>
            <th>Kood</th>
            <th>Nimetus</th>
            <th>Tüüp</th>
        </tr>
        <c:set var="count" value="0" scope="page" />
        <c:forEach items="${auastmed}" var="auaste">
            <tr>
                <td><input name="existing.auaste[<c:out value="${count}" />].kood" value="${auaste.kood}" /></td>
                <td><input name="existing.auaste[<c:out value="${count}" />].nimetus" value="${auaste.nimetus}" /></td>
                <td><input name="existing.auaste[<c:out value="${count}" />].tyyp" value="${auaste.tyyp}" /></td>
            </tr>
            <input type="hidden" name="existing.auaste[<c:out value="${count}" />].id" value="${auaste.id}" />
            <input type="hidden" name="existing.auaste[<c:out value="${count}" />]" value="unchanged" />
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
        <tr>
            <td colspan="3"> ------Lisa uus auaste ----------- </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="new.auaste.kood" />
            </td>
            <td>
                <input type="text" name="new.auaste.nimetus" />
            </td>
            <td>
                <input type="text" name="new.auaste.tyyp" />
            </td>
        </tr>
    </table>
    <input type="submit" value="Salvesta muudatused" />
</form>

</body>
</html>