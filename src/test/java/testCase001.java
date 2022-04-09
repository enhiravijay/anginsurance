import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AngularPos.InputPage;
import basePage.BasePage;

public class testCase001 extends BasePage{
	
	@BeforeMethod
	
	public void before_method() throws Exception {
		openBrowser();
				
	}
	
	@Test
	public void verifyInputPage() throws Exception {
		
		InputPage iputpg = new InputPage();
		iputpg.selectcase();
		iputpg.selectPlan();
		iputpg.selectmmfv();
		iputpg.enterVehDetails();
		iputpg.enterExistingPolicyDetails();
		
		
	}
	
	
	

}
