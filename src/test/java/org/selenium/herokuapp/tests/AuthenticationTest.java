package org.selenium.herokuapp.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Beta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.herokuapp.pages.FormAuthentication;
import org.selenium.herokuapp.pages.HomePage;
import org.selenium.herokuapp.pages.SecureArea;
import org.selenium.herokuapp.util.BrowserFactory;
import org.selenium.herokuapp.util.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class AuthenticationTest {

    private final Logger logger = LogManager.getLogger(AuthenticationTest.class);
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        logger.info("Initializing the browser ");
        //driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com/");
        BrowserFactory.init(ConfigurationReader.getBrowser());
        driver = BrowserFactory.getDriver();
        driver.get(ConfigurationReader.getBaseURL());
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

    @Test
    public  void testWithValidCredentials()
    {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnFormAuthentication();
        FormAuthentication formAuth = new FormAuthentication(driver);
        formAuth.enterUsername(ConfigurationReader.getUsername())
                .enterPassword(ConfigurationReader.getPassword())
                .clickLogin();

        SecureArea secuA =new SecureArea(driver);
        Assert.assertEquals(secuA.VerifyPageTitle(),"Secure Area");
        Assert.assertEquals(secuA.SubHeadingMessage(), "Welcome to the Secure Area. When you are done click logout below.");
    }

    @Test
    public  void testWithinValidUsername() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFormAuthentication();
        FormAuthentication formAuth = new FormAuthentication(driver);
        formAuth.enterUsername(ConfigurationReader.getInvalidUsername())
                .enterPassword(ConfigurationReader.getPassword())
                .clickLogin();
        Assert.assertEquals(formAuth.InvalidUsernameErrorMessage(),
                "Your username is invalid!");
    }
    @Test
    public  void testWithinValidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFormAuthentication();
        FormAuthentication formAuth = new FormAuthentication(driver);
        formAuth.enterUsername(ConfigurationReader.getUsername())
                .enterPassword(ConfigurationReader.getInvalidPassword())
                .clickLogin();
        Assert.assertTrue(formAuth.InvalidUPwErrorMessage().contains(
                "Your password is invalid!"));
    }
}
