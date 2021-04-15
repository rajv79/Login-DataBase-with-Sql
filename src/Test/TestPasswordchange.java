package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Authentication.DataBaseController;

public class TestPasswordchange {

	
	@Test
	//for Correct password 
	public void TestPassowrdchangeFunctionallity() {
		var b = DataBaseController.isValid("Vivek1234@");
		
		assertEquals(true,b );
	}
	
	@Test 
	//for Correct user password 
	public void TestPasswordchangeFunctionallity1() {
		var b1 = DataBaseController.isUserValid("vivvek12");
		assertEquals(true,b1);
	}
	
	@Test 
	//Change password functionality test
	public void changepassword() {
		
		String use = "hello123";
		String pass = "Hello123@";
		
		int a = DataBaseController.changepassword(use, pass);
		
		assertEquals(true,a==0);
		
		
	}
	
	
	
}
