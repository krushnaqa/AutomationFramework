package basicUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManage {
	
	
	private static volatile WebDriverManage instance;
	private static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	private WebDriverManage() {}

	private void initDriver(String browser) {
		switch(browser) {
		case "Chrome":
			tlDriver.set(new ChromeDriver());
			tlDriver.get().manage().window().maximize();
			tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
			
		case "Edge":
			tlDriver.set(new EdgeDriver());
			tlDriver.get().manage().window().maximize();
			tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
			
		case "Firefox":
			tlDriver.set(new FirefoxDriver());
			tlDriver.get().manage().window().maximize();
			tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			break;
			
		default:
			throw new IllegalArgumentException("Unsupported browser: "+ browser);
		}
	}

	public static WebDriverManage getInstance(String browser) {
		if(instance==null) {
			synchronized (WebDriverManage.class) {
				if(instance ==null) {
					instance = new WebDriverManage();
				}
			}
		}
		
		if(tlDriver.get()==null) {
			instance.initDriver(browser);
		}
		
		return instance;
	}
	
	public WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quiteDriver() {
		if(tlDriver!=null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}
}
