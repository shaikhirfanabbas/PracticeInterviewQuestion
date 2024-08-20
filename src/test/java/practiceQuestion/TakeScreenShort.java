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

public class TakeScreenShort {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");

		driver.manage().window().maximize();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\target\\test2.png");
		
		FileUtils.copyFile(src, trg);
		
		//Specific portion to screenshot
		WebElement ele=driver.findElement(By.xpath("/html/body/div[2]"));
		File src1=ts.getScreenshotAs(OutputType.FILE);
		File trg1=new File(".\\target\\test9.png");
		
		FileUtils.copyFile(src1, trg1);
	}

}
