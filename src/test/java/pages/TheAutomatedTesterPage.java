package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.Selenide;

import runners.CucumberRunner;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class TheAutomatedTesterPage extends CucumberRunner{
	
	CucumberRunner runn= new CucumberRunner();	
	
	By chapter1= By.xpath("//a[@href='/chapter1']");
	By text_to_verify= By.id("divontheleft");	
	By home_page= By.xpath("//a[text()= 'Home Page']");
	
	
	public void operTesterHome() throws Exception {
		System.out.print("I am going to open someting for you");		
		runn.LoadConfigProperty();		
		logger.info("******** opening homepage *********");
		open("http://book.theautomatedtester.co.uk/");
	    logger.info("******** homepage Opened *********");		
		String title= Selenide.title();
		SoftAssert assert1= new SoftAssert();
		assert1.assertEquals("Selenium: Beginners Guide", title);
		
	}
	
	public void Clickchapter1() throws Exception {
		System.out.print("I am clicking chapter 1");
		$(chapter1).click();
		logger.info("******** Chapter1 Clicked *********");
    }
	
	public void verifText() throws Exception {
		
		logger.info("******** Verifying Text present *********");
		$(text_to_verify).shouldHave(text("Assert that this text is on the page"));

	}
	
	public void NavigateToHome() throws Exception {
		$(home_page).click();		
		logger.info("******** Back to Homepage *********");			
		$(chapter1).shouldHave(text("Chapter1"));
		
		
	}
}

