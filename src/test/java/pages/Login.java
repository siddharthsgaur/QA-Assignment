package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Login {
WebDriver driver;
WebDriverWait wait;
By username=By.cssSelector("input._2zrpKA");
By password=By.xpath("//input[@class='_2zrpKA _3v41xv']");

By btn=By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");

By loginsuccess=By.xpath("//div[@class='dHGf8H']");


public Login(WebDriver driver) {
	this.driver=driver;
	wait=new WebDriverWait(driver, 10);
}

public void waitPopup() 
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(username));

}
public void enterData(String un,String Pw) 
{
	
driver.findElement(username).click();
driver.findElement(username).sendKeys(un);
driver.findElement(password).click();
driver.findElement(password).sendKeys(Pw);

}
public void loginBtn(){
	driver.findElement(btn).click();
}
public void loginSuccessCheck(){
	assertTrue("Login not successfull", driver.findElement(loginsuccess).getText().equalsIgnoreCase("siddharth")||driver.findElement(loginsuccess).getText().equalsIgnoreCase("more"));
}
}
