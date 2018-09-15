package com.masterrad.addEditEmployeeSD;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEditEmployeeStepDef {
		
	WebDriver driver;
	
	String adminUserEmail = "admin@admin.com";
	String adminPassword = "admin";
	//http://voidthemes.com/scripts/vsmspro/admin/employee/add
	
	@Before(order=1)
	public void beforeSetupFFD() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium_WebDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Before(order=2)
	public void beforeSetupAdminLogin() throws InterruptedException {
		driver.get("http://voidthemes.com/scripts/vsmspro/login");
		driver.findElement(By.xpath("/html/body/div/form/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys(adminUserEmail);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div/form/input[2]")).sendKeys(adminPassword);
		Thread.sleep(1000);
		driver.findElement(By.className("button")).click();
	}
		
		
	@Given("^Admin User navigates to Add Employee page$")
	public void admin_user_navigates_to_add_employee_page() throws InterruptedException {
		Thread.sleep(1000);
		driver.get("http://voidthemes.com/scripts/vsmspro/admin/employee/add");
		Thread.sleep(3000);
		
	}
	
	@When("^Admin User enters Username \"([^\"]*)\"$")
	public void admin_user_enters_Username(String email) {
		driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys(email);
	}
	
	@When("^Admin enters Password \"([^\"]*)\"$")
	public void admin_enters_password(String password) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	}

	@When("Admin enters First Name \"([^\"]*)\"$")
	public void admin_enters_first_name(String firstName) {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
	}
	
	@When("Admin enters Last Name \"([^\"]*)\"$")
	public void admin_enters_last_name(String lastName) {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
	}
	
	@When("^Admin enters Mobile \"([^\"]*)\"$")
	public void admin_enters_mobile(String mobile) {
		driver.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys(mobile);
	}
	
	//Position
	@When("^Admin enters Position \"([^\"]*)\"$") 
	public void admin_enters_position(String position) {
		driver.findElement(By.xpath("//input[@placeholder='Position']")).sendKeys(position);
	}
	
	@When("^Admin selects gender \"([^\"]*)\"$")
	public void admin_selects_gender(String gender) {
		if(gender=="Male") {
			driver.findElement(By.xpath("//input[@value='male']")).click();
		} else {
			driver.findElement(By.xpath("//input[@value='male']")).click();
		}
		
	}
	
	@When("Admin enters BirthDate \"([^\"]*)\"$")
	public void admin_enters_birthdate(String birthday) {
		WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
		date.click();
		date.sendKeys("15-Dec-2014");
		date.sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//input[@type='date']")).sendKeys("06//05//2001");
	}
	
	@When("^Admin enters Address \"([^\"]*)\"$")
	public void admin_enters_address(String address) {
		driver.findElement(By.xpath("//textarea")).sendKeys(address);
	}
	
	@When("^Admin selects employee type \"([^\"]*)\"$")
	public void admin_selects_employee_type(String employeeType) {
		if(employeeType=="admin") {
			driver.findElement(By.xpath("//input[@value='admin']")).click();
		} else {
			driver.findElement(By.xpath("//input[@value='employee']")).click();
		}
	}
	
	@When("^Admin clicks CONFIRM button$")
	public void admin_clicks_confirm() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
	}
	
	@Then("^Validation messages are displayed$")
	public void validation_messages_are_displayed() {
		String emailVM = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/label/p[1]")).getText();
		String fnameVM = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/label/p[2]")).getText();
		String lnameVM = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/label/p[3]")).getText();
		String addressVM = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/label/p[4]")).getText();
		String mobileVM = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/label/p[5]")).getText();
		
		Assert.assertEquals("The Email field is required.", emailVM);
		Assert.assertEquals("The First Name field is required.", fnameVM);
		Assert.assertEquals("The Last Name field is required.", lnameVM);
		Assert.assertEquals("The Address field is required.", addressVM);
		Assert.assertEquals("The Mobile field is required.", mobileVM);
	}
	
	@Then("^Validation message are displayed$")
	public void validation_message_are_displayed() {
		String emailVM = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/label/p[1]")).getText();
		Assert.assertEquals("The Email field must contain a unique value.", emailVM);
	}
	
	
	@Given("^Admin User navigates to Edit Employee page$")
	public void admin_user_navigates_to_edit_employee_page() throws InterruptedException {
		//User must exists. For our testing purpose we used user with ID=12
		Integer id = 12;
		Thread.sleep(1000);
		driver.get("http://voidthemes.com/scripts/vsmspro/admin/employee/edit/" + id);
		Thread.sleep(3000);
	}
	
	@When("^Admin edits Mobile field \"([^\"]*)\"$")
	public void admin_edits_mobile_field(String newMobile) {
		driver.findElement(By.xpath("//input[@placeholder='Mobile']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys(newMobile);
	}
	
	@When("^Admin clicks Save button$")
	public void admin_clicks_save_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
	}
	
	@When("^Admin User clicks Delete button$")
	public void admin_user_clicks_delete_button() throws InterruptedException {
		//User must exists. For our testing purpose we used user with ID=12
	    Integer id = 25;
		Thread.sleep(1000);
		driver.get("http://voidthemes.com/scripts/vsmspro/admin/employee/delete/" + id);
		Thread.sleep(3000);
	}
	
	 @When("^Admin User confirms that he wants to delete the Employee$")
	 public void admin_user_confirms_that_he_wants_to_delete_the_employee() {
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
	 }
	
	@After
	public void tearDown() {
		driver.quit();
 		driver = null; // use null once you get done with quite
	}
	
	
}
