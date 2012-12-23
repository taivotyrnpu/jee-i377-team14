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
    <title>Piirivalvurid</title>
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
<form action="/piirivalvur" method="POST">

    <c:set var="count" value="0" scope="page"/>
    <c:forEach items="${piirivalvurid}" var="piirivalvur">
        <div style="clear: right">
                <a href="#" id="toggle-pv-${count}" rel="<c:out value="${count}" />"> ${piirivalvur.eesnimi} ${piirivalvur.perekonnanimi}</a> <br />
            <table id="pv-table-${count}" style="display: none">
                <tr>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].eesnimi"
                               value="${piirivalvur.eesnimi}"/></td>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].perekonnanimi"
                               value="${piirivalvur.perekonnanimi}"/></td>
                </tr>
                <tr>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].sodurikood"
                               value="${piirivalvur.sodurikood}"/></td>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].email"
                               value="${piirivalvur.email}"/></td>
                </tr>
                <tr>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].isikukood"
                               value="${piirivalvur.isikukood}"/></td>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].telefon"
                               value="${piirivalvur.telefon}"/></td>
                </tr>
                <tr>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].eesnimi"
                               value="${piirivalvur.eesnimi}"/></td>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].aadress"
                               value="${piirivalvur.aadress}"/></td>
                </tr>
                <tr>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].perekonnanimi"
                               value="${piirivalvur.perekonnanimi}"/></td>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].kommentaar"
                               value="${piirivalvur.kommentaar}"/></td>
                </tr>
                <tr>
                    <td><input name="existing.piirivalvur[<c:out value="${count}" />].sugu"
                               value="${piirivalvur.sugu}"/></td>
                </tr>
            </table>
            <input type="hidden" name="existing.piirivalvur[<c:out value="${count}" />].id" value="${piirivalvur.id}" />
            <input type="hidden" name="existing.piirivalvur[<c:out value="${count}" />]" value="unchanged" />
        </div>
        <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
    <br />
    <br />
    <br />
    Lisa uus piirivalvur
    <br />
    <br />
    <div>
        <table>
            <tr>

                <td>Sõdurikood<br /><input type="text" name="new.piirivalvur.sodurikood" /></td>
                <td>Email<br /><input type="text" name="new.piirivalvur.email" /></td>
            </tr>
            <tr>
                <td>Isikukood<br /><input type="text" name="new.piirivalvur.isikukood" /></td>
                <td>Telefon<br /><input type="text" name="new.piirivalvur.telefon" /></td>
            </tr>
            <tr>
                <td>Eesnimi<br /><input type="text" name="new.piirivalvur.eesnimi" /></td>
                <td>Aadress<br /><input type="text" name="new.piirivalvur.aadress" /></td>
            </tr>
            <tr>
                <td>Perekonnanimi<br /><input type="text" name="new.piirivalvur.perekonnanimi" /></td>
                <td>Kommentaar<br /><input type="text" name="new.piirivalvur.kommentaar" /></td>
            </tr>
            <tr>
                <td>Sugu<br /><input type="text" name="new.piirivalvur.sugu" /></td>
            </tr>

        </table>
    </div>

   <!-- <table>
        <tr>
            <th>Eesnimi</th>
            <th>Perekonnanimi</th>
            <th>Isikukood</th>
            <!--<th>E-mail</th>
            <th>Aadress</th>
            <th>Sõdurikood</th>
            <th>Sugu</th>
            <th>Kommentaar</th>
            <th>Telefon</th>
        </tr>
        <c:set var="count" value="0" scope="page" />
        <c:forEach items="${piirivalvurid}" var="piirivalvur">
            <tr>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].eesnimi" value="${piirivalvur.eesnimi}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].perekonnanimi" value="${piirivalvur.perekonnanimi}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].isikukood" value="${piirivalvur.isikukood}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].email" value="${piirivalvur.email}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].aadress" value="${piirivalvur.aadress}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].sodurikood" value="${piirivalvur.sodurikood}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].sugu" value="${piirivalvur.sugu}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].kommentaar" value="${piirivalvur.kommentaar}" /></td>
                <td><input name="existing.piirivalvur[<c:out value="${count}" />].telefon" value="${piirivalvur.telefon}" /></td>
            </tr>
            <input type="hidden" name="existing.piirivalvur[<c:out value="${count}" />].id" value="${piirivalvur.id}" />
            <input type="hidden" name="existing.piirivalvur[<c:out value="${count}" />]" value="unchanged" />
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
        <tr>
            <td colspan="9"> ------Lisa uus piirivalvur ----------- </td>
        </tr>
        <tr>
            <td><input type="text" name="new.piirivalvur.eesnimi" /></td>
            <td><input type="text" name="new.piirivalvur.perekonnanimi" /></td>
            <td><input type="text" name="new.piirivalvur.isikukood" /></td>
            <td><input type="text" name="new.piirivalvur.email" /></td>
            <td><input type="text" name="new.piirivalvur.aadress" /></td>
            <td><input type="text" name="new.piirivalvur.sodurikood" /></td>
            <td><input type="text" name="new.piirivalvur.sugu" /></td>
            <td><input type="text" name="new.piirivalvur.kommentaar" /></td>
            <td><input type="text" name="new.piirivalvur.telefon" /></td>
        </tr>
    </table>  -->
    <br />
    <br />
    <input type="submit" value="Salvesta muudatused" />
</form>

</body>
</html>