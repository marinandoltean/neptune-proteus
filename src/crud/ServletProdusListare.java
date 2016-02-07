package crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Produs;

public class ServletProdusListare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) this.getServletContext().getAttribute("connection");
		LinkedList<Produs> listaProduse = new LinkedList<Produs>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT Id, Denumire, Pret, Categorie, Imagine FROM Produs";
			String cautare = request.getParameter("cautareProdus");
			if (cautare != null && cautare.length() > 0) {
				query += " WHERE Denumire LIKE '%" + cautare + "%' OR Categorie LIKE '%" + cautare + "%'";
			}
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Produs produs = new Produs(resultSet.getInt("Id"), resultSet.getString("Denumire"), resultSet.getInt("Pret"), resultSet.getString("Categorie"), resultSet.getString("Imagine"));
				listaProduse.add(produs);
			}
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("listaProduse", listaProduse);
		response.sendRedirect("produsListare.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}