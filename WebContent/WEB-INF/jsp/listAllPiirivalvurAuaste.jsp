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
    <title>Piirivalvur auastmes</title>
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
<form action="/piirivalurAuaste" method="POST">
    <table>
        <tr>
            <th>Piirivalvur</th>
            <th>Auaste</th>
            <th>Alates</th>
            <th>Kuni</th>
            <th>Kommentaar</th>
        </tr>
        <c:set var="count" value="0" scope="page" />
        <c:forEach items="${piirivalvuridAuastmes}" var="piirivalvurAuastmes">
            <tr>
                <td><input name="existing.piirivalvurAuaste[<c:out value="${count}" />].pii" value="${piirivalvurAuastmes.piirivalvurNimi}" /></td>
                <td><input name="existing.piirivalvurAuaste[<c:out value="${count}" />].nimetus" value="${piirivalvurAuastmes.auasteNimi}" /></td>
                <td><input name="existing.piirivalvurAuaste[<c:out value="${count}" />].tyyp" value="${piirivalvurAuastmes.alates}" /></td>
                <td><input name="existing.piirivalvurAuaste[<c:out value="${count}" />].tyyp" value="${piirivalvurAuastmes.kuni}" /></td>
                <td><input name="existing.piirivalvurAuaste[<c:out value="${count}" />].tyyp" value="${piirivalvurAuastmes.kommentaar}" /></td>
            </tr>
            <input type="hidden" name="existing.piirivalvurAuaste[<c:out value="${count}" />].id" value="${piirivalvurAuastmes.auaste_id}" />
            <input type="hidden" name="existing.piirivalvurAuaste[<c:out value="${count}" />].id" value="${piirivalvurAuastmes.piirivalvur_id}" />

            <input type="hidden" name="existing.piirivalvurAuaste[<c:out value="${count}" />]" value="unchanged" />
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
        <tr>
            <td colspan="3"> ------Lisa uus auaste ----------- </td>
        </tr>
        <tr>
            <td>
                <select name="new.piirivalvurAuaste.piirivalvur_id">
                    <c:forEach items="${piirivalvurid}" var="pv">
                        <option value="${pv.id}">${pv.eesnimi} ${pv.perekonnanimi}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="new.piirivalvurAuaste.nimetus">
                    <c:forEach items="${auastmed}" var="auaste">
                        <option value="${auaste.id}">${auaste.nimetus}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="text" name="new.auaste.alates" />
            </td>
            <td>
                <input type="text" name="new.auaste.kuni" />
            </td>
            <td>
                <input type="text" name="new.auaste.kommentaar" />
            </td>
        </tr>
    </table>
    <input type="submit" value="Salvesta muudatused" />
</form>

</body>
</html>