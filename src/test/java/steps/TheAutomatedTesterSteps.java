package steps;

import cucumber.api.java.en.*;
import pages.TheAutomatedTesterPage;

public class TheAutomatedTesterSteps {
		
	TheAutomatedTesterPage auto_page= new TheAutomatedTesterPage();
	
	@Given("^I am on the home page of Automated Tester$")
	public void open_home_automated_testers() throws Exception  {
	    // Write code here that turns the phrase above into concrete actions
	    auto_page.operTesterHome();
	}

	@And("^I click on link \"([^\"]*)\" chapter$")
	public void clickChapter1(String chapter) throws Exception{
	    // Write code here that turns the phrase above into concrete actions
		auto_page.Clickchapter1();
	}
	

	@And("^I verify the text present on the opened page$")
	public void Verifying_Text_present() throws Exception  {
	    // Write code here that turns the phrase above into concrete actions
		auto_page.verifText();
	}

	@And("^I navigate back to the home page$")
	public void Navigate_back_to_home() throws Exception  {
	    // Write code here that turns the phrase above into concrete actions
	    auto_page.NavigateToHome();
	}

}
