package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import support.Constants;


public class ProductPage implements Constants{
	Random randomColor = new Random();
	Random randomSize = new Random();
	
	public void selectRandomSize() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> availableSizes = driver.findElements(By.cssSelector(".swatch-option.text"));
		int randomSizeIndex = randomSize.nextInt(availableSizes.size());
		System.out.println(randomSizeIndex);
		availableSizes.get(randomSizeIndex).click();
	}

	public void selectRandomColor() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> availableColors = driver.findElements(By.cssSelector(".swatch-option.color"));
		int randomColorIndex = randomColor.nextInt(availableColors.size());
		System.out.println(randomColorIndex);
		availableColors.get(randomColorIndex).click();
	}
	
	public void clickOnAddToCartButton() {
		driver.findElement(By.id("product-addtocart-button")).click();
	}
	
	public void clickOnCartIcon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("minicart-wrapper")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("minicart-wrapper")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message-success")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("message-success")));
		Assert.assertNotNull(driver.findElement(By.className("message-success")), "Success message doesnt exist");
		driver.findElement(By.className("minicart-wrapper")).click();
		Thread.sleep(2000);
	}
	
	public void clickOnProceedToCheckoutButton() {
		driver.findElement(By.id("top-cart-btn-checkout")).click();
	}

}
