package pageObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Coursera extends BasePage {
	public String ParentPage1 ;
	public String ChildPage1;
	public String ParentPage2 ;
	public String ChildPage2;
	
	public Coursera(WebDriver driver) {
		super(driver);
		}
	//InputBox
	@FindBy(xpath=("//input[@placeholder='What do you want to learn?']"))
	WebElement input;
	
	//Search
	@FindBy(xpath=("(//div[@class='magnifier-wrapper'])[2]"))
	WebElement search;
	
	//English
	@FindBy(xpath=("(//span[contains(text(),'English')])[1]"))
	WebElement english;
	
	//Beginner
	@FindBy(xpath=("(//span[contains(text(),'Beginner')])[1]"))
	WebElement beginner;
	
	//Intermediate
	@FindBy(xpath=("(//span[contains(text(),'Intermediate')])[1]"))
	WebElement intermediate;
	
	//Advanced
	@FindBy(xpath=("(//span[contains(text(),'Advanced')])[1]"))
	WebElement advanced;
	
	//Mixed
	@FindBy(xpath=("(//span[contains(text(),'Mixed')])[1]"))
	WebElement mixed;
		
	//Couser_1
	@FindBy(xpath=("(//div[@class='cds-ProductCard-gridCard'])[1]"))
	WebElement course_1;
	
	//course_name1
	@FindBy(xpath=("(//h3[@class='cds-CommonCard-title css-1sktkql'])[1]"))
	WebElement course_name1;
	
	//course_rating1
	@FindBy(xpath=("(//p[@class='cds-119 css-11uuo4b cds-121'])[1]"))
	WebElement course_rating1;
		
	//course_2
	@FindBy(xpath=("(//h3[contains(text(),'Introduction to Web Development')])[1]"))
	WebElement course_2;	

	//course_name1
	@FindBy(xpath=("(//h3[@class='cds-CommonCard-title css-1sktkql'])[2]"))
	WebElement course_name2;
	
	//course_rating2
	@FindBy(xpath=("(//p[@class='cds-119 css-11uuo4b cds-121'])[2]"))
	WebElement course_rating2;
	
	//showmore
	@FindBy(xpath=("(//span[contains(text(),'Show more')])[2]"))
	WebElement showmore;
	
	//level_list
	@FindBy(xpath=("//div[@class='css-zweepb']")) 
	//div[@class='css-zweepb']
	List <WebElement> level_list;
	
	//close
	@FindBy(xpath=("(//span[contains(text(),'Close')])[2]"))
	WebElement closepopup;
	
	//scroll
	@FindBy(xpath=("//div[@class='css-1oaiq8o']"))
	WebElement scroll;
		
	public void inputValue(String value) {
		input.sendKeys(Keys.LEFT_CONTROL + "a");
		input.sendKeys(value);
	}
	
	//clicking search button
	public void searchButton() {
		search.click();
	}
	
	//selecting english
	public void englishCheck() {
		english.click();
	}
	
	//selecting beginner 
	public void beginnerCheck() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", beginner);
	}
	
	//scroll to top
	public void scrollto() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",scroll);
		
	}
	
	public String courseName1() {
		return course_name1.getText();
	}
	
	public String courseRate1() {
		return course_rating1.getText();
	}
	
	public String courseName2() {
		return course_name2.getText();
	}
	
	public String courseRate2() {
		return course_rating2.getText();
	}
		
	//windows handle
	public void course1tab() {
		course_1.click();
		Set<String> set1 = new HashSet<String>();
		set1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(set1);
		ParentPage1 = list1.get(0);
		ChildPage1 = list1.get(1);
		driver.switchTo().window(ChildPage1);
	}
	
	//switching to first tab
	public void parent1tab() {
		driver.switchTo().window(ParentPage1);
	}
	
	public void course2tab() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", course_2);
		
		Set<String> set2 = new HashSet<String>();
		set2 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(set2);
		ParentPage2 = list2.get(0);
		ChildPage2 = list2.get(1);
		driver.switchTo().window(ChildPage2);
	}
	
	public void parent2tab() {
		driver.switchTo().window(ParentPage2);
	}
	
	//switching to second tab
	public void course2() {
		course_2.click();		
	}
	
	public void showMore() {
		showmore.click();		
	}
	
	public List<WebElement> levelList() {
		return level_list;
	}
	
	public void close() {
		closepopup.click();		
	}
	
	public void intermediateCheck() {
		intermediate.click();
	}
	
	public void advancedCheck() {
		advanced.click();
	}
	
	public void mixedCheck() {
		mixed.click();
	}
}
