package stepdefinitions;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String chromeDriverPath = System.setProperty("webdriver.chrome.driver",
			projectPath + "\\drivers\\chromedriver.exe");
	String url = "https://parabank.parasoft.com/parabank/index.htm";
	
	@Given("Chrome is opened and PB app is opened")
	public void chrome_is_opened_and_PB_app_is_opened() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		
	 }

	@When("User enters correct Username and Password")
	public void user_enters_correct_Username_and_Password() {
		
		WebElement usernameTextbox = driver.findElement(By.name("username"));
		usernameTextbox.sendKeys("john");
		
		WebElement passwordTextbox = driver.findElement(By.name("password"));
		passwordTextbox.sendKeys("demo");

		
	 }

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginButton.click();
		
		
	 }

	@Then("It shows home page")
	public void it_shows_home_page() throws InterruptedException {
		String expectedTitle = "ParaBank | Accounts Overview";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);
		
		WebElement LogoutButton = driver.findElement(By.linkText("Log Out"));
		LogoutButton.click();
		Thread.sleep(2000);
		driver.quit();
	 }

}
