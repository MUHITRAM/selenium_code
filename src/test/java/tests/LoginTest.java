package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                loginPage.getMessage().contains("You logged into a secure area"),
                "Valid login failed"
        );
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser", "wrongpass");

        Assert.assertTrue(
                loginPage.getMessage().contains("Your username is invalid"),
                "Invalid login error not shown"
        );
    }
}
