package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Basetest.Baseclass;
import pageObject.Course1;
import pageObject.Course2;
import pageObject.Coursera;
import pageObject.ForCampus;
import utils.Excel;
import utils.ScreenShot;

public class Testcase extends Baseclass{
	
	public static String path;
	public static String path1;
	public static String path2;
	public static String path3;
	public static String path4;
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
	
	@Test(priority = 1)
	void webdevelopmentcourse() throws InterruptedException, IOException {
		
		logger.info("********Starting Testcase for Web development course********");
		System.out.println("Coursera\n");
		
		Coursera co = new Coursera(driver);
		co.inputValue("web development courses");
		co.searchButton();
		logger.info("Searching Web development courses");
		
		// searching web development courses and selecting english language and beginner level
		
		co.englishCheck();
		logger.info("Selecting english language");
		co.beginnerCheck();
		logger.info("Selecting beginner level");
		Thread.sleep(2000);
		
		System.out.println("Course : Web development courses");
		System.out.println("Language : English");
		System.out.println("Level : Beginner\n");
		
		co.scrollto();
		Thread.sleep(5000);
		
		//screenshot of courses
		path=ScreenShot.screenShot("webDevelopmentcourses", driver);
		
		c_name1 = co.courseName1();
		c_rating1 = co.courseRate1();
		
		//Switching to course 1 tab
		
		co.course1tab();
		
		Course1 c1 = new Course1(driver);
		c_hours1 = c1.courseHour1();
		logger.info("Switching to first course tab");
		co.parent1tab();
		
		System.out.println("Course details");
		System.out.println("Course Name : "+c_name1);
		System.out.println("Learning Hours : " + c_hours1);
		System.out.println("Rating : " +c_rating1);
		
		c_name2 = co.courseName2();
		c_rating2 = co.courseRate2();
				
		co.course2tab();
		
		//Switching to course 1 tab
		
		Course2 c2 = new Course2(driver);
		c_hours2 = c2.courseHour2();

		logger.info("Switching to second course tab");
		co.parent2tab();
		
		System.out.println("\nCourse Name : "+c_name2);
		System.out.println("Learning Hours : " + c_hours2);
		System.out.println("Rating : " +c_rating2);
		
		logger.info("********Finished Testcase for Web development course********");
	}
	
	@Test(priority = 2)
	void languagelearning() throws InterruptedException, IOException {
		
		logger.info("********Starting Testcase for Language Learning********");
		
		Coursera ll = new Coursera(driver);
		ll.inputValue("Language Learning");
		ll.searchButton();
		Thread.sleep(5000);
		//searching language learning 
		System.out.println("\nLanguage Learning");
		logger.info("Searching language learning");
		
		//selecting beginner level
		ll.beginnerCheck();
		System.out.println("\nLevel : Beginner");
		logger.info("Selecting Beginner level");
		
		ll.scrollto();
		ll.showMore();
		Thread.sleep(5000);
		
		List<WebElement> elements1=ll.levelList();
		list1=new ArrayList<String>();
		for(WebElement b:elements1) {
			list1.add(b.getText());
		}
		System.out.println(list1);		
		
		//screenshot of beginner level
		path1=ScreenShot.screenShot("languagelvlBeginner", driver);
		ll.close();
		ll.beginnerCheck();
		Thread.sleep(5000);
		
		//selecting intermediate level
		ll.intermediateCheck();
		System.out.println("\nLevel : Intermediate");
		logger.info("Selecting Intermediate level");
		
		ll.scrollto();
		ll.showMore();
		Thread.sleep(5000);
		
		List<WebElement> elements2=ll.levelList();
		list2=new ArrayList<String>();
		for(WebElement i:elements2) {
			list2.add(i.getText());
		}
		System.out.println(list2);
		
		//screenshot of intermediate level
		path2=ScreenShot.screenShot("languagelvlIntermediate", driver);
		ll.close();
		ll.intermediateCheck();
		Thread.sleep(5000);
		
		//selecting advanced level
		ll.advancedCheck();
		System.out.println("\nLevel : Advanced");
		logger.info("Selecting Advanced level");
		
		ll.scrollto();
		ll.showMore();
		Thread.sleep(5000);
	
		List<WebElement> elements3=ll.levelList();
		list3=new ArrayList<String>();
		for(WebElement a:elements3) {
			list3.add(a.getText());
		}
		System.out.println(list3);
		
		//screenshot of advanced level
		path3=ScreenShot.screenShot("languagelvlAdvanced", driver);
		ll.close();
		ll.advancedCheck();
		Thread.sleep(5000);
		
		//selecting mixed level
		ll.mixedCheck();
		System.out.println("\nLevel : Mixed");
		logger.info("Selecting Advanced level");
		ll.scrollto();
		ll.showMore();
		Thread.sleep(5000);
		
		List<WebElement> elements4=ll.levelList();
		list4=new ArrayList<String>();
		for(WebElement m:elements4) {
			list4.add(m.getText());
		}
		System.out.println(list4);
		
		//screenshot of mixed level
		path4=ScreenShot.screenShot("languagelvlMixed", driver);
		ll.close();
		
		logger.info("********Finished Testcase for Web development course********");
	}
	
	@Test(priority = 3)
	void form() throws IOException, InterruptedException {
		logger.info("********Starting Testcase for Course for campus********");
		
		//courses for campus
		ForCampus fo = new ForCampus(driver);
		logger.info("Switching to for Campus");
		fo.forCampus();
		logger.info("Entering invalid inputs");
		
		//entering invalid inputs
		fo.firstName_input();
		fo.lastName_input();
		fo.mail_input();
		fo.phone_input();
		Thread.sleep(2000);
		fo.mail_input();
		logger.info("Capturing error message");
		
		//capturing error message
		String errmsg = fo.errorMsg();
		Thread.sleep(2000);
		//screenshot of error 
		path=ScreenShot.screenShot("errorcapture", driver);
		System.out.println("\nCourse for Campus"+"\nError Message Captured");
		System.out.println("Mail : "+errmsg+"\n");
		
		Excel.excel(c_name1,c_hours1,c_rating1,c_name2,c_hours2,c_rating2,list1,list2,list3,list4,errmsg);
		
		logger.info("********Finished Testcase for Web development course********");
				
	}
	
}
