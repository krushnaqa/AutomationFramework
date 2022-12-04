package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicUtility.BaseUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class StepDefinition extends BaseUtility {
	WebDriver driver;
	WebDriverWait wait;
	BaseUtility bu= new BaseUtility();
	seleniumFramework.LoginPageMethods LoginPageMethods;
	@Given("user open the Browser")
	public void user_open_the_browser() {
	    driver = bu.startUpManager("Chrome", "https://www.google.com/");
	    LoginPageMethods =new seleniumFramework.LoginPageMethods(driver,wait);
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	}
	@When("User close Browser")
	public void user_close_browser() {
		driver.close();
		driver.quit();
	}
}
