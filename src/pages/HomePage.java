package pages;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Constants;

public class HomePage implements Constants{

	Random random = new Random();

	public void searchForProduct(String productName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		driver.findElement(By.id("search")).sendKeys(productName + Keys.ENTER);
	}

}
