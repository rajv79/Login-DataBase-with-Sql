package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Authentication.DataBaseController;

public class TestPasswordchange {

	
	@Test
	public void TestPassowrdchangeFunctionallity() {
		var b = DataBaseController.isValid("Vivek1234@");
		//int result = DataBaseController.changepassword("nikki1", "Nikki12345@");
		//assertTrue(result ==-1);
		assertEquals(true,b );
	}
	
	
	
}
