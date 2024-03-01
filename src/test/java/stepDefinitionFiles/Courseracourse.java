package stepDefinitionFiles;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Course1;
import pageObject.Course2;
import pageObject.Coursera;
import pageObject.ForCampus;
import utils.Excel;
import utils.ScreenShot;

public class Courseracourse {
	
	public static String path;
	String c_name1;
	String c_rating1;
	String c_hours1;
	String c_name2;
	String c_rating2;
	String c_hours2;
	List<String> list1;
	List<String> list2;
	List<String> list3;
	List<String> list4;
	
	public WebDriver driver;
	
	@Given("Search web development courses")
	public void Search_web_development_courses() {
		System.out.println("Choose browser \n 1.Chrome \n 2.Edge");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a==1) {
			System.out.println("Running in Chrome\n");
			driver=new ChromeDriver();
		}
		else if(a==2) {
			System.out.println("Running in Edge\n");
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Select Valid Browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org");
		Coursera co = new Coursera(driver);
		co.inputValue("web development courses");
		co.searchButton();	    
	}

	@When("Selecting Beginner level and English Language")
	public void Selecting_Beginner_level_and_English_Language() {
		Coursera co = new Coursera(driver);
		co.englishCheck();
		co.beginnerCheck();
		System.out.println("Course : Web development courses");
		System.out.println("Language : English");
		System.out.println("Level : Beginner\n");
	}

	@Then("Extract the course details")
	public void extract_the_course_details() {
		Coursera co = new Coursera(driver);
		c_name1 = co.courseName1();
		c_rating1 = co.courseRate1();
		co.course1tab();
		Course1 c1 = new Course1(driver);
		c_hours1 = c1.courseHour1();
		co.parent1tab();
		
		System.out.println("Course details");
		System.out.println("Course Name : "+c_name1);
		System.out.println("Learning Hours : " + c_hours1);
		System.out.println("Rating : " +c_rating1);
		
		c_name2 = co.courseName2();
		c_rating2 = co.courseRate2();
		co.course2tab();
		Course2 c2 = new Course2(driver);
		c_hours2 = c2.courseHour2();
		co.parent2tab();
		System.out.println("\nCourse Name : "+c_name2);
		System.out.println("Learning Hours : " + c_hours2);
		System.out.println("Rating : " +c_rating2);
	}

	@Then("Search Language Learning")
	public void search_language_learning() {
		Coursera ll = new Coursera(driver);
		ll.inputValue("Language Learning");
		ll.searchButton();
		System.out.println("\nLanguage Learning");
	}

	@Then("Extract all languages in different level")
	public void extract_all_languages_in_different_level() throws IOException {
		Coursera ll = new Coursera(driver);
		
		//Beginner
		ll.beginnerCheck();
		System.out.println("\nLevel : Beginner");
		ll.scrollto();
		ll.showMore();
		List<WebElement> elements1=ll.levelList();
		list1=new ArrayList<String>();
		for(WebElement b:elements1) {
			list1.add(b.getText());
		}
		System.out.println(list1);
		path=ScreenShot.screenShot("languagelvlBeginner", driver);
		ll.close();
		ll.beginnerCheck();
		
		//Intermediate
		ll.intermediateCheck();
		System.out.println("\nLevel : Intermediate");
		ll.scrollto();
		ll.showMore();
		List<WebElement> elements2=ll.levelList();
		list2=new ArrayList<String>();
		for(WebElement i:elements2) {
			list2.add(i.getText());
		}
		System.out.println(list2);
		
		path=ScreenShot.screenShot("languagelvlIntermediate", driver);
		ll.close();
		ll.intermediateCheck();
		
		//Advanced
		ll.advancedCheck();
		System.out.println("\nLevel : Advanced");
		ll.scrollto();
		ll.showMore();
		List<WebElement> elements3=ll.levelList();
		list3=new ArrayList<String>();
		for(WebElement a:elements3) {
			list3.add(a.getText());
		}
		System.out.println(list3);
		
		path=ScreenShot.screenShot("languagelvlAdvanced", driver);
		ll.close();
		ll.advancedCheck();
		
		//Mixed
		ll.mixedCheck();
		System.out.println("\nLevel : Mixed");
		ll.scrollto();
		ll.showMore();
		List<WebElement> elements4=ll.levelList();
		list4=new ArrayList<String>();
		for(WebElement m:elements4) {
			list4.add(m.getText());
		}
		System.out.println(list4);
		path=ScreenShot.screenShot("languagelvlMixed", driver);
		ll.close();
	}

	@Then("Navigate to Courses for Campus")
	public void navigate_to_courses_for_campus() {
		ForCampus fo = new ForCampus(driver);
		fo.forCampus();
	}

	@Then("fill the invalid inputs")
	public void fill_the_invalid_inputs() throws IOException {
		ForCampus fo = new ForCampus(driver);
		fo.firstName_input();
		fo.lastName_input();
		fo.mail_input();
		fo.phone_input();
		fo.mail_input();
		String errmsg = fo.errorMsg();
		path=ScreenShot.screenShot("errorcapture", driver);
		System.out.println("\nCourse for Campus"+"\nError Message Captured");
		System.out.println("Mail : "+errmsg+"\n");
		Excel.excel(c_name1,c_hours1,c_rating1,c_name2,c_hours2,c_rating2,list1,list2,list3,list4,errmsg);
	}

	@Then("Capture and Display the error message")
	public void capture_and_display_the_error_message() {
	   driver.quit();
	   System.out.println("Browser closed");
	}
}
