package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection databaseLink;
	
	public Connection getconnection() {
		String databaseName = "*";
		String databaseUser = "*";
		String databasePassword = "*";
		String url = "*" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
		} catch(Exception e) {
			
		}
		return databaseLink;
	}
}
