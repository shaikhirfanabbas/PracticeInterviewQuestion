package practiceQuestion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	/*
	 * 1. How many rows in table
	 * 2. How many column in table
	 * Retrieve the specific row/column data
	 * Retrieve all the data from the table
	 * Print release Date, VersionNo of Java Language of Selenium
	 * */
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		
		int row=driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr")).size();
		System.out.println("Total Row"+row);
		
		int column=driver.findElements(By.xpath("//table[@class=\"table\"]/thead/tr/th")).size();
		System.out.println("Total Column"+column);
		
		String value=driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[2]/th[1]")).getText();
		System.out.println(value);
		
		System.out.println("Table Data:");
		for (int r = 1; r <= 1; r++) {
			for (int c = 1; c <= 1; c++) {
				String data = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[" + c + "]")).getText();
				System.out.print(data + "\t");
			}
			System.out.println();
		}
	}
}
