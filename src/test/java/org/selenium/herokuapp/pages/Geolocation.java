package org.selenium.herokuapp.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.directory.NoSuchAttributeException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class Geolocation {

    private final WebDriver driver;

    By AmIButton = By.xpath("//button[contains(text(),'Where am I')]");
    By Latitude = By.xpath("//div[@id='lat-value']");
   // By Latitude = By.id("//div[@id='lat-value' and contains(normalize-space(),'36')]");
    By Longitude = By.xpath("//div[@id='long-value']");
    By GoogleLink = By.linkText("See it on Google");
        //By.xpath("//div[@id='map-link']");

    public Geolocation(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnWhereAmIButton() {
        driver.findElement(AmIButton).click();
    }

    public String getLatitudeValue() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(Latitude));
            String LatitudeValue = element.getText();
            System.out.println(LatitudeValue);
            return LatitudeValue;
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getLongitudeValue(){
        String LongtitudeValue = driver.findElement(Longitude).getText();
        return LongtitudeValue;
    }
    public void clickOnGoogleLink() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement link= wait.until(ExpectedConditions.visibilityOfElementLocated(GoogleLink));
            link.click();
        }
        catch (TimeoutException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
