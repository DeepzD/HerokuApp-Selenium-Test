package org.selenium.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String getLatitudeValue(){
        String LatitudeValue = driver.findElement(Latitude).getText();
        System.out.println(LatitudeValue);
        return LatitudeValue;
    }

    public String getLongitudeValue(){
        String LongtitudeValue = driver.findElement(Longitude).getText();
        return LongtitudeValue;
    }
    public void clickOnGoogleLink() {
        driver.findElement(GoogleLink).click();
    }
}
