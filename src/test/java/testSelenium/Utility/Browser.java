package testSelenium.Utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeEach
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\calh\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20l));
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

}
