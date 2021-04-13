package Authentication;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController implements Initializable {

	Connection connection = ConnectionUtil.getConnection("User.db"); // ---check for database connection
	//// -----check for this
	@FXML
	private TextField userid;
	@FXML
	private PasswordField passid;
	@FXML
	private Button signinbtn;
	@FXML
	private Button signupbtn;

	@FXML
	private Button forgotbtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		signupbtn.setOnAction((event2) -> { // this code will help to take into new screen for registernow
			System.out.println("SignUp is pressed now press here");
			signup(event2);

		});

		forgotbtn.setOnAction((event3) -> {
			System.out.println("Forgot buttom is now pressed");
			forgot(event3);
		});

		signinbtn.setOnAction((event4) -> {
			System.out.println("Sign In button is pressed here");
			// signin(event4);
			login(event4);
		});

	}

	// ----SignUp View
	private void signupview(Event event2) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/Authentication/CreateAccount.fxml"));

			Parent parent = loader.load(); // --------------seating up for next screen
			CreateController controller = loader.getController();

			Scene scene = new Scene(parent);
			Stage window = (Stage) ((Node) event2.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void signup(Event event2) {
		signupview(event2);
	}

	// -----forgot view

	private void forgotview(Event event3) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/Authentication/PasswordChange.fxml"));
			
			

			Parent parent = loader.load(); // --------------seating up for next screen
			
			ForgotController controller = loader.getController();
			Scene scene = new Scene(parent);
			Stage window = (Stage) ((Node) event3.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void forgot(Event event3) {
		forgotview(event3);
	}

	// ---sign in view-----/////////

	private void signinview(Event event4) {

		String username = userid.getText();
		String password = passid.getText();
		
		int result1 = DataBaseController.showinfo(username, password);
		
		
		
		
		
		try {
			
			

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/Authentication/PersonalInfo.fxml"));
			

			Parent parent = loader.load(); // --------------seating up for next screen
			
			Scene scene = new Scene(parent);
			Stage window = (Stage) ((Node) event4.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	private void signin(Event event4) {
		signinview(event4);
	}

	// ___________________for checking passoword and username____________//

	private void login(Event event) { // is for the login to other page
		
		String username = userid.getText();
		String password = passid.getText();

		int result = DataBaseController.loginUser(username, password);

		if (result == 1) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Invalid UserName");
			alert.show();
			System.out.println("Invalid username");

		} else if (result == 2) {
			System.out.println("Invalid Passowrd");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Invalid Password");
			alert.show();

		} else if (result == -1) {

			System.out.println("Exception detecetd");
		} else {

			System.out.println("You are good to Go");
			
			
			
			
			signinview(event);
			
			
			
			

		}

		// System.out.println("Login");

		/*
		 * try { String query =
		 * "SELECT*FROM User.db WHERE USERNAME = ? and PASSWORD = ? "; PreparedStatement
		 * pst = connection.prepareStatement(query); pst.setString(0, userid.getText());
		 * pst.setString(1, passid.getText());
		 * 
		 * ResultSet rs = pst.executeQuery(); int count = 0; while(rs.next()) { count =
		 * count+1;
		 * 
		 * 
		 * } if(count ==1) { System.out.println("Username and Passowrd is correct");
		 * signinview(event);
		 * 
		 * }else if (count>1) { System.out.println("Duplicate username and password");
		 * }else { System.out.println("username and passowrd is not correct"); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 */
	}

}
