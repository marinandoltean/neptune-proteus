package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
	private static Connection connection = null;

    public void contextInitialized(ServletContextEvent e) {
    	ServletContext context = e.getServletContext();
		String database = context.getInitParameter("DbName");
		String dataBasePath = context.getRealPath("DataBases\\"+database);
		try {
			Class.forName("org.sqlite.JDBC");  
	        connection = DriverManager  
	                .getConnection("jdbc:sqlite:" + dataBasePath); 
			if ((connection !=null) && (!connection.isClosed())) {
				context.setAttribute("connection", connection);
				System.out.println("Conectat la baza de date " + database);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
    }

    public void contextDestroyed(ServletContextEvent e) {
    	try {
			connection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }
	
}
