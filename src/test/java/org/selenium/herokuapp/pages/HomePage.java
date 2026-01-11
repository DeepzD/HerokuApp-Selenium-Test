package org.selenium.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PrivateKey;

public class HomePage {

    private final WebDriver driver;
    By linkForgotPassword = By.linkText("Forgot Password");
    By linkFormAuthentication = By.linkText("Form Authentication");
    By linkGeolocation = By.linkText("Geolocation");

   public  HomePage(WebDriver driver) {
        this.driver= driver;
   }

   public void clickOnForgotPassword() {
       driver.findElement(linkForgotPassword).click();
   }

   public void clickOnFormAuthentication() {
       driver.findElement(linkFormAuthentication).click();
   }

   public void clickOnGeolocation() {
       driver.findElement(linkGeolocation).click();
   }
}
