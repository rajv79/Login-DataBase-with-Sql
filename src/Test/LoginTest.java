package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Authentication.DataBaseController;
import Authentication.User;

public class LoginTest {

	
	@Test
	public void TestloginFuctionallity() {
		
		
		
		int result = DataBaseController.loginUser(null, "Sad1234@"); // login is good
		assertTrue(result==1);
		
		
		
		
	}
	
	
	
}
