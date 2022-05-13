package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonURL {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		1.Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.com/");
		
//		2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		
		driver.findElement(By.id("nav-search-submit-button")).click();


//			3.Get the price of the first product
		
		
		String price = driver.findElement(By.xpath("(//div[@class='a-section'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("The price of the first product :" + price);
		
		String rating = driver.findElement(By.xpath("//div//span[text()='RESULTS']//following::span[contains(text(),'stars')][1]")).getText();

		System.out.println("The rating of the first product :" + rating );
		
		driver.findElement(By.xpath("//div//span[text()='RESULTS']//following::h2[1]//a")).click();
		
		
		  
		  Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleslist2=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowHandleslist2.get(1));
		
		
		driver.findElement(By.id("//input[@id='add-to-cart-button']")).click();
		
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		
		File destinationfile =new File("./snaps/sample2.png");
		
		FileUtils.copyFile(srcfile,destinationfile);
		
		
		if(FileUtils.getFile(destinationfile).exists()) {
			System.out.println("The screenshot is placed in the given path");
			System.out.println("--------------------------------------------");
		}
		
		
		
		
	}

}
