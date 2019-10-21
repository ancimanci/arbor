package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverWrapper {

    public static void setUpDriver() {

                WebDriverManager.chromedriver().setup();

    }

    public static WebDriver createDriver() {
        WebDriver driver = null;

                driver = new ChromeDriver();

        return driver;
    }
}
