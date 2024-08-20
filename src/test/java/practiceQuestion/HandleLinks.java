package practiceQuestion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

//	WebDriverManager.chromedriver().setup();
//	WebDriver driver=new ChromeDriver();

public static void main(String args[]) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	
	List<WebElement> link =driver.findElements(By.tagName("a"));
	//System.out.println("Number of links present: "+link.size());
	
	for(int i=0;i<=link.size();i++) {
		System.out.println(link.get(i).getText()); 
	}
}
	
}
