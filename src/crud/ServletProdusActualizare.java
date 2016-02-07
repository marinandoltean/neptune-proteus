package crud;

import helper.Helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletProdusActualizare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idProdus"));
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
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Produs SET" +
					" Categorie = ?, Denumire = ?, Pret = ?, Imagine = ? WHERE Id = ?");
			
			preparedStatement.setString(1, categorie);
			preparedStatement.setString(2, denumire);
			preparedStatement.setInt(3, pret);
			preparedStatement.setString(4, imagine);
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("ServletProdusListare");
	}
}
