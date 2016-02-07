package crud;

import helper.Helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletProdusAdaugare extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categorie = request.getParameter("categorieProdus");
		String denumire = request.getParameter("denumireProdus");
		int pret = Integer.parseInt(request.getParameter("pretProdus"));
		String urlImagine = request.getParameter("urlImagineProdus");
		String imagine = null;
		
		if (urlImagine != null) {
			imagine = Helper.ImageHelper.GetBase64Encoding(urlImagine);
		}
		
		Connection connection = (Connection) this.getServletContext().getAttribute("connection");
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Produs(Id, Categorie, Denumire, Pret, Imagine) VALUES(null,'" + categorie + "','" + denumire + "'," + pret + ", '" + imagine + "')");
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("ServletProdusListare");
	}
}
