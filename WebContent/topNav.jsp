<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*, java.util.*, javax.servlet.*, java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color: aliceblue">
	<%
		Date currentDate = new Date();
		String headerText = "Afaceri Electronice " + (new SimpleDateFormat("dd-MM-yyyy")).format(currentDate);
	%>
	<table width="100%" style="font-size: 30; font-family: Verdana;">	
		<tr>
			<td valign="bottom">
				<a href="index.jsp">
					FirmaFantasticaFoarteFolositoare
					<br />
					<img alt="logo" src="logo.png">
				</a>
			</td>
			<td align="right" valign="top">
				<%= headerText %>
			</td>
		</tr>
	</table>
	<hr>
		
	<hr>
</body>
</html>