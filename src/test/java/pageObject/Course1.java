package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Course1 extends BasePage {
	public Course1(WebDriver driver) {
		super(driver);
	}
	
//course1 tab page
	
	@FindBy(xpath=("(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[8]"))
	WebElement course_hour1;
	
	public String courseHour1() {
		String hours1 = course_hour1.getText();
		driver.close();
		return hours1 ;
	}	
}
