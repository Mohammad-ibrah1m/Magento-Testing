package tests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductsPage;
import support.Constants;
import support.extentReportClass;

@Listeners
public class TestScenario extends extentReportClass implements Constants {
	String productName = "Shirt";
	Random random = new Random();
	HomePage homepage = new HomePage();
	ProductsPage productsPage = new ProductsPage();
	ProductPage productPage = new ProductPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	String email = "customerEmail" + random.nextInt(2938559) + "@gmail.com";
	String firstName = "John";
	String lastName = "Somebody";
	String companyName = "Some company";
	String streetAddress = "Some street";
	String city = "Some City";
	String postalCode = "P655";
	String phoneNumber = "+972589349827";

	@BeforeSuite
	public void setup() {
		driver.manage().window().maximize();
		driver.get(baseURL);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
	}

	@Test(description = "Buying a shirt happy scenario from end to end")
	public void scenario() throws InterruptedException {
		extentTest = extentReport.createTest("Verifying an end to end purchase happy scenario");
		extentTest.log(Status.INFO, "Starting test scenario");
		extentTest.log(Status.INFO, "Search for a Shirt");
		homepage.searchForProduct(productName);
		extentTest.log(Status.INFO, "Click on a random product");
		productsPage.clickOnRandomProduct();
		extentTest.log(Status.INFO, "Select a random size");
		productPage.selectRandomSize();
		extentTest.log(Status.INFO, "Select a random color");
		productPage.selectRandomColor();
		extentTest.log(Status.INFO, "Click on add to cart button");
		productPage.clickOnAddToCartButton();
		extentTest.log(Status.INFO, "Click on the cart icon in the header");
		productPage.clickOnCartIcon();
		extentTest.log(Status.INFO, "Click on the proceed to checkout button");
		productPage.clickOnProceedToCheckoutButton();
		extentTest.log(Status.INFO, "Fill customer details");
		extentTest.log(Status.INFO, "Fill in customer email");
		checkoutPage.fillEmailInput(email);
		extentTest.log(Status.INFO, "Fill in customer first name");
		checkoutPage.fillFirstNameInput(firstName);
		extentTest.log(Status.INFO, "Fill in customer last name");
		checkoutPage.fillLastNameInput(lastName);
		extentTest.log(Status.INFO, "Fill in customer company name");
		checkoutPage.fillCompanyInput(companyName);
		extentTest.log(Status.INFO, "Fill in customer street address");
		checkoutPage.fillStreetAddress(streetAddress);
		extentTest.log(Status.INFO, "Fill in customer city");
		checkoutPage.fillCity(city);
		extentTest.log(Status.INFO, "Select customer state/province");
		checkoutPage.selectStateOrProvince(5);
		extentTest.log(Status.INFO, "Fill in customer ZIP/postal code");
		checkoutPage.fillPostalCode(postalCode);
		extentTest.log(Status.INFO, "Select customer country");
		checkoutPage.selectCountry(3);
		extentTest.log(Status.INFO, "Fill in customer phone number");
		checkoutPage.fillPhoneNumber(phoneNumber);
		extentTest.log(Status.INFO, "Click on the desired payment method");
		checkoutPage.clickOnPaymentMethod();
		extentTest.log(Status.INFO, "Click on the next button");
		checkoutPage.clickOnNextButton();
		extentTest.log(Status.INFO, "Click on the place order button");
		checkoutPage.clickOnPlaceOrder();
		extentTest.log(Status.INFO, "Check if order has been placed");
		checkoutPage.checkIfOrderHasBeenPlaced();
	}

	@AfterSuite
	public void endTest() {
		 driver.quit();
	}
}
