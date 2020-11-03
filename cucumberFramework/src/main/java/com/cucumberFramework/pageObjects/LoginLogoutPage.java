package com.cucumberFramework.pageObjects;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.WaitHelper;

public class LoginLogoutPage {

	Logger logger = LoggerHelper.getLogger(LoginLogoutPage.class);
	private WebDriver driver;
	private static String expectedAmount = null;
	private static String[] amountValue;
	private static int cartItemsCount = 0;

	@FindBy(id = "loginusername")
	public WebElement userName;

	@FindBy(id = "loginpassword")
	public WebElement password;

	@FindBy(css = "#logInModal .btn-primary")
	WebElement loginButton;

	@FindBy(linkText = "Log in")
	WebElement SignInfromNav;

	@FindBy(linkText = "Log out")
	public WebElement logoutBtn;

	@FindBy(linkText = "Phones")
	public WebElement phoneCategory;

	@FindBy(linkText = "Laptops")
	public WebElement laptopCategory;

	@FindBy(linkText = "Monitors")
	public WebElement monitorCategory;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;

	@FindBy(linkText = "Cart")
	public WebElement cartButton;

	@FindBy(css = ".active > .nav-link")
	public WebElement homeButton;

	@FindBy(linkText = "Sony vaio i5")
	public WebElement sonyVaioLaptop;

	@FindBy(linkText = "Dell i7 8gb")
	public WebElement dellLaptop;

	@FindBy(linkText = "Add to cart")
	public WebElement addCartButton;

	@FindBy(xpath = "//tbody[@id='tbodyid']")
	public List<WebElement> itemList1;

	@FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[4]/a")
	public WebElement deleteAll;

	@FindBy(css = ".btn-success")
	public WebElement placeOrder;

	@FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[4]/a")
	public WebElement dellLaptopDelete;

	@FindBy(id = "name")
	public WebElement formName;

	@FindBy(id = "country")
	public WebElement formCountry;

	@FindBy(id = "city")
	public WebElement formCity;

	@FindBy(id = "card")
	public WebElement formCard;

	@FindBy(id = "month")
	public WebElement formMonth;

	@FindBy(id = "year")
	public WebElement formYear;

	@FindBy(css = "#orderModal .btn-primary")
	public WebElement purchaseButton;

	@FindBy(css = ".lead")
	public WebElement captureId;

	@FindBy(id = "totalp")
	public WebElement productAmount;

	@FindBy(css = ".confirm")
	public WebElement okBtn;
	
	
	@FindBy(xpath = "//tbody[@id='tbodyid']/tr")
	public List<WebElement> cartItems;
	
	@FindBy(xpath = "//div[@id='tbodyid']/div")
	public List<WebElement> laptopList;
	
	@FindBy(id = "tbodyid")
	public WebElement cartTable;

	@FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[")
	public WebElement deleteFirst;
	
	@FindBy(xpath = "]/td[4]/a")
	public WebElement deleteSecond;
	
			
	WaitHelper waitHelper;

	public LoginLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.WaitForElement(userName, 60);
	}
   
	/**
     * Method to enter Login- Username
     *
     */
	public void enterUserName(String userName) throws Exception {
		try {
			logger.info("Field to enter User Name");
			this.userName.sendKeys(userName);
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
  
	/**
     * Method to enter Login- Password
     *
     */
	public void enterPassword(String password) throws Exception {
		try {
			logger.info("Field to enter Password");
			this.password.sendKeys(password);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
  
	/**
     * Method to authenticate the customer login credentials
     *
     */
	public void clickLoginButton() throws Exception {
		try {
			logger.info("Button to login into the app");
			Assert.assertTrue(CommonFunctions.isElementPresent(loginButton), "Log In Button not displayed");
			loginButton.click();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
  
	/**
     * Method to Open the login screen 
     *
     */
	public void clickSignInButton() throws Exception {
		try {
			logger.info("Sign In button in the menu bar");
			Assert.assertTrue(CommonFunctions.isElementPresent(SignInfromNav), "Sign In Button not displayed");
			SignInfromNav.click();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method to clear existing products added into the cart
     *
     */
	public void clearCartItemifExist() throws Exception {
		try {
			logger.info("Within Shopping Cart");
			Assert.assertTrue(CommonFunctions.isElementPresent(cartButton),
					"Cart Button in the menu bar not displayed");
			cartButton.click();
			CommonFunctions.driverWait(3000);
			cartItemsCount = cartItems.size();
			logger.info("Sign In button in the menu bar" + cartItemsCount);
			for (cartItemsCount = 1; cartItemsCount <= cartItems.size(); cartItemsCount++) {

				Assert.assertTrue(CommonFunctions.isElementPresent(deleteAll),
						"Delete Button in the shopping cart not displayed");
				deleteAll.click();
				CommonFunctions.driverWait(5000);

			}
			logger.info("Cleared Existing Products if exist any");
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	
	/**
     * Method to add Sony Vaio Laptop to the shopping cart 
     *
     */
	public void addProductToCart() throws Exception {

		try {
			logger.info("Within Home Page to add Sony Vaio Laptop into the cart");
			cartItemsCount = laptopList.size();
			logger.info("Laptop Count :" + cartItemsCount);
			Iterator<WebElement> iter = laptopList.iterator();
			while (iter.hasNext()) {
				WebElement products = iter.next();
				logger.info("Product Name" + products.getText());
				if (products.getText().contains("Sony vaio i5")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", sonyVaioLaptop);
					CommonFunctions.driverWait(3000);
					js.executeScript("arguments[0].click();", sonyVaioLaptop);
					logger.info("Within the Sony Vaio laptop detail page");
					CommonFunctions.driverWait(3000);
					Assert.assertTrue(CommonFunctions.isElementPresent(addCartButton),
							"Add to Cart Button in the detail page not displayed");
					waitHelper.WaitForElement(addCartButton, 5);

					addCartButton.click();
					CommonFunctions.driverWait(3000);

					Alert alert = driver.switchTo().alert();
					alert.accept();
					logger.info("Sony Vaio laptop added into the cart");
					CommonFunctions.isElementEnabled(homeButton);
					clickHomeButton();
					CommonFunctions.driverWait(5000);
					break;

				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
  
	/**
     * Method to add Dell Laptop to the shopping cart 
     *
     */
	public void addDellLaptopToCart() throws Exception {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView();", laptopCategory);
			CommonFunctions.driverWait(5000);
			js.executeScript("arguments[0].click();", laptopCategory);
			CommonFunctions.driverWait(5000);
			
			cartItemsCount = laptopList.size();
			logger.info("Laptop Count :" + cartItemsCount);
			Iterator<WebElement> iter = laptopList.iterator();
			while (iter.hasNext()) {
				WebElement laptopProduct = iter.next();
				logger.info("Product Name" + laptopProduct.getText());
				if (laptopProduct.getText().contains("Dell i7 8gb")) {

					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					js1.executeScript("arguments[0].scrollIntoView();", dellLaptop);
					CommonFunctions.driverWait(5000);
					js1.executeScript("arguments[0].click();", dellLaptop);
					logger.info("Within the Dell i7 8gb laptop detail page");
					CommonFunctions.driverWait(3000);
					waitHelper.WaitForElement(addCartButton, 5);
					Assert.assertTrue(CommonFunctions.isElementPresent(addCartButton),
							"Add to Cart Button in the detail page not displayed");
					addCartButton.click();
					CommonFunctions.driverWait(3000);
					// accepting javascript alert
					Alert alert = driver.switchTo().alert();
					alert.accept();
					logger.info("Dell i7 8gb laptop added into the cart");
					waitHelper.WaitForElement(cartButton, 5);
					CommonFunctions.isElementEnabled(cartButton);
					cartButton.click();
					waitHelper.WaitForElement(dellLaptopDelete, 5);
					logger.info("Navigate to Shopping Cart");
					break;

				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
    
	/**
     * Method to delete Dell Laptop from the shopping cart
     *
     */
	public void deleteDellLaptopFromCart() throws Exception {

		try {
			

			// Get all rows
			List<WebElement> rows = cartTable.findElements(By.tagName("tr"));
			logger.info("No of cart items Count :" + rows.size());
			int counter = 0;
			// Print data from each row
			for (WebElement row : rows) {
				
				counter++;
				if (row.getText().contains("Dell i7 8gb")) {

					break;
				}
			}
			
			driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[" + counter + "]/td[4]/a")).click();
			logger.info("Dell Laptop deleted from the cart");
			CommonFunctions.driverWait(3000);
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
    
	/**
     * Method to logout from the app 
     *
     */
	public void clickLogoutButton() throws Exception {
		try {
			Assert.assertTrue(CommonFunctions.isElementPresent(logoutBtn), "Logout Button not displayed");
			logoutBtn.click();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
   
	/**
     * Method to close the Purchase Details dialog 
     *
     */
	public void clickOkButton() throws Exception {
		try {
			Assert.assertTrue(CommonFunctions.isElementPresent(okBtn), "Ok Button not displayed");
			okBtn.click();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method to submit the details customer entered in web form details 
     *
     */ 
	public void clickPurchaseOrderButton() throws Exception {
		try {
			Assert.assertTrue(CommonFunctions.isElementPresent(purchaseButton), "Purchase Button not displayed");
			purchaseButton.click();
		}

		catch (final Exception e) {
			e.printStackTrace();
		}

	}
    

	/**
     * Method to capture amount for the product added in shopping cart
     *
     */
	public void expectedAmountCapture() {
		try {
			expectedAmount = productAmount.getText();
			logger.info("Expected Amount to be Paid: " + expectedAmount);
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
   

	/**
     * Method to capture order id details.
     * Details capture- Order ID and Amount 
     *
     */
	public void captureOrderID() {
		try {
			String orderDetails = captureId.getText();
			logger.info("Order Details " + orderDetails);

			String[] orderID = orderDetails.split("\n")[0].split(":");
			String[] amount = orderDetails.split("\n")[1].split(":");
			logger.info("Order ID of the order placed : " + orderID[1]);
			logger.info("Amount Paid : " + amount[1]);
			amountValue = amount[1].split(" ");
			Assert.assertEquals(amountValue[1], expectedAmount);
			logger.info("Amount Expected matches with the amount paid for the product");
		} 
		
		catch (final Exception e) {
			e.printStackTrace();
		}

	}


	/**
     * Method to Navigate to Home Page 
     *
     */
	public void clickHomeButton() {
		try {
			Assert.assertTrue(CommonFunctions.isElementPresent(homeButton), "Home Button not displayed");
			homeButton.click();
		}

		catch (final Exception e) {
			e.printStackTrace();
		}

	}
 
	/**
     * Method to confirm shopping cart items. 
     *
     */
	public void clickPlaceOrderButton() {
		try {
			Assert.assertTrue(CommonFunctions.isElementPresent(placeOrder), "Place Order Button not displayed");
			placeOrder.click();
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method to enter Name value in web form screen
     *
     */
	public void enterFormName(String Name) {
		try {
			this.formName.sendKeys(Name);
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method to enter Country value in web form screen
     *
     */
	public void enterFormCountry(String country) {
		try {
			this.formCountry.sendKeys(country);
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method to enter City value in web form screen
     *
     */
	public void enterFormCity(String city) {
		try {
			this.formCity.sendKeys(city);
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method to enter Card details in web form screen
     *
     */
	public void enterFormCard(String card) {
		try {
			this.formCard.sendKeys(card);
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
     * Method to enter Month value in web form screen
     *
     */
	public void enterFormMonth(String month) {
		try {
			this.formMonth.sendKeys(month);
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
     * Method to enter Year value in web form screen
     *
     */
	public void enterFormYear(String year) {

		try {
			this.formYear.sendKeys(year);
		}

		catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateProductCategory() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        
		//  Page Scroll to  Product menu - Monitors and select the category
 		js.executeScript("arguments[0].scrollIntoView();", monitorCategory);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", monitorCategory);
		Thread.sleep(3000);

	    //  Page Scroll to  Product menu - Phone and select the category
		js.executeScript("arguments[0].scrollIntoView();", phoneCategory);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", phoneCategory);
		Thread.sleep(3000);

     	//  Page Scroll to  Product menu - Laptop and select the category
		js.executeScript("arguments[0].scrollIntoView();", laptopCategory);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", laptopCategory);
		Thread.sleep(5000);

	}

}
