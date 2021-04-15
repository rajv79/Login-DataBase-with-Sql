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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotController implements Initializable {

	@FXML
	private TextField userid;
	@FXML
	private TextField newpassid;
	@FXML
	private TextField conpassid;
	@FXML
	private Button signinbtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		signinbtn.setOnAction((event1) -> {
			System.out.println("Forgot buttom is now pressed");
			signin(event1);
		});

	}

	private void signinview(Event event1) {

		String username = userid.getText();
		String newpass = newpassid.getText();

		if (!DataBaseController.isValid(newpass)) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText(
					"Invalid Password!! " + " \n please Make sure your Password must be atlest 6 Letter long"
							+ " \n one lower case letter,one digit and  \n" + "\n one speacial character ");

			alert.show();
			System.out.println("incorrect password");
			return;
		}

		System.out.println(username + " " + newpass);

		int result = DataBaseController.changepassword(username, newpass);

		// 1 means password got change for that user

		if (result == 1) {

			System.out.println("Exception !!");
		} else {
			// System.out.println(username + " " + newpass);

			System.out.println("password Changed susscefully");

		}

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

	private void signin(Event event1) {
		signinview(event1);
	}

/// ----password validation code-----------------//

}