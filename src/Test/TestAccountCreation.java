package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Authentication.DataBaseController;
import Authentication.User;

public class TestAccountCreation {
	
	@Test
	public void TestccountCreationFunctionallity() {
		
		int result = DataBaseController.signup("nikki", "singh", "nikki1", "Jane1234@", "9879094110", "abcd@gmai.com", " ");
		assertTrue(result ==1);
	}
	
	//@Test
	public void TestAccountCreationFunctionallity() {
		int result = DataBaseController.signup("Jane", "eli", "Jane987@", "eli1234@", "87673832", "bdcf@gamil.com", " ");
		
		assertEquals(true,result==0);
		//assertTrue(result ==1);
	}

}
