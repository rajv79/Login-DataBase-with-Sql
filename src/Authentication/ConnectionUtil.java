package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionUtil {

	public static  Connection getConnection(String databaseName) {
		try {
			Class.forName("org.sqlite.JDBC");
			
			return DriverManager.getConnection("jdbc:sqlite:" +databaseName);
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		System.out.println("Connection connected");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		return null;
	}
	
	
	//this line of code will help to close the connection from sql database
	
	public static boolean closeConnection(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
