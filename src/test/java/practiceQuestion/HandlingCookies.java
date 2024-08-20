package practiceQuestion;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		Set<Cookie> test=driver.manage().getCookies();
		System.out.println("Size of cookies"+test.size());
		
		for(Cookie c : test) {
			System.out.println(c.getName()+" : "+c.getValue());
		}
		
		//add cookies to the browser?
		
		Cookie cookieObject=new Cookie("My Cookies","123456");
		
		driver.manage().addCookie(cookieObject);
		
		test=driver.manage().getCookies();
		System.out.println("Size of cookies"+test.size());
		
		//How to delete specific cookie from the browser
      //  driver.manage().deleteCookie(cookieObject);
		 driver.manage().deleteCookieNamed("My Cookies");
		test=driver.manage().getCookies();
		System.out.println("Size of cookies"+test.size());
		
		//delete all cookies from browser
		driver.manage().deleteAllCookies();
		
		test=driver.manage().getCookies();
		System.out.println("Size of cookies"+test.size());

	}

}
