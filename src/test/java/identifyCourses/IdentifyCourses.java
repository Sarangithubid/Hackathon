//package identifyCourses;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//public class IdentifyCourses {
//	WebDriver driver;
//	
//	
//	@Test(priority = 1)
//	void launchBrowser() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		System.out.println("Browser Launched\n");
//	}
//	
//	@Test(priority = 2)
//	void coursera() throws InterruptedException, IOException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://www.coursera.org");
//		System.out.println("coursera\n");
//		Thread.sleep(5000);
//		screenshot.screenShot("screenshot1",driver);
//	}
//	
//	@Test(priority = 3)
//	void courseSearch() throws InterruptedException, IOException {
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		WebElement input =  driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
//		input.sendKeys("web development courses");
//		Thread.sleep(5000);
//		
//		WebElement search =  driver.findElement(By.xpath("(//div[@class='magnifier-wrapper'])[2]"));
//		search.click();
//		System.out.println("Course : Web development");
//		Thread.sleep(5000);
//		
//		WebElement english = driver.findElement(By.xpath("(//span[contains(text(),'English')])[1]"));
//		english.click();
//		System.out.println("Language : English");
//		Thread.sleep(5000);
//		
//		WebElement level = driver.findElement(By.xpath("(//span[contains(text(),'Beginner')])[1]"));
//		level.click();
//		System.out.println("Level : Beginner\n");
//		Thread.sleep(5000);
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,-630)");
//		Thread.sleep(5000);
//		screenshot.screenShot("screenshot2",driver);
//		
//	}
//	
//	@Test(priority = 4)
//	void couserDetails() throws InterruptedException, IOException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		WebElement C1 = driver.findElement(By.xpath("(//h3[@class='cds-CommonCard-title css-1sktkql'])[1]"));
//		String course1 = C1.getText();
//		
//		WebElement R1 = driver.findElement(By.xpath("(//p[@class='cds-119 css-11uuo4b cds-121'])[1]"));
//		String rating1 = R1.getText();
//		
//		WebElement C2 = driver.findElement(By.xpath("(//h3[@class='cds-CommonCard-title css-1sktkql'])[2]"));
//		String course2 = C2.getText();
//		
//		WebElement R2 = driver.findElement(By.xpath("(//p[@class='cds-119 css-11uuo4b cds-121'])[2]"));
//		String rating2 = R2.getText();
//				
//		WebElement cou1 = driver.findElement(By.xpath("(//div[@class='cds-ProductCard-gridCard'])[1]"));
//		cou1.click();
//		
//		Set<String> set1 = new HashSet<String>();
//		set1 = driver.getWindowHandles();
//		List<String> list1 = new ArrayList<String>(set1);
//		String ParentPage1 = list1.get(0);
//		String ChildPage1 = list1.get(1);
//		driver.switchTo().window(ChildPage1);
//		
//		WebElement L1 = driver.findElement(By.xpath("(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[8]"));
//		String Lhour1 = L1.getText();
//		
//		System.out.println("Course Name : " +course1);
//		System.out.println("Learning Hours : " + Lhour1);
//		System.out.println("Rating : " +rating1);
//		
//		Thread.sleep(5000);
//		screenshot.screenShot("screenshot3",driver);
//		
//		driver.close();
//		driver.switchTo().window(ParentPage1);
//		
//		WebElement cou2 = driver.findElement(By.xpath("(//h3[contains(text(),'Introduction to Web Development')])[1]"));
//		Thread.sleep(5000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", cou2);
//		
//		Set<String> set2 = new HashSet<String>();
//		set2 = driver.getWindowHandles();
//		List<String> list2 = new ArrayList<String>(set2);
//		String ParentPage2 = list2.get(0);
//		String ChildPage2 = list2.get(1);
//		driver.switchTo().window(ChildPage2);
//		
//		WebElement L2 = driver.findElement(By.xpath("//div[@class='cds-119 css-1h3hs08 cds-121']"));
//		String Lhour2 = L2.getText();
//		
//		System.out.println("\nCourse Name : " +course2);
//		System.out.println("Learning Hours : " + Lhour2);
//		System.out.println("Rating : " +rating2);
//		
//		Thread.sleep(5000);
//		screenshot.screenShot("screenshot4",driver);
//	
//		driver.close();
//		driver.switchTo().window(ParentPage2);
//	}
//	@Test(priority = 5)
//	void LanandLvl() throws InterruptedException, IOException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		WebElement input =  driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
//		input.sendKeys(Keys.LEFT_CONTROL + "a");
//		input.sendKeys("Language Learning");
//		Thread.sleep(5000);
//		
//		WebElement search =  driver.findElement(By.xpath("(//div[@class='magnifier-wrapper'])[2]"));
//		search.click();
//		System.out.println("\nLanguage Learning");
//		Thread.sleep(5000);
//		
//		WebElement Beginner = driver.findElement(By.xpath("(//span[contains(text(),'Beginner')])[1]"));
//		Beginner.click();
//		System.out.println("\nLevel : Beginner\n");
//		Thread.sleep(5000);
//		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		
//		js.executeScript("window.scrollBy(0,-630)");
//		Thread.sleep(5000);
//		
//		WebElement showmore = driver.findElement(By.xpath("(//span[contains(text(),'Show more')])[2]"));
//		showmore.click();
//		Thread.sleep(5000);
//	
//		List<WebElement> beg = driver.findElements(By.xpath("//div[@class='css-1vfysn6']"));
//		List<String> languageBeg = new ArrayList<String>();
//		for(WebElement be : beg ) {
//			languageBeg.add(be.getText());
//		}
//		for(String a : languageBeg) {
//			System.out.println(a);
//		}
//		
//		screenshot.screenShot("screenshot5",driver);
//		
//		WebElement lanClose1 = driver.findElement(By.xpath("(//span[contains(text(),'Close')])[2]"));
//		js.executeScript("arguments[0].click();", lanClose1);
//		Thread.sleep(5000);
//		
//		Beginner.click();
//		
//		WebElement Intermediate = driver.findElement(By.xpath("(//span[contains(text(),'Intermediate')])[1]"));
//		Intermediate.click();
//		System.out.println("\nLevel : Intermediate\n");
//		Thread.sleep(5000);
//		
//		js.executeScript("window.scrollBy(0,-630)");
//		Thread.sleep(5000);
//		
//		showmore.click();
//		Thread.sleep(5000);
//	
//		List<WebElement> inte = driver.findElements(By.xpath("//div[@class='css-1vfysn6']"));
//		List<String> languageint = new ArrayList<String>();
//		for(WebElement in : inte ) {
//			languageint.add(in.getText());
//		}
//		for(String b : languageint) {
//			System.out.println(b);
//		}
//		
//		screenshot.screenShot("screenshot6",driver);
//		
//		WebElement lanClose2 = driver.findElement(By.xpath("(//span[contains(text(),'Close')])[2]"));
//		js.executeScript("arguments[0].click();", lanClose2);
//		
//		Thread.sleep(5000);
//		
//		Intermediate.click();
//		
//		WebElement Advanced = driver.findElement(By.xpath("(//span[contains(text(),'Advanced')])[1]"));
//		Advanced.click();
//		System.out.println("\nLevel : Advanced\n");
//		Thread.sleep(5000);
//		
//		js.executeScript("window.scrollBy(0,-630)");
//		Thread.sleep(5000);
//		
//		showmore.click();
//		Thread.sleep(5000);
//	
//		List<WebElement> adv = driver.findElements(By.xpath("//div[@class='css-1vfysn6']"));
//		List<String> languageadv = new ArrayList<String>();
//		for(WebElement ad : adv ) {
//			languageadv.add(ad.getText());
//		}
//		for(String a : languageadv) {
//			System.out.println(a);
//		}
//		
//		screenshot.screenShot("screenshot7",driver);
//		
//		WebElement lanClose3 = driver.findElement(By.xpath("(//span[contains(text(),'Close')])[2]"));
//		js.executeScript("arguments[0].click();", lanClose3);
//	
//		Thread.sleep(5000);
//		
//		Advanced.click();
//		
//		WebElement Mixed = driver.findElement(By.xpath("(//span[contains(text(),'Mixed')])[1]"));
//		Mixed.click();
//		System.out.println("\nLevel : Mixed\n");
//		Thread.sleep(5000);
//		
//		js.executeScript("window.scrollBy(0,-630)");
//		Thread.sleep(5000);
//		
//		showmore.click();
//		Thread.sleep(5000);
//	
//		List<WebElement> mix = driver.findElements(By.xpath("//div[@class='css-1vfysn6']"));
//		List<String> languagemix = new ArrayList<String>();
//		for(WebElement mi : mix ) {
//			languagemix.add(mi.getText());
//		}
//		for(String m : languagemix) {
//			System.out.println(m);
//		}
//		
//		screenshot.screenShot("screenshot8",driver);
//		
//		WebElement lanClose4 = driver.findElement(By.xpath("(//span[contains(text(),'Close')])[2]"));
//		js.executeScript("arguments[0].click();", lanClose4);
//		
//		Thread.sleep(5000);
//		
//		Mixed.click();
//
//	}
//	
//	@Test(priority = 6)
//	void form() throws InterruptedException, IOException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		WebElement forCampus = driver.findElement(By.xpath("//span[contains(text(),'Universities')]"));
//		//forCampus.click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", forCampus);
//		
//		System.out.println("\nCourses for campus\n");
//		
//		WebElement fname = driver.findElement(By.xpath("//input[@id='FirstName']"));
//		fname.sendKeys("abc");
//		
//		WebElement lname = driver.findElement(By.xpath("//input[@id='LastName']"));
//		lname.sendKeys("A");
//		
//		WebElement mail = driver.findElement(By.xpath("//input[@id='Email']"));
//		mail.sendKeys("abc");
//		
//		WebElement num = driver.findElement(By.xpath("//input[@id='Phone']"));
//		num.sendKeys("abc");
//		Thread.sleep(5000);
//		mail.sendKeys("d");
//		
//		WebElement er = driver.findElement(By.xpath("//div[@class='mktoError']"));
//		String error =  er.getText();
//		
//		screenshot.screenShot("screenshot9",driver);
//		System.out.println("Error : "+error);
//		
//		
//	}
//	
//	@Test(priority = 10)
//	void closeBrowser() {
////		driver.quit();
//		System.out.println("\nBrowser closed \n");
//	}
//
//}
