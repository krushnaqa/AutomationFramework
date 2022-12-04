package basicUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtility {
public static GenericUtility gu=new GenericUtility();
public void scrollElementTillElement(WebElement ele,WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor)driver;//typecasting is done here.
	js.executeScript("arguments[0].scrollIntoView(true)", ele);
}
public void clickElement(WebElement ele,WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", ele);
}
public void scrollElementByValue(WebDriver driver,int a,int b) {
	JavascriptExecutor js=(JavascriptExecutor)driver;//typecasting is done here.
	js.executeScript("window.scrollBy("+a,b+")");
}
public void implciteWait(WebDriver driver,int seconds) {
	driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
}	


}
