package practiceQuestion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
//		WebElement logo=driver.findElement(By.xpath("(//img[@title='nopCommerce'])[1]"));
//		JavaScriptUtil.drawBorder(logo, driver);
//		
//		//Screen Shot
//		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		
//		File trg=new File(".\\target\\test2.png");
//		
//		FileUtils.copyFile(src, trg);
		
		String title=JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);
		WebElement ele=driver.findElement(By.xpath("//div[@class='home-banner-button']//a[@class='btn blue-button'][normalize-space()='Get started']"));
		JavaScriptUtil.clickElementByJS(ele, driver);
		
		
		JavaScriptUtil.generateAlert(driver, "I am Irfan");
		
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		JavaScriptUtil.scrollPageDown(driver);
		JavaScriptUtil.scrollUpPage(driver);
		JavaScriptUtil.zoomPageByJs(driver);
		
		WebElement logo=driver.findElement(By.xpath("(//img[@title='nopCommerce'])[1]"));
		JavaScriptUtil.flash(logo, driver);
	}

}
