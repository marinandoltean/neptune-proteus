<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizare produs</title>
<link rel="stylesheet" href="Styles/styles.css">
</head>
<body>
	<%@ include file="topNav.jsp" %>
	
	<%
		int idProdus = Integer.parseInt(request.getParameter("idProdus"));
		String categorieProdus = request.getParameter("categorieProdus");
		String denumireProdus = request.getParameter("denumireProdus");
		int pretProdus = Integer.parseInt(request.getParameter("pretProdus"));
	%>							
							
	<fieldset>
		<legend>Modificare proprietati <%=denumireProdus%></legend>
		<form action="ServletProdusActualizare" method="post">
			<input type="hidden" name="idProdus" value=<%=idProdus%>> 
			<table>
				<tr>
					<td>Categorie</td>
					<td><input type="text" name="categorieProdus" value="<%=categorieProdus%>"/></td>
				</tr>
				<tr>
					<td>Denumire</td>
					<td><input type="text" name="denumireProdus" value="<%=denumireProdus%>"/></td>
				</tr>
				<tr>
					<td>Pret</td>
					<td><input type="text" name="pretProdus" value=<%=pretProdus%>></td>
				</tr>
				<tr>
					<td>Url imagine</td>
					<td><input type="text" name="urlImagineProdus"/></td>
				</tr>
			</table>
			<input type="submit" value="Salveaza modificarile"/>
		</form>
	</fieldset>
</body>
</html>

