package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lead_definition {
	
	ChromeOptions options = new ChromeOptions();
	WebDriver driver = new ChromeDriver(options.addArguments("--disable-notifications"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Before
	public void beforescenario() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://login.salesforce.com/");
	}
	@After
	public void afterscenario() {
		System.out.println("after scenario");
		driver.quit();
	}
	@Given("Logged into Salesforce and present in Home Page")
	public void logged_into_salesforce_and_present_in_home_page() {
		driver.findElement(By.id("username")).sendKeys("kyasasoumya@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pandu@2020");
		driver.findElement(By.id("Login")).click();
		System.out.println(driver.getTitle());
	    
	}
	@When("Goto App Launcher and click on View All")
	public void goto_app_launcher_and_click_on_view_all() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		
	   
	}

	@When("Select Sales from App launcher")
	public void select_sales_from_app_launcher() {
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("sales");
		driver.findElement(By.xpath("//div [@data-name='Sales']")).click();
	   
	}

	@When("User is on Sales Dashboard and Click on Leads")
	public void user_is_on_sales_dashboard_and_click_on_leads() throws InterruptedException {
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		js.executeScript("arguments[0].click();", leads);
		Thread.sleep(6000);
		
	    
	}
	@When("Click on New,to create a New lead")
	public void click_on_new_to_create_a_new_lead() throws InterruptedException {
		WebElement NewLeads = driver.findElement(By.xpath("//button[text()='New']"));
		NewLeads.click();
		Thread.sleep(6000);
		String titleNewLeads = driver.findElement(By.xpath("//h2[text()='New Lead']")).getText();
		System.out.println(titleNewLeads);
	   
	}

	@When("Enter all mandatory fields {string} {string},{string}")
	public void enter_all_mandatory_fields(String First_name, String Last_Name, String company) {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(First_name);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Last_Name);
		driver.findElement(By.xpath("//label[text()='Company']/following::input[1]")).sendKeys(company);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();

		
	}

	@Then("Lead should be created with the given name successfully.")
	public void lead_should_be_created_with_the_given_name_successfully() {
		String msg = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(msg);
	    	    
	}


}
