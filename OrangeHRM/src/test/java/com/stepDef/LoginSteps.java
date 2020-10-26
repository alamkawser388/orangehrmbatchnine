package com.stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageFactory.LoginpageOrange;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	LoginpageOrange ruhi;
	
	@Given("^user open web browser and navigate to HRM login screen$")
	public void user_open_web_browser_and_navigate_to_HRM_login_screen() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		ruhi= PageFactory.initElements(driver, LoginpageOrange.class);

	}

	@Then("^user Navigate to Page and verify the Page Title is \"([^\"]*)\"$")
	public void user_Navigate_to_Page_and_verify_the_Page_Title_is(String arg1) throws Throwable {
		String actual = driver.getTitle();
		String expected = "OrangeHRM";
		Assert.assertTrue("This Title is Wrong",actual.contains(expected));
		

	}

	@Then("^user enter a valid username and password$")
	public void user_enter_a_valid_username_and_password() throws Throwable {
		//driver.findElement(By.xpath("//*[@name='txtUsername']")).sendKeys("admin");
		//driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("admin123");
		
		ruhi.getUsername().sendKeys("admin");
		ruhi.getPassword().sendKeys("admin123");
		

	}

	@Then("^user click the Sign in button$")
	public void user_click_the_Sign_in_button() throws Throwable {
		
		//driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		WebElement login = driver.findElement(By.xpath("//*[@id='btnLogin']"));
		login.click();
		
		
		//String actual = driver.getTitle();
		//String expected = "OrangeHRM";
		//Assert.assertTrue("This Title is Wrong",actual.contains(expected));
		

	}

	@When("^user click on log out button for Orange Hrm$")
	public void user_click_on_log_out_button_for_Orange_Hrm() throws Throwable {
		
		
		WebElement welcome = driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
		welcome.click();
		WebElement logout = driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
	
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(logout)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logout.click();
		
		
		

	}

}



