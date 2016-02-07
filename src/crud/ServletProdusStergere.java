package crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletProdusStergere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProdus = Integer.parseInt(request.getParameter("idProdus"));
		Connection connection = (Connection) this.getServletContext().getAttribute("connection");
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Produs WHERE Id = " + idProdus);
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("ServletProdusListare");
	}
}
