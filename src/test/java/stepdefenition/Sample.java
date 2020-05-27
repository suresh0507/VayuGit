package stepdefenition;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Sample {
	
	public WebDriver driver;
	
	@Given("Launch Browser and Get the Base URL")
	public void launch_Browser_and_Get_the_Base_URL() {
		System.out.println("launch_Browser_and_Get_the_Base_URL()");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User Inputs the username and password")
	public void user_Inputs_the_username_and_password() {
		System.out.println("user_Inputs_the_username_and_password()");
		driver.findElement(By.xpath("//a[contains(text(),'Registry')]")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_Button() {
		System.out.println("user_clicks_on_Login_Button()");
		driver.findElement(By.xpath("//div[@class='login']//input@class='button']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Able to Successfuly login")
	public void able_to_Successfuly_login() {
		System.out.println("able_to_Successfuly_login()");
		String str = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        Assert.assertEquals(str,"Welcome","Sucessful login!");
        driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	public void register(){
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Suresh");
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sivaraman");
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("C-4 Central Excise");
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Chennai");
        driver.findElement(By.id("customer.address.state")).sendKeys("TamilNadu");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("600034");
        driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9940496345");
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("1234567");
    }
    
    public void credentials(){
        int i =5;
        driver.findElement(By.name("customer.username")).sendKeys("admin"+i);
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("password"+i);
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("password"+i);
        i=i+1;
    }

 

}


