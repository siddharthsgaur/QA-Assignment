package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Login;
import pages.ProductSearchAndAddToCart;

public class StepDefinitions {
	String LoginURL;
	private Properties properties;
	private final String propertyFilePath = "src/test/java/propertyfile/PropertyFile.properties";
	static String reportConfigPath;
	private WebDriver driver;
	Login loginObj;
	ProductSearchAndAddToCart psaatc;
	static String LoginPassword;
	BufferedReader reader;
	WebDriverWait wait;
	
	
	public StepDefinitions() throws FileNotFoundException {
	    reader = new BufferedReader(new FileReader(propertyFilePath));
	    properties = new Properties();
	    try {

	        properties.load(reader);
	        LoginURL = properties.getProperty("Loginurl");
	        
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	}
	


	@Given("^I have flikart url$")
	public void i_have_flikart_url() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		loginObj=new Login(driver);
		psaatc=new ProductSearchAndAddToCart(driver);
		
		
	}

	@When("^I hit the flipkart url in browser$")
	public void i_hit_the_url() {
		driver.get(LoginURL);
	}

	@Then("^flipkart home page should be loaded$")
	public void flipkart_home_page_should_be_loaded() {
	    String WinTitle=driver.getTitle();
	    assertTrue("Home page not loaded", WinTitle.contains("Online Shopping Site"));
	    driver.quit();
	}
	
	@When("^I wait for the popup window$")
	public void i_close_the_popup_window() {
		
	loginObj.waitPopup();
	}

	@When("^I enter (.*?) and (.*?)$")
	public void i_click_on_Login_Signup(String UN,String PW)  {
	   loginObj.enterData(UN,PW);
	   
	}

	@And("^I click login$")
	public void popup_should_open_for_login() {
		loginObj.loginBtn();
	}
	@And("^Login should be successfull$")
	public void login_successfull() {
		loginObj.loginSuccessCheck();
	}
	
	@Then("^I hover over men category$")
	public void i_hover_over_men_category() {
	   psaatc.hoverMensCategory();
	}

	@Then("^Click sports shoes$")
	public void click_sports_shoes(){
	    psaatc.shoeLink();
	}

	@Then("^I scroll down to bottom$")
	public void i_scroll_down_to_bottom(){
		psaatc.scrollToElement();

	}

	@Then("^Go to page two$")
	public void go_to_page_two(){
		psaatc.clickElementTwoAndWait();
	
	}
	@Then("^open the specific product$")
	public void goToSpecificProduct() {
		psaatc.goToSpecificProductAndOpenItInNewTab();
	
	}
	@Then("^Add it to cart$")
	public void add_it_to_cart() {
	 psaatc.addCart();
	}
	
}
