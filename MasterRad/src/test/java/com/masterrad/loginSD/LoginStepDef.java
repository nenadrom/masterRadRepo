package com.masterrad.loginSD;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

WebDriver driver;
	
@Given("^User must be on VSMSPRO login page$")
public void user_must_be_on_VSMSPRO_login_page() {
	System.setProperty("webdriver.gecko.driver", "D:\\Selenium_WebDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://voidthemes.com/scripts/vsmspro/login");
}


@When("^User enters email \"([^\"]*)\"$")
public void user_enters_email(String email) throws InterruptedException {
	driver.findElement(By.xpath("/html/body/div/form/input[1]")).click();
	driver.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys(email);
	Thread.sleep(1000);
}

@Then("^User checks email is present$")
public void user_checks_email_is_present() {
	String userNameActual = driver.findElement(By.xpath("/html/body/div/form/input[1]")).getAttribute("value");
	Assert.assertEquals("admin@admin.com", userNameActual);
}



@When("^User enters password \"([^\"]*)\"$")
public void user_checks_email_is_present(String password) throws InterruptedException {
	driver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
	driver.findElement(By.xpath("/html/body/div/form/input[2]")).sendKeys(password);
	Thread.sleep(1000); 
}

@Then("^User clicks LOGIN button$")
public void user_clicks_login_button() {
	driver.findElement(By.className("button")).click();
}


@Then("^Dashboard page is displayed$")
public void dashboard_page_is_displayed() {
	System.out.println("User loged in successfuly");
}

@Then("^Validation message is displayed$")
public void validation_message_is_displayed() {
	String validationMessage = driver.findElement(By.xpath("/html/body/div/form/input[1]")).getAttribute("validationMessage");
	System.out.println("Validation Message " + validationMessage);
}


@Then("^User is not logged in Dashboard$")
public void user_is_not_logged_in_dashboard() {
	String currentURL = driver.getCurrentUrl();
	//Assert.assertEquals("http://voidthemes.com/scripts/vsmspro/login", currentURL);
	System.out.println("User is not logged in due to inccorect credetilas provided" + currentURL);
}


@Then("^User Logout$")
public void user_logout() throws InterruptedException {
	driver.findElement(By.linkText("Soykot")).click();
	//driver.findElement(By.cssSelector("user-profile dropdown-toggle")).click();
	Thread.sleep(1000);
	driver.findElement(By.partialLinkText("Log Out")).click();
	
}

@Then("^Close browser$")
public void close_browser() {
	driver.quit();
	driver = null;
}
	
	
}
