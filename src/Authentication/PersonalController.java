package Authentication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonalController implements Initializable {
	
	
	@FXML
	private Button logoutbtn;
	
	@FXML
	private Button changepassbtn;

	@FXML
	private TextField firstfld;
	
	@FXML
	private TextField lastfld;
	
	@FXML
	private TextField userfld;
	
	@FXML
	private TextField passfld;
	@FXML
	private TextField phonefld;
	@FXML
	private TextField emailfld;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		
	
		logoutbtn.setOnAction((event1)->{
			System.out.println("Logout button is pressed");
			logoutview(event1);
		});
		
		changepassbtn.setOnAction((event2)->{
			System.out.println("Change password button is pressed");
			passchanged(event2);
		});
		
	}
	
	
private void logout(Event event1) {
		
		try {
			
			

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/Authentication/LoginScreen.fxml"));
																								
			

			Parent parent = loader.load(); // --------------seating up for next screen
			
			
			
			Scene scene = new Scene(parent);
			Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private void logoutview(Event event1) {
	logout(event1);
	}


private void changepassview(Event event2) {
	
	
	
	try {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Authentication/PasswordChange.fxml"));
																							
		

		Parent parent = loader.load(); // --------------seating up for next screen
		
		
		
		Scene scene = new Scene(parent);
		Stage window = (Stage) ((Node) event2.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		
		
		
		

	} catch (Exception e) {
		e.printStackTrace();
	}
}


private void passchanged(Event event2) {
	changepassview(event2);
}
	
	

}
