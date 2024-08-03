package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Constants;

public class ProductsPage implements Constants{
	private Random random = new Random();

	
	public void clickOnRandomProduct() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("product-item")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("product-item")));
		List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
		int randomProductIndex = random.nextInt(products.size());
		System.out.println(randomProductIndex);
		products.get(randomProductIndex).click();
	}

}
