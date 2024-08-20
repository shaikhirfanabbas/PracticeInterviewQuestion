package practiceQuestion;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

    public static void main(String[] args) {
        String location = System.getProperty("user.dir") + "\\Downloads";

        // Corrected the declaration and type of preferences
        Map<String, Object> preferences = new HashMap<String, Object>();
        preferences.put("download.default_directory", location);

        // Apply the preferences to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);

        // Setup and pass options to WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

        // Add a delay if necessary to allow the file to download
        try {
            Thread.sleep(5000); // Adjust this delay based on your network speed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
