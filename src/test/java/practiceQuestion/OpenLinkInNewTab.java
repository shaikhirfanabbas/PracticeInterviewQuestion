package practiceQuestion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");

		driver.manage().window().maximize();
		String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);
		
		driver.findElement(By.linkText("Get started")).sendKeys(tab);
	}

}
