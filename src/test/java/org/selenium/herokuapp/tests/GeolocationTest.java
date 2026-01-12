package org.selenium.herokuapp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.herokuapp.util.BrowserFactory;
import org.selenium.herokuapp.util.ConfigurationReader;
import org.selenium.herokuapp.util.permissionPopup;
import org.selenium.herokuapp.pages.Geolocation;
import org.selenium.herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GeolocationTest extends permissionPopup {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

    @Test
    public void findCurrentLocation()
    {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnGeolocation();
        Geolocation geo = new Geolocation(driver);
        geo.clickOnWhereAmIButton();

        Assert.assertEquals(geo.getLatitudeValue(),"-36.8738304");
        Assert.assertEquals(geo.getLongitudeValue(),"174.7648512");
    }

    @Test
    public void ViewCurrentLocationInGoogleMap()
    {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnGeolocation();
        Geolocation geo = new Geolocation(driver);
        geo.clickOnWhereAmIButton();
        geo.clickOnGoogleLink();
    }
}
