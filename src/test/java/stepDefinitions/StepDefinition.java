package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basicUtility.PropertiesFileReader;
import basicUtility.WebDriverManage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class StepDefinition {
	private WebDriver driver;
	WebDriverWait wait;
	//BaseUtility bu= new BaseUtility();
	seleniumFramework.PractisePageMethods PractisePageMethods;
	
	
	
	@Given("user open the Browser")
	public void user_open_the_browser() {
		String browser=PropertiesFileReader.getDataByKey("Browser");
		String url=PropertiesFileReader.getDataByKey("URL");
	    driver = WebDriverManage.getInstance(browser).getDriver();
	    driver.get(url);
	    PractisePageMethods =new seleniumFramework.PractisePageMethods(driver,wait);
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	}
	@When("verify user is on practise page")
	public void verify_user_is_on_practise_page() {
		PractisePageMethods.verifyPractisePageTitle();
	}
	@When("verify user is on another page")
	public void verify_user_is_on_another_page() {
	    Assert.fail();
	}
	@After()
	public void tearDown(Scenario scenario){
		
		
		//takeScreenshotOnFailure
		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			byte[] by=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(by, "image/png", scenario.getSourceTagNames().toString());
		}
		
		//close the driver
		WebDriverManage.quiteDriver();
	}

}
