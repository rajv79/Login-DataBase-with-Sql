package Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBaseController {

	public static void Initialize() {

		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection("USER.db");

			Statement statement = connection.createStatement();
			// this line of code will check the time if it will Query within 30 sec or not
			statement.setQueryTimeout(30);

			// now from here we will create a database and create a table

			statement.executeUpdate("DROP TABLE IF  EXISTS USER");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS USER" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "FIRSTNAME VARCHAR(50)," + "LASTNAME VARCHAR(50)," + "USERNAME VARCHAR(50) NOT NULL UNIQUE,"
					+ "PASSWORD VARCHAR(50) NOT NULL," + "PhoneNumber VARCHAR(11),"
					+ "Email VARCHAR(50) NOT NULL UNIQUE ,"

					+ " Profile BLOB NOT NULL" + ")");

			statement
					.execute("INSERT INTO USER" + "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email , Profile)"
							+ "VALUES('Nikki ','Singh','nikki1','nikki123','98789785854','abc@gmail.com', ' ')");

			statement.execute("INSERT INTO USER" + "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email,Profile)"
					+ "VALUES('Vivek ','Raj','rajv79','vivek12','66332262','bdc@gmail.com ', ' ')");

			statement.execute("INSERT INTO USER" + "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email,Profile)"
					+ "VALUES('CR7 ','Ronaldo','cr712','cr7123','10000011','cr7c@gmail.com', '' )");

			statement.execute("INSERT INTO USER" + "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email, Profile)"
					+ "VALUES('MsD ','Dhoni','Msd712','ms7123','123340011','Ms7c@gmail.com' ,' ')");

			statement.execute(
					"INSERT INTO USER " + "(FIRSTNAME ,LASTNAME ,USERNAME ,PASSWORD ,PhoneNumber,Email,Profile)"
							+ "VALUES('pinki','singh','pink1','pinki12','893432121','pi12@gmail.com','')");
			
			//statement.executeUpdate("UPDATE USER SET "
					//+ " PASSWORD = 'NIKKI1234' "
				//	+ "WHERE USERNAME = 'nikki1'");
			

			// statement.execute("UPDATE USER SET PhoneNumber= 11111111 WHERE FIRSTNAME =
			// 'CR7'");
			// statement.execute("DELETE FROM USER WHERE LastName ='Raj'");

			// Retrieving data
			// ResultSet rs = statement.executeQuery("SELECT* FROM USER");
			ResultSet rs = statement.executeQuery("SELECT * FROM USER");
			while (rs.next()) {
				System.out.println(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME") + " "
						+ rs.getString("USERNAME") + " " + rs.getString("PASSWORD") + " " + rs.getString("PhoneNumber")
						+ " " + rs.getString("Email") + " " + rs.getString("Profile"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static int loginUser(String username, String password) {

		try {

			Connection connection = null;
			connection = ConnectionUtil.getConnection("USER.db");
			Statement statement = connection.createStatement();

			String query = "SELECT *  FROM USER  WHERE USERNAME = ? ";
			System.out.println(username + " " + password);

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, username);

			User user = null;

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String first = rs.getString("FIRSTNAME");
				String last = rs.getString("LASTNAME");
				String username1 = rs.getString("USERNAME");
				String password1 = rs.getString("PASSWORD");
				String phone = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				String profile = rs.getString("Profile");

				user = new User(id, first, last, username1, password1, phone, email, profile);

			}
			connection.close();
			// 1 means username doesnt exist
			if (user == null) {
				return 1;
			}
			// 2 means password doesnt match
			if (!user.getPassword().equals(password)) {
				return 2;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}
		return 0;

	}

	public static User getUser( String user) {
		
		User user1 = null;
		try {
			Connection connection = null;
			connection = ConnectionUtil.getConnection("USER.db");
			Statement statement = connection.createStatement();
			
			
			
			ResultSet rs = statement.executeQuery("SELECT * FROM USER  WHERE USERNAME ='"+user+"'");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String first = rs.getString("FIRSTNAME");
				String last = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String phone = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				String profile = rs.getString("Profile");

				 user1 = new User(id, first, last, username, password, phone, email, profile);
				
				
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user1;

	}

	public static int signup(String first, String last, String username, String password, String phone, String email,
			String profile) {

		try {

			Connection connection = null;
			connection = ConnectionUtil.getConnection("USER.db");
			Statement statement = connection.createStatement();

			String query = "SELECT *  FROM USER  WHERE USERNAME = ? ";
			System.out.println(username + " " + password);

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			// return 1 if username is in database
			if (rs.next()) {
				return 1;

			}
			statement = connection.createStatement();
			statement.execute(
					"INSERT INTO USER " + "(FIRSTNAME ,LASTNAME ,USERNAME ,PASSWORD ,PhoneNumber,Email,Profile)"
							+ "VALUES('" + first + "' ,'" + last + "','" + username + "','" + password + "','" + phone
							+ "', '" + email + "' ,'" + profile + "')");
			
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
			return -1;

		}

		return 0;

	}

	public static int changepassword( String username ,String password) {

		try {

			/*Connection connection = null;
			connection = ConnectionUtil.getConnection("USER.db");
			Statement statement = connection.createStatement();

			String query = "SELECT *  FROM USER  WHERE USERNAME = ? ";
			
			// System.out.println(username + " "+ password);

			PreparedStatement pst = connection.prepareStatement(query);
			 pst.setString(1, username);

			ResultSet rs = pst.executeQuery();

			// return 1 if username is in database
			if (rs.next()) {
				//return 1;

			}

			 statement = connection.createStatement();

			// statement.execute("UPDATE USER SET PASSWORD = '"+password+"' "+" WHERE
			// USERNAME = ?" );
			statement.execute("UPDATE USER SET  PASSWORD ='"+password+"' "+" WHERE USERNAME =?");
			

			//statement.executeUpdate(query);
			//rs.close();*/
			
			Connection connection = null;
			connection = ConnectionUtil.getConnection("USER.db");
			//Statement statement = connection.createStatement();
			
			String query = "UPDATE USER "
					+ "SET PASSWORD = ? "
					+ "WHERE USERNAME = ?";
			
			
			PreparedStatement pst = connection.prepareStatement(query);
			
			System.out.println(password);
			pst.setString(1,password);
			pst.setString(2, username);
			System.out.println(password);
			pst.executeUpdate();
			
			
			
			
			
			
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
		
		

	}
	
	
	//---inserting Image---- in sql ---//
	
	
	
	
	//----showing userinfo ------//
	
	

	public static int showinfo(String username ,String password) {
		
		
		try {
			
			Connection connection = null;
			connection = ConnectionUtil.getConnection("USER.db");
			Statement statement = connection.createStatement();

			String query = "SELECT *  FROM USER  WHERE USERNAME = ? ";
			
			
			PreparedStatement pst = connection.prepareStatement(query);
			 pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			
			
			while (rs.next()) {
				
				
				int id = rs.getInt("ID");
				String first = rs.getString("FIRSTNAME");
				String last = rs.getString("LASTNAME");
				String username1 = rs.getString("USERNAME");
				String password1 = rs.getString("PASSWORD");
				String phone = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				String profile = rs.getString("Profile");
			
			
				System.out.println("ID:" + id);
				System.out.println("FirstName:"+ first);
				System.out.println("Lastname:" +last);
				System.out.println("Username:" +username1);
				System.out.println("password:" +password1);
				System.out.println("PhoneNumber:-" + phone);
				System.out.println("Email = " +email);
				System.out.println("Profile-" +profile);
				
			
			}
			rs.close();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/// ------------- password validation check method -------------------//

	public static boolean isValid(String password) {

		// for checking if password length
		// atlest 6 letters and max 15
		if (!((password.length() >= 6) && (password.length() <= 15))) {
			System.out.print("smalllenght");
			return false;
		}

		// to check space
		if (password.contains(" ")) {
			System.out.print("Space issue");
			return false;
		}
		if (true) {
			int count = 0;

			// check digits from 0 to 9
			for (int i = 0; i <= 9; i++) {

				// to convert int to string
				String str1 = Integer.toString(i);

				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				System.out.print("Number");
				return false;
			}
		}

		// for special characters
		if (!(password.contains("@") || password.contains("#") || password.contains("!") || password.contains("~")
				|| password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&")
				|| password.contains("*") || password.contains("(") || password.contains(")") || password.contains("-")
				|| password.contains("+") || password.contains("/") || password.contains(":") || password.contains(".")
				|| password.contains(", ") || password.contains("<") || password.contains(">") || password.contains("?")
				|| password.contains("|"))) {
			System.out.print("Special char");
			return false;
		}

		if (true) {
			int count = 0;

			// checking capital letters
			for (int i = 65; i <= 90; i++) {

				// type casting
				char c = (char) i;

				String str1 = Character.toString(c);
				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				System.out.print("Capital letter");
				return false;
			}
		}

		if (true) {
			int count = 0;

			// checking small letters
			for (int i = 90; i <= 122; i++) {

				// type casting
				char c = (char) i;
				String str1 = Character.toString(c);

				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				System.out.print("smallletter");
				return false;
			}
		}

		// if all conditions fails
		return true;
	}

	// ------------- username validation check method------------------//

	public static boolean isUserValid(String username) {

		// for checking if password length
		// atlest 6 letters and max 15
		if (!((username.length() >= 6) && (username.length() <= 15))) {
			System.out.print("smalllenght");
			return false;
		}
		// if first condition fails
		return true;

	}
}
