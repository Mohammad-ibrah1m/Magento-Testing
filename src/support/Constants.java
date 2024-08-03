package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Constants {
	public static WebDriver driver = new ChromeDriver();
	public static String baseURL = "https://magento.softwaretestingboard.com/";
}
