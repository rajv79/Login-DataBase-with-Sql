package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Authentication.DataBaseController;
import Authentication.User;

public class LoginTest {

	
	@Test // Login test for login functionality 
	public void TestloginFuctionallity() {
		
		int result = DataBaseController.loginUser("Abc1234", "Sad1234@"); // login is good
		assertTrue(result==1);
		
		
	}
	
	@Test //Login Test for login functionality 
	
	public void TestLoginFunctionality() {
		int result = DataBaseController.loginUser("ABCDE123","aBCDE");
		assertTrue(result ==1);
		
	}
	
	
	
}
