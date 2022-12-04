package seleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageMethods {

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPageMethods(WebDriver driver, WebDriverWait wait) {
		this.wait=wait;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='xyz']")
	public WebElement user;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
