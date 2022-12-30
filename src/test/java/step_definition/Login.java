package step_definition;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	final Properties property = new Properties();

	@Given("Launch browser")
	public void launch_browser() throws Throwable {
		
			
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
	
	@Given("Navigate URL")
	public void navigate_url() {
		
		driver.get(property.getProperty("URL"));
    
	}
	
	@When("Click on Login Link")
	public void click_on_login_link() {
	    driver.findElement(By.linkText("Login")).click();
	    
	}
	
	@Then("Enter Username as {string}")
	public void enter_username(String UN) {
	    driver.findElement(By.id("Username")).sendKeys(UN);
	    
	}
	
	@Then("Enter Password as {string}")
	public void enter_password(String pwd) {
	    driver.findElement(By.id("Password")).sendKeys(pwd);
	    
	}
	
	@Then("Click on Login button")
	public void click_on_login_button() {
	    driver.findElement(By.name("login")).click();
	}
	
	@Then("Login Successfull")
	public void login_successfull() throws Throwable {
		driver.findElement(By.tagName("h3")).isDisplayed();
		driver.findElement(By.linkText("Log out")).click();
    	Thread.sleep(3000);
    	driver.close();
	}
	
	@Then("Login should fail")
	public void login_should_fail() throws Throwable {
		 
		WebElement Msg = driver.findElement(By.className("alert-danger"));
		 System.out.printf("Message is displayed? ",Msg.isDisplayed());
		 String Text = Msg.getText();
		 Assert.assertEquals("Asseration Failed", Text, "Wrong username or password");
	    Thread.sleep(5000);
	    driver.close();
	}

}
