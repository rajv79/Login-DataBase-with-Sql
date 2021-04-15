package Authentication;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	@FXML
	private ImageView profileimg;
	
	
	
	
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
	
	public void setUser(User user) {
		firstfld.setText(user.getFirstName());
		lastfld.setText(user.getLastName());
		userfld.setText(user.getUserName());
		passfld.setText(user.getPassword());
		phonefld.setText(user.getPhoneNumber());
		emailfld.setText(user.getEmail());
		setImage(user.getProfile());
		
	}
	
	private void setImage(String text) {
		if(!"".equals(text.trim())) {
			
			try {
	            
				
	            byte[] bytes = Base64.getDecoder().decode(text);
	            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
	          
	            Image image = new Image(bis);
	            profileimg.setImage(image);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
			
		}
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
