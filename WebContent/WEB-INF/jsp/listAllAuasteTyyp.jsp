<%--
  Created by IntelliJ IDEA.
  User: taivo
  Date: 10/14/12
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auaste tüübid</title>
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
<form action="/auasteTyyp" method="POST">
    <table>
        <tr>
            <th>Kood</th>
            <th>Kommentaar</th>
            <th>Nimetus</th>
        </tr>
        <c:set var="count" value="0" scope="page" />
        <c:forEach items="${tyybid}" var="tyyp">
            <tr>
                <td><input name="existing.tyyp[<c:out value="${count}" />].kood" value="${tyyp.kood}" /></td>
                <td><input name="existing.tyyp[<c:out value="${count}" />].kommentaar" value="${tyyp.kommentaar}" /></td>
                <td><input name="existing.tyyp[<c:out value="${count}" />].nimetus" value="${tyyp.nimetus}" /></td>
            </tr>
            <input type="hidden" name="existing.tyyp[<c:out value="${count}" />].id" value="${tyyp.id}" />
            <input type="hidden" name="existing.tyyp[<c:out value="${count}" />]" value="unchanged" />
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
        <tr>
            <td colspan="3"> ------LISA UUS TÜÜP ----------- </td>
        </tr>
        <tr>
            <td>Kood<br /><input type="text" name="new.tyyp.kood"/></td>
            <td rowspan="2">Kommentaar<br /><input type="text" name="new.tyyp.kommentaar"/></td>
        </tr>
        <tr>
            <td>Nimetus<br /><input type="text" name="new.tyyp.nimetus"/></td>
        </tr>
    </table>
    <input type="submit" value="Salvesta muudatused" />
</form>

</body>
</html>