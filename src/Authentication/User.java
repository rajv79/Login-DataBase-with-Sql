package Authentication;

import java.io.File;
import java.io.FileInputStream;

import javafx.scene.image.Image;

public class User {

	private int id;

	private String firstName;

	private String lastName;

	private String userName;
	private String Password;
	private String phoneNumber;
	private String email;
	private String profile; ////------------- look this line  for image  and if it doesnt work then change to private String profile

	

	public User(int id, String firstName, String lastName, String userName, String password, String phoneNumber,
			String email, String profile) { ///------------ look at this line where image = profile
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		Password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.profile = profile;
		// this.ImgURI = ImgURI;
		// this.file= file;

	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() { //---- look here this code  to change the code for image and then change to string Image
		return profile;
	}

	public void setProfile(String profile) { //---- look here this code  to change the code for image and then change to string Image
		this.profile = profile;
	}

}
