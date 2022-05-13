package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String windowHandle = driver.getWindowHandle();
		  
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  driver.get("http://leaftaps.com/opentaps/control/login");
//		  2. Enter UserName and Password Using Id Locator

		  driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			
			driver.findElement(By.id("password")).sendKeys("crmsfa");

//		  3. Click on Login Button using Class Locator
//		  
		  driver.findElement(By.className("decorativeSubmit")).click();
			
//			  4. Click on CRM/SFA Link
		  driver.findElement(By.linkText("CRM/SFA")).click();
//		  
//		  5. Click on contacts Button
		  driver.findElement(By.linkText("Contacts")).click();
//		  6. Click on Merge Contacts using Xpath Locator
		  
		  
		  
		  driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//		  7. Click on Widget of From Contact
//		  
		//  
		  
		  driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		  
		  Set<String> windowHandles = driver.getWindowHandles();
		  List<String> lstwindow=new ArrayList<String>(windowHandles);
		  
		  String secondwindow = lstwindow.get(1);
		  
		  driver.switchTo().window(secondwindow);
		
		  driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tbody//tr[1]//td[1]//a")).click();
		  
		  driver.switchTo().window(windowHandle);
		  
		  driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		  
		  Set<String> windowHandles2 = driver.getWindowHandles();
		  List<String> lstwindowHandles2=new ArrayList<String>(windowHandles2);
		  String secondarywindow = lstwindowHandles2.get(1);
		  driver.switchTo().window(secondarywindow);
		  
		  driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//tr[1]//td[1]//a")).click();
		  
		  driver.switchTo().window(windowHandle);
		  driver.findElement(By.xpath("//a[text()='Merge']")).click();
		  
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 System.out.println(driver.getTitle());
	}

}
