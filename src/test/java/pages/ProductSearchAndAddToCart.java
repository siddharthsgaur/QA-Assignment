package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchAndAddToCart {
	WebDriver driver;
WebDriverWait wait;
	//Wait wait;
	By mCategory=By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[3]/span");
	Actions a;
	By sportShoeLink=By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/ul/li/ul/li[1]/ul/li[2]/a");
	By popularLink=By.xpath("//div[@class='D0YrLF']");
	By scrollElement=By.xpath("//*[@id=\'container\']/div/div[3]/div[2]/div/div[1]/div[2]/div[11]/div/div[2]/div/div");
	By click=By.linkText("2");
	JavascriptExecutor jse;
	By waitForNextPage=By.xpath("//span[@class='eGD5BM']");
	By specificElement=By.xpath("//a[contains(text(),'ADIRAY M Men Running Shoes For Men')]");
	By waitForElementPage=By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	By sizeLink=By.linkText("6");
	By afterCartAdd=By.xpath("//button[@class='_2AkmmA _14O7kc _7UHT_c']");
	
	public ProductSearchAndAddToCart(WebDriver driver) {
	this.driver=driver;
	wait=new WebDriverWait(driver, 10);
	jse=(JavascriptExecutor) driver;
	
	}
	
	public void hoverMensCategory() {
		 try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 a=new Actions(driver);
		  a.moveToElement(driver.findElement(mCategory)).perform();
		  
	
	}
	
	public void shoeLink() {
		 try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  driver.findElement(sportShoeLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(popularLink));
	
	}
	public void scrollToElement(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(scrollElement));
		 
		
		
	}
	public void clickElementTwoAndWait(){
		
		jse.executeScript("arguments[0].click();", driver.findElement(click));
	wait.until(ExpectedConditions.visibilityOfElementLocated(waitForNextPage));
	driver.findElement(waitForNextPage).getText().equalsIgnoreCase("Showing 41 – 80 products of 80,316 products)");

	
	}
	public void goToSpecificProductAndOpenItInNewTab(){
		
		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(specificElement));
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(specificElement).sendKeys(selectLinkOpeninNewTab);
		for (String secondWindow : driver.getWindowHandles()) {
			 
			
			driver.switchTo().window(secondWindow);
			 
			}
	wait.until(ExpectedConditions.visibilityOfElementLocated(waitForElementPage));



	}
	public void addCart() {
		jse.executeScript("arguments[0].click();", driver.findElement(sizeLink));
		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(waitForElementPage));
		jse.executeScript("arguments[0].click();", driver.findElement(waitForElementPage));
		wait.until(ExpectedConditions.visibilityOfElementLocated(afterCartAdd));
	}
	}

