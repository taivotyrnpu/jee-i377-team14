<%--
  Created by IntelliJ IDEA.
  User: taivo
  Date: 10/14/12
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title></title>
	<meta charset=utf-8>
</head>
<body>
	<form method="post" action="/insert">
		<table style="border-spacing: 0; border-collapse:collapse;">
			<tr>
				<td>Nimi:</td>
				<td><input type="text" name="nimi" value="" /></td>
			</tr>
			<tr>
				<td>Aadress:</td>
				<td><input type="text" name="aadress" value="" /></td>
			</tr>
            <tr>
                <td>Vanus:</td>
                <td><input type="text" name="vanus" value="" /></td>
            </tr>
			<tr>
				<td>Piirivalvurite hulk:</td>
				<td><input type="text" name="hulk" value="" /></td>
			</tr>
		</table>
		<input type="submit" value="Sisesta" />
    </form>
</body>
</html>