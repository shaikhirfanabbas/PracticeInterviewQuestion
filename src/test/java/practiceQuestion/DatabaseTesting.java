package practiceQuestion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseTesting {
		    public static void main(String[] args) throws Exception {
		    	
		    	//Data
		    	
		    	String cust_firstname="John";
		    	String cust_lastname="kenedy";
		    	String cust_email="johan@gmail.com";
		    	String cust_telPhone="1234567891";
		    	String cust_password="john123";
		    	
		    	
		        // Set up the WebDriver
		        WebDriverManager.chromedriver().setup();
		        WebDriver driver = new ChromeDriver();

		        // Navigate to the registration page
		        driver.get("https://www.opencart.com/"); // Replace with the actual URL
		        driver.findElement(By.xpath("//a[@class='btn btn-black navbar-btn']")).click();
		        
		        // Fill in the personal details
		        WebElement firstName = driver.findElement(By.name("firstname"));
		        firstName.sendKeys("John");

		        WebElement lastName = driver.findElement(By.name("lastname"));
		        lastName.sendKeys("Doe");

		        WebElement email = driver.findElement(By.name("email"));
		        email.sendKeys("john.doe@example.com");

		        WebElement telephone = driver.findElement(By.name("telephone"));
		        telephone.sendKeys("1234567890");

		        // Fill in the password
		        WebElement password = driver.findElement(By.name("password"));
		        password.sendKeys("your_password");

		        WebElement confirmPassword = driver.findElement(By.name("confirm"));
		        confirmPassword.sendKeys("your_password");

		        // Select the newsletter subscription option (Yes)
		        WebElement subscribeYes = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
		        subscribeYes.click();

		        // Agree to the Privacy Policy (make sure the element can be clicked)
		        WebElement privacyPolicy = driver.findElement(By.name("agree"));
		        privacyPolicy.click();

		        // Submit the registration form
		        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		        continueButton.click();

		        // Optionally, close the browser
		        // driver.quit();
		        try { 
		       String confi= driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		       
		       if(confi.equals("Your Account Has Been Created!")) {
		        	System.out.println("Rgistration sucessful from UI");
		        }else {
		        	System.out.println("Rgistration is not sucessful from UI");
		        }}
		        catch(Exception e) {
		        	System.out.println("Error in reg. process");
		        }
		        
		        //Database Validation
		        
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/openshoo","root","");
		        Statement stmt=con.createStatement();//execute query
		        
		        String query="select firstname,lastname,email,telephone from customer;";
		        ResultSet rs=stmt.executeQuery(query);
		        
		        while(rs.next()) {
		        	String firstname=rs.getString("firstname");
		        	String lastname=rs.getString("lastname");
		        	String email1=rs.getString("email");
		        	String telephone1=rs.getString("telephone");
		        	
		        	boolean status=false;
		        	
		        	if(cust_firstname.equals(firstname)&& cust_lastname.equals(lastname)) {
		        		System.out.println("Record found in the table || Test Passed");
		        		status=true;
		        		break;
		        	}
		        }
		        	
//		        if(status==false) {
//		        	System.out.println("Record not found || Test Failed");
//		        }
	}
}