package step_definition;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Customer {

	WebDriver driver;
	final Properties property = new Properties();

	@Given("Open browser")
	public void open_browser() throws Throwable {
	    
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
	
	@Given("Open URL")
	public void open_url() {
		driver.get(property.getProperty("URL"));
	    
	}
	@When("Click on Login")
	public void click_on_login() {
		driver.findElement(By.linkText("Login")).click();
	    
	}

	@Then("Input Username as {string}")
	public void enter_username(String UN) {
	    driver.findElement(By.id("Username")).sendKeys(UN);
	    
	}
	
	@Then("Input Password as {string}")
	public void enter_password(String pwd) {
	    driver.findElement(By.id("Password")).sendKeys(pwd);
	    
	}
	
	@Then("Click on the Login button")
	public void click_on_login_button() {
	    driver.findElement(By.name("login")).click();
	}
	
	@Then("Click on Create New button")
	public void click_on_create_new_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();

	    
	}
	@Then("Input Customer Name as {string}")
	public void input_customer_name_as(String name) {
	    driver.findElement(By.id("Name")).sendKeys(name);

	    
	}
	@Then("Input Customer Company as {string}")
	public void input_customer_company_as(String company) {
		driver.findElement(By.id("Company")).sendKeys(company);
		   
	    
	}
	@Then("Input Customer Address as {string}")
	public void input_customer_address_as(String address) {
	    driver.findElement(By.id("Address")).sendKeys(address);

	    
	}
	@Then("Input Customer City as {string}")
	public void input_customer_city_as(String city) {
	    driver.findElement(By.id("City")).sendKeys(city);
	    
	}
	@Then("Input Customer Phone as {string}")
	public void input_customer_phone_as(String phone) {
	    driver.findElement(By.id("Phone")).sendKeys(phone);

	    
	}
	@Then("Input Customer Email as {string}")
	public void input_customer_email_as(String email) {
		driver.findElement(By.id("Email")).sendKeys(email);
	    
	}
	@Then("Click on Create button")
	public void click_on_create_button() {
		driver.findElement(By.xpath("//input[@value='Create']")).click();
	    
	}
	@Then("Verify customer is added in the list")
	public void verify_customer_is_added_in_the_list() {
		driver.findElement(By.id("searching")).sendKeys("ACP");
	    driver.findElement(By.xpath("//input[@value='Search']")).click();
	   WebElement Table = driver.findElement(By.xpath("//table[@class='table table-hover']")); //To locate table
	   List < WebElement > rows_table = Table.findElements(By.tagName("tr")); // To locate rows of table
	   int rows_count = rows_table.size(); //To calculate no of rows In table
	   
	   for (int row = 0; row < rows_count; row++) {
	   	    //To locate columns(cells) of that specific row.
	   	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	   	    int cols_count = Columns_row.size(); //To calculate no of cols In specific row 
	   	   System.out.println("Number of cells In Row " + row + " are " + cols_count);
	   for (int column = 0; column < cols_count; column++) {
	        // To retrieve text from that specific cell.
	        String celtext = Columns_row.get(column).getText();
	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
	    }
	   System.out.println("-------------------------------------------------- ");
	   } 
	}
	@Then("Click on Logout Link")
	public void click_on_logout_link() {
	    driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	    driver.close();
	}
	@Then("Input the customer name or email in search box")
	public void input_the_customer_name_or_email_in_search_box() {
		driver.findElement(By.id("searching")).sendKeys("ACP");
	    
	}
	@Then("Click on Search button")
	public void click_on_search_button() {
		driver.findElement(By.xpath("//input[@value='Search']")).click();
	    
	}
	@Then("Click on Edit")
	public void click_on_edit() throws Throwable {
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
	    
	}
	@Then("Edit the customer details")
	public void edit_the_customer_details() {
		WebElement City = driver.findElement(By.id("City"));
		City.clear();
		City.sendKeys("Florida");
	    
	}
	@Then("Click on Save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//input[@value='Save']")).click();
	    
	}
	@Then("Verify updated details is updated in the table")
	public void verify_updated_details_is_updated_in_the_table() {
		Customer search = new Customer();
		driver.findElement(By.id("searching")).sendKeys("ACP");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		
		WebElement Table = driver.findElement(By.xpath("//table[@class='table table-hover']")); //To locate table
		   List < WebElement > rows_table = Table.findElements(By.tagName("tr")); // To locate rows of table
		   int rows_count = rows_table.size(); //To calculate no of rows In table
		   
		   for (int row = 0; row < rows_count; row++) {
		   	    //To locate columns(cells) of that specific row.
		   	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		   	    int cols_count = Columns_row.size(); //To calculate no of cols In specific row 
		   	   System.out.println("Number of cells In Row " + row + " are " + cols_count);
		   for (int column = 0; column < cols_count; column++) {
		        // To retrieve text from that specific cell.
		        String celtext = Columns_row.get(column).getText();
		        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
		    }
		   System.out.println("-------------------------------------------------- ");
		   } 
	}
	
	@Then("Click on Delete")
	public void click_on_delete() {
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
	    
	}
	@Then("Click on Delete button")
	public void click_on_delete_button() {
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
	    
	}


}
