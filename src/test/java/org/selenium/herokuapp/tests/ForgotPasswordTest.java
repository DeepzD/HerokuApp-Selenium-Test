package org.selenium.herokuapp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.herokuapp.pages.ForgotPassword;
import org.selenium.herokuapp.pages.HomePage;
import org.selenium.herokuapp.util.BrowserFactory;
import org.selenium.herokuapp.util.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();
        BrowserFactory.init(ConfigurationReader.getBrowser());
        driver = BrowserFactory.getDriver();
        driver.get(ConfigurationReader.getBaseURL());
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
       // driver.quit();
    }

    @Test
    public void testForgotPasswordWithValidEmail()
    {
        HomePage homepage=new HomePage(driver);
        homepage.clickOnForgotPassword();
        ForgotPassword forgotPassword =new ForgotPassword(driver);
        forgotPassword.enterValidEmail("deepikahewawasam@gmail.com");
        forgotPassword.clickSubmit();
    }

    @Test
    public void testForgotPasswordWithinValidEmail()
    {
        HomePage homepage=new HomePage(driver);
        homepage.clickOnForgotPassword();
        ForgotPassword forgotPassword =new ForgotPassword(driver);
        forgotPassword.enterValidEmail("deepikahewawasamgmail.com");
        forgotPassword.clickSubmit();
        //Error message doe not appear : issue
    }
}
