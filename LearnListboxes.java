package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement index = driver.findElement(By.id("dropdown1"));
		
		Select select1=new Select(index);
		
		select1.selectByIndex(4);
		
		WebElement text = driver.findElement(By.name("dropdown2"));
		
		Select selct2=new Select(text);
		
		selct2.selectByVisibleText("Selenium");
		
		WebElement value = driver.findElement(By.id("dropdown3"));
		
		Select select3=new Select(value);
		
		select3.selectByValue("2");
		
		WebElement count = driver.findElement(By.className("dropdown"));
		
		Select select4=new Select(count);
		
		List<WebElement> optionsCount = select4.getOptions();
		
		int size = optionsCount.size();
		
		System.out.println("The number of options in dropdown list is :" + size);
		
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("UFT/QTP");
		
		
		 WebElement multipleDropdown = driver.findElement(By.xpath("(//select)[6]"));
		
		Select select6=new Select(multipleDropdown);
		
		select6.selectByVisibleText("Appium");
		
		select6.selectByVisibleText("Selenium");
		
		
		
		
		

	}

}
