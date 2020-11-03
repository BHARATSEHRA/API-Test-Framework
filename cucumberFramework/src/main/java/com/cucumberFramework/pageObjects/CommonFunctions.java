package com.cucumberFramework.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {
	
	private WebDriver driver;
	
	 public static void driverWait(long duration) {
	        try {
	            Thread.sleep(duration);
	        } catch (InterruptedException e) {
	            // Log.info("Thread.wait failed to execute");
	        }
	    }
	    
	    public void driverWaitSessionExpiry() {
	    	try {
	            Thread.sleep(30000);
	        } catch (InterruptedException e) {
	            // Log.info("Thread.wait failed to execute");
	        }
	    }
	    
	    /**
	     * Method to valdate text.
	     *
	     * @param: Element
	     *             for the text field
	     * @param: Text
	     *             to verify
	     */
	    public boolean validateText(WebElement ae, String text) {
	        if (ae.getText().equals(text)) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    public static boolean isElementPresent(WebElement element) {
	        try {
	            element.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	        return true;
	    }
	    
	    
	    public static boolean isElementEnabled(WebElement element) {
	        try {
	            element.isEnabled();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	        return true;
	    }
	    
	    /**
	     * Method to wait for visibility of element
	     *
	     * @param ae
	     *            Android element to wait for
	     */

	    public void waitCondition(WebElement ae) {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        wait.until(ExpectedConditions.visibilityOf(ae));
	    }
	

}
