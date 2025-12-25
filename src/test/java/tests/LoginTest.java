package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void validLoginTest() {
        driver.findElement(org.openqa.selenium.By.id("username"))
              .sendKeys("tomsmith");

        driver.findElement(org.openqa.selenium.By.id("password"))
              .sendKeys("SuperSecretPassword!");

        driver.findElement(org.openqa.selenium.By.cssSelector("button[type='submit']"))
              .click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
