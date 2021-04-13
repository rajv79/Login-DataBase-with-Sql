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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateController implements Initializable {

	@FXML
	private Button  signinbtn2;
	@FXML
	private TextField newfirstnaemfld;
	@FXML
	private TextField newlastnamefld;
	@FXML
	private TextField newuserfld;
	@FXML
	private TextField newphonefld;
	@FXML
	private TextField newemailfld;
	@FXML
	private TextField newpassfld;
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		signinbtn2.setOnAction((event3) -> { // this code will help to take into new screen for registernow
			System.out.println("Signin button is pressed now press here");
			signup(event3);
		});
		
		
	}
	
	
private void signinview(Event event3) {
		
	
	String first = newfirstnaemfld.getText();
	String last = newlastnamefld.getText();
	String username = newuserfld.getText();
	String password = newpassfld.getText();
	String phone = newphonefld.getText();
	String email = newemailfld.getText() ;
	String profile = "";
	
	if(!DataBaseController.isValid(password)) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setContentText("Invalid Password!! "
				+ " \n please Make sure your Password must be atlest 6 Letter long"
				+ " \n one lower case letter,one digit and  \n"
				+ "\n one speacial character ");
		
		alert.show();
		System.out.println("incorrect password");
		return;
	}
	
	if(!DataBaseController.isUserValid(username)) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setContentText("Make sure your password is atlest 6 letter long");
		alert.show();
		return;
	}
	
	
	int result = DataBaseController.signup(first, last, username, password, phone, email, profile);
	
	if(result == 1) {
		System.out.println("username already used");
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setContentText("UserName Already exist");
		alert.show();
	}else if(result == -1) {
		System.out.println("Exception detected");
	}else {
		System.out.println("user created");
	}
	
	
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/Authentication/LoginScreen.fxml"));
																								
			

			Parent parent = loader.load(); // --------------seating up for next screen
			
			
			Scene scene = new Scene(parent);
			Stage window = (Stage) ((Node) event3.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private void signup(Event event3) {
	signinview(event3);
}
	

		



	
}
