import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    public static final String arborURL="https://sandbox.uk.arbor.sc/?/home-ui/index";
    public WebDriver driver;
    public static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    public By username= By.id("username");
    public By password=By.id("password");
    public By message=By.xpath("//div[@id='react-container']//span[@class='message-container-caption']");
    public String wrongLogin = "Incorrect username / password combination.";
    public By clickLogin= By.xpath("//section[@class='login-section']//label[.='Log in']");


    protected HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void open(){
        logger.info("Oprning home page", arborURL);
        driver.get(arborURL);
        driver.manage().window().maximize();

    }

    public void quit() {
        if (this.driver != null) {

            driver.quit();
        }
    }


    public void assertElementText()  {
        logger.info("Asserting message", wrongLogin);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String elementText =driver.findElement(message).getText();
        System.out.println(elementText);
        Assert.assertTrue(elementText.contains(wrongLogin));

    }

    public void sendUsername( String text){

        logger.info("Find user name field {} by locator", username);

        driver.findElement(username).sendKeys(text);


    }

    public void sendPassword(String text){
        logger.info("Find password field{} by locator", password);
        driver.findElement(password).sendKeys(text);
    }

    public void clickbuttonLogin() {
        logger.info("Click on element{} by locator", clickLogin);
        driver.findElement(clickLogin).click();
    }

}
