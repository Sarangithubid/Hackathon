package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForCampus extends BasePage {

	public ForCampus(WebDriver driver) {
		super(driver);
	}
	
	//Course for campus page
		@FindBy(xpath=("//span[contains(text(),'Universities')]"))
		WebElement for_campus;
		
		//firstname
		@FindBy(xpath=("//input[@id='FirstName']"))
		WebElement firstname;
		
		//lastname
		@FindBy(xpath=("//input[@id='LastName']"))
		WebElement lastname;
		
		//mail
		@FindBy(xpath=("//input[@id='Email']"))
		WebElement mail;
		
		//mail
		@FindBy(xpath=("//input[@id='Phone']"))
		WebElement phone;
		
		//error
		@FindBy(xpath=("//div[@class='mktoError']"))
		WebElement error;
		
		public void forCampus() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", for_campus);
		}
		
		public void firstName_input() {
			firstname.sendKeys("abc");
		}
		
		public void lastName_input() {
			lastname.sendKeys("A");
		}
		
		public void mail_input() {
			mail.sendKeys("abc");
		}
		
		public void phone_input() {
			phone.sendKeys("abc");
		}
		
		public String errorMsg() {
			return error.getText();
		}			
}
