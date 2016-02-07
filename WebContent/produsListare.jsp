<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="beans.Produs"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listare produse</title>
<link rel="stylesheet" href="Styles/styles.css">
<script src="Scripts/sorttable.js"></script>
</head>
<body>
	<%@ include file="topNav.jsp" %>
	
	<%
		LinkedList listaProduse = (LinkedList)session.getAttribute("listaProduse");
	%>
	<form action="produsAdaugare.jsp">
		<input type="submit" value="Adauga un produs nou">
	</form>
	<br />
	<form action="ServletProdusListare">
		<input type="text" name="cautareProdus">
		<input type="submit" value="Cautare">
	</form>	
	<br />
	
	<table cellpadding="2px" class="sortable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Categorie</th>
				<th>Denumire</th>
				<th>Pret</th>
				<th>Imagine</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < listaProduse.size(); i++) {
				Produs produs = (Produs)listaProduse.get(i);
		%>
				<tr>
					<td width='10%'> 
						<%=produs.getId()%> 
					</td>
					<td width='20%'> 
						<%=produs.getCategorie()%> 
					</td>
					<td width='20%'> 
						<%=produs.getDenumire()%> 
					</td>
					<td width='10%'> 
						<%=produs.getPret()%> 
					</td>
					<td width='30%'> 
						<img class="resize" alt="<%=produs.getDenumire()%>" src="data:image/png;base64,<%=produs.getImagine()%>">
					</td>
					<td width='10%'>
						<form action="produsActualizare.jsp">
							<input type="hidden" name="idProdus" value="<%=produs.getId()%>"/>
							<input type="hidden" name="categorieProdus" value="<%=produs.getCategorie()%>"/>
							<input type="hidden" name="denumireProdus" value="<%=produs.getDenumire()%>"/>
							<input type="hidden" name="pretProdus" value="<%=produs.getPret()%>"/>
							<input type='submit' value='Actualizare'/>
						</form>	
						<form action="ServletProdusStergere" method="get" onsubmit="if(!confirm('Confirma stergerea produsului <%=produs.getDenumire() %>')){ return false; }">
							<input type="hidden" name="idProdus" value="<%=produs.getId()%>"/>
							<input type='submit' value='Stergere'/>
						</form>	
					</td>
				</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>