package com.cucumberFramework.stepdefinitions;


import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.CommonFunctions;
import com.cucumberFramework.pageObjects.LoginLogoutPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginLogoutPageStepDefinitions extends TestBase {

	LoginLogoutPage loginPage = new LoginLogoutPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);

	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String arg1) throws Throwable {
		driver.get(arg1);
	
	}

	@Then("^I click on sign in button and wait for sign in page$")
	public void i_click_on_sign_in_button_and_wait_for_sign_in_page() throws Throwable {

		loginPage.clickSignInButton();
		waitHelper.WaitForElement(loginPage.userName, 60);
	}

	@Then("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		loginPage.userName.isDisplayed();
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String arg1) throws Throwable {
		loginPage.enterUserName(arg1);
		CommonFunctions.driverWait(2000);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String arg1) throws Throwable {
		loginPage.enterPassword(arg1);
		CommonFunctions.driverWait(2000);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		loginPage.clickLoginButton();
		CommonFunctions.driverWait(2000);
	}

	@When("^I am logged in$")
	public void i_am_already_logged_in() throws Throwable {
		waitHelper.WaitForElement(loginPage.logoutBtn, 5);

	}

	@When("^I Click on Sign out$")
	public void i_Click_on_Sign_out() throws Throwable {
		loginPage.clickLogoutButton();
		waitHelper.WaitForElement(loginPage.userName, 60);
	}

	@When("^I Click on Ok button$")
	public void i_Click_on_Ok_button() throws Throwable {
		loginPage.clickOkButton();
		waitHelper.WaitForElement(loginPage.homeButton, 5);
	}

	@Then("^I got log out from the application and land on sign in page$")
	public void i_got_log_out_from_the_application_and_land_on_sign_in_page() throws Throwable {
		CommonFunctions.isElementPresent(loginPage.userName);
		// loginPage.userName.isDisplayed();
	}

	@Then("^I click home button from menu bar to continue shopping$")
	public void I_click_home_button_from_menu_bar_to_continue_shopping() throws Throwable {
		CommonFunctions.isElementPresent(loginPage.homeButton);
		// loginPage.homeButton.isDisplayed();
		loginPage.clickHomeButton();
		CommonFunctions.isElementPresent(loginPage.phoneCategory);
		// loginPage.phoneCategory.isDisplayed();
	}

	@Then("^I navigate to different product categories from left menu$")
	public void I_navigate_to_different_product_categories_from_left_menu() throws Throwable {
		loginPage.navigateProductCategory();
	}

	@Then("^I choose laptop Sony vaio i5 and added to the cart$")
	public void I_choose_laptop_Sony_vaio_i5_and_added_to_the_cart() throws Throwable {
		loginPage.addProductToCart();

	}

	@Then("^I choose laptop Dell i7 8gb and added to the cart$")
	public void I_choose_laptop_Dell_i7_8gb_and_added_to_the_cart() throws Throwable {
		loginPage.addDellLaptopToCart();
	}

	@Then("^I opt to delete laptop Dell i7 8gb from the cart$")
	public void i_opt_to_delete_laptop_Dell_i7_8gb_from_the_cart() throws Throwable {
		loginPage.deleteDellLaptopFromCart();
		waitHelper.WaitForElement(loginPage.placeOrder, 5);

	}

	@Then("^I capture amount to be paid$")
	public void i_capture_amount_to_be_paid() throws Throwable {
		loginPage.expectedAmountCapture();

	}

	@Then("^click on place order button$")
	public void click_on_place_order_button() throws Throwable {
		loginPage.clickPlaceOrderButton();
		waitHelper.WaitForElement(loginPage.formName, 5);

	}

	@Then("^I enter Name as \"([^\"]*)\" and Country as \"([^\"]*)\" and City as \"([^\"]*)\" and Card as \"([^\"]*)\" and Month as \"([^\"]*)\" and Year as \"([^\"]*)\"$")
	public void fill_the_web_form_fields(String name, String country, String city, String card, String month,
			String year) throws Throwable {
		loginPage.enterFormName(name);
		loginPage.enterFormCountry(country);
		loginPage.enterFormCity(city);
		loginPage.enterFormCard(card);
		loginPage.enterFormMonth(month);
		loginPage.enterFormYear(year);
		CommonFunctions.driverWait(2000);

	}

	@Then("^I click on purchase order button$")
	public void I_click_on_purchase_order_button() throws Throwable {
		loginPage.clickPurchaseOrderButton();
		CommonFunctions.driverWait(2000);

	}

	@Then("^I capture Order details and verify with expected amount$")
	public void i_capture_order_details_and_verify_with_expected_amount() throws Throwable {
		loginPage.captureOrderID();

	}

	@Then("^I clear cart items if any$")
	public void i_clear_cart_items_if_any() throws Throwable {
		loginPage.clearCartItemifExist();
	}

}