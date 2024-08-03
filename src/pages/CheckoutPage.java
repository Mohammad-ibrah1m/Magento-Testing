package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Constants;

public class CheckoutPage implements Constants {

	public void fillEmailInput(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer-email")));

		driver.findElement(By.id("customer-email")).sendKeys(email);
	}

	public void fillFirstNameInput(String firstName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.name("firstname")).sendKeys(firstName);
	}

	public void fillLastNameInput(String lastName) {
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	}

	public void fillCompanyInput(String company) {
		driver.findElement(By.name("company")).sendKeys(company);
	}

	public void fillStreetAddress(String streetAddress) {
		driver.findElement(By.name("street[0]")).sendKeys(streetAddress);
	}

	public void fillCity(String city) {
		driver.findElement(By.name("city")).sendKeys(city);
	}

	public void selectStateOrProvince(int regionIndex) {
		WebElement select = driver.findElement(By.name("region_id"));
		Select regionSelector = new Select(select);
		regionSelector.selectByIndex(regionIndex);
	}

	public void fillPostalCode(String postalCode) {
		driver.findElement(By.name("postcode")).sendKeys(postalCode);
	}

	public void selectCountry(int countryIndex) {
		WebElement select = driver.findElement(By.name("country_id"));
		Select countrySelector = new Select(select);
		countrySelector.selectByIndex(countryIndex);
	}

	public void fillPhoneNumber(String number) {
		driver.findElement(By.name("telephone")).sendKeys(number);
	}

	public void clickOnPaymentMethod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("label_carrier_flatrate_flatrate")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("label_carrier_flatrate_flatrate")));
		driver.findElement(By.id("label_carrier_flatrate_flatrate")).click();
	}

	public void clickOnNextButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("continue")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("continue")));
		driver.findElement(By.className("continue")).click();
	}

	public void clickOnPlaceOrder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("checkout")));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("checkout")));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".action.primary.checkout")).click();
	}

	public void checkIfOrderHasBeenPlaced() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("base")));
		WebElement orderMadeMessage = driver.findElement(By.className("checkout-success"));
		System.out.println("Order number is :" + orderMadeMessage.findElement(By.tagName("span")).getText());
	}

}
