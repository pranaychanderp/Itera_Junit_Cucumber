package step_definition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.Screenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUP {
	
	WebDriver driver;
	final Properties property = new Properties();
	
//	Screenshot SS = new Screenshot();
//	String path = "/Itera_Junit_Cucumber/Test_Screenshots";

	@Given("Launch the browser")
	public void launch_the_browser() throws Throwable {
		
        FileInputStream file = new FileInputStream("C:\\Users\\Pranay Chander P\\eclipse-workspace\\Itera_BDD\\Config.properties");
        property.load(file);
        
        String browser_name = property.getProperty("Browser");
        if(browser_name.equalsIgnoreCase("Chrome")) {
        	System.setProperty("webdriver.chrome.driver", property.getProperty("driver_chrome"));
        	driver = new ChromeDriver();
        }
        else if (browser_name.equalsIgnoreCase("Edge")) {
        	System.setProperty("webdriver.edge.driver", property.getProperty("driver_edge"));
        	driver = new EdgeDriver();
        }
        else if (browser_name.equalsIgnoreCase("Firefox")) {
        	System.setProperty("webdriver.firefox.driver", property.getProperty("driver_edge"));
        	driver = new FirefoxDriver();
        }
        else {
        	System.out.println("No Browser Found");
        }
 
        driver.manage().window().maximize();
	    
	}
	@Given("Navigate to URL")
	public void navigate_to_url() throws IOException {
		driver.get(property.getProperty("URL"));
		
	}
	@When("Click on Sign Up Link")
	public void click_on_sign_up_link() {
	   driver.findElement(By.linkText("Sign Up")).click();
	    
	}
	@Then("Input Firstname")
	public void input_firstname() {
	   driver.findElement(By.id("FirstName")).sendKeys("qwerty");
	    
	}
	@Then("Input Surname")
	public void input_surname() {
	   driver.findElement(By.id("Surname")).sendKeys("jkl");
	    
	}
	@Then("Input Epost")
	public void input_epost() {
	   driver.findElement(By.id("E_post")).sendKeys("1000");
	    
	}
	@Then("Input Mobile")
	public void input_mobile() {
	   driver.findElement(By.id("Mobile")).sendKeys("9876543210");
	    
	}
	@Then("Input Username")
	public void input_username() {
	   driver.findElement(By.id("Username")).sendKeys("qwerty3");
	    
	}
	@Then("Input Password")
	public void input_password() {
	   driver.findElement(By.id("Password")).sendKeys("password");
	    
	}
	@Then("Input Confirm Password")
	public void input_confirm_password() {
	   driver.findElement(By.id("ConfirmPassword")).sendKeys("password");
	    
	}
	@Then("Click on Submit Button")
	public void click_on_submit_button() {
	   driver.findElement(By.id("submit")).click();
	    driver.quit();
	}
}
