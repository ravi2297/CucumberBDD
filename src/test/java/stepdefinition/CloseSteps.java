package stepdefinition;

import io.cucumber.java.en.Then;

public class CloseSteps extends BaseClass {

	@Then("close browser")
	public void close_browser() {
		driver.close();
		Log.info("Browser closed");
	    
	}
}
