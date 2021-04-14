package Authentication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(getClass().getResource("LoginScreen.fxml"));// this pointing to next view//

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		//DataBaseController.Initialize(); 
		launch(args);

		//DataBaseController.Initialize(); 
		/*
		 * Connection connection = null;
		 * 
		 * 
		 * try { connection = ConnectionUtil.getConnection("USER.db");
		 * 
		 * 
		 * Statement statement = connection.createStatement(); //this line of code will
		 * check the time if it will Query within 30 sec or not
		 * statement.setQueryTimeout(30);
		 * 
		 * 
		 * //now from here we will create a database and create a table
		 * 
		 * statement.executeUpdate("DROP TABLE IF  EXISTS USER");
		 * 
		 * statement.executeUpdate("CREATE TABLE IF NOT EXISTS USER" +
		 * "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "FIRSTNAME VARCHAR(50),"
		 * +"LASTNAME VARCHAR(50)," +"USERNAME VARCHAR(50) NOT NULL UNIQUE,"
		 * +"PASSWORD VARCHAR(50) NOT NULL," +"PhoneNumber INTEGER,"
		 * +"Email VARCHAR(50) NOT NULL UNIQUE "
		 * 
		 * +")");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * statement.execute("INSERT INTO USER" +
		 * "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email)"+
		 * "VALUES('Nikki ','Singh','nikki1','nikki123','98789785854','abc@gmail.com')"
		 * );
		 * 
		 * statement.execute("INSERT INTO USER" +
		 * "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email)"+
		 * "VALUES('Vivek ','Raj','rajv79','vivek12','66332262','bdc@gmail.com')");
		 * 
		 * 
		 * statement.execute("INSERT INTO USER" +
		 * "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email)"+
		 * "VALUES('CR7 ','Ronaldo','cr712','cr7123','10000011','cr7c@gmail.com')");
		 * 
		 * statement.execute("INSERT INTO USER" +
		 * "(FIRSTNAME ,LASTNAME, USERNAME,PASSWORD,PhoneNumber,Email)"+
		 * "VALUES('MsD ','Dhoni','Msd712','ms7123','123340011','Ms7c@gmail.com')");
		 * 
		 * //statement.
		 * execute("UPDATE USER SET PhoneNumber= 11111111  WHERE FIRSTNAME = 'CR7'");
		 * //statement.execute("DELETE FROM USER WHERE LastName ='Raj'");
		 * 
		 * 
		 * 
		 * //Retrieving data //ResultSet rs =
		 * statement.executeQuery("SELECT* FROM USER"); ResultSet rs =
		 * statement.executeQuery("SELECT * FROM USER"); while(rs.next()) {
		 * System.out.println(rs.getString("FIRSTNAME") + " "+ rs.getString("LASTNAME")+
		 * " "+ rs.getString("USERNAME")+" " + rs.getString("PASSWORD")+ " " +
		 * rs.getString("PhoneNumber")); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
		 */
	}
}
