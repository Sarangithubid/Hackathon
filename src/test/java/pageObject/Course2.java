package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Course2 extends BasePage{

	public Course2(WebDriver driver) {
		super(driver);
	}

	//course2 tab page
	
	@FindBy(xpath=("//div[@class='cds-119 css-1h3hs08 cds-121']"))
	WebElement course_hour2;
	
	public String courseHour2() {
		String hours2 = course_hour2.getText();
		driver.close();
		return hours2 ;
	}
}
