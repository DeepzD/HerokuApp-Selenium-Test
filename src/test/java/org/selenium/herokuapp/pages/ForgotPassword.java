package org.selenium.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {

    private  final WebDriver driver;

    By email= By.xpath("//input[@id='email']");
    By submitButton = By.xpath("//button[@id='form_submit']");

    public ForgotPassword(WebDriver driver)
    {
        this.driver=driver;
    }

    public ForgotPassword enterValidEmail(String emailAddress)
    {
        driver.findElement(email).sendKeys(emailAddress);
        return  this;
    }

    public void clickSubmit()
    {
        driver.findElement(submitButton).click();
    }
}
