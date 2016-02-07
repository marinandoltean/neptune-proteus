<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaugare produs</title>
</head>
<body>
	<%@ include file="topNav.jsp" %>
	<fieldset>
		<legend>Adaugare produs nou</legend>
		<form action="ServletProdusAdaugare" method="post">
			<table>
				<tr>
					<td>Categorie</td>
					<td>
						<select name="categorieProdus">
							<option value="laptop">laptop</option>
							<option value="smartv">smartv</option>
							<option value="tableta">tableta</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Denumire</td>
					<td><input type="text" name="denumireProdus"/></td>
				</tr>
				<tr>
					<td>Pret</td>
					<td><input type="text" name="pretProdus"/></td>
				</tr>
				<tr>
					<td>Url imagine</td>
					<td><input type="text" name="urlImagineProdus"/></td>
				</tr>
			</table>
			<input type="submit" value="Adauga produs"/>
		</form>
	</fieldset>
</body>
</html>