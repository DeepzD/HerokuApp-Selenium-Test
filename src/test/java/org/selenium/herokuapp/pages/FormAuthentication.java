package org.selenium.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormAuthentication {

    private final WebDriver driver;

    By txtUsername =By.xpath("//input[@id='username']");
    By txtPassword = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    //By flashMessageUsername = By.xpath("//div[@id='flash' and contains(normalize-space(),'username')]");
    //By flashMessagePassword = By.xpath("//div[@id='flash' and contains(normalize-space(),'password')]");
    By flashMessageUsername = By.id("flash");
    By flashMessagePassword = By.id("flash");

    public FormAuthentication(WebDriver driver)
    {
        this.driver=driver;
    }

    public FormAuthentication enterUsername(String username)
    {
        driver.findElement(txtUsername).sendKeys(username);
        return  this;
    }

    public FormAuthentication enterPassword(String password)
    {
        driver.findElement(txtPassword).sendKeys(password);
        return this;
    }

    public void clickLogin()
    {
        driver.findElement(loginButton).click();
    }

    public String InvalidUsernameErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String errorMessage_Username = wait.until(ExpectedConditions.
                visibilityOfElementLocated(flashMessageUsername)).getText();
        errorMessage_Username = errorMessage_Username.split("\n")[0];
        System.out.println(errorMessage_Username);
        return errorMessage_Username;
    }
    public String InvalidUPwErrorMessage()
    {
        String errorMessage_PW = driver.findElement(flashMessagePassword).getText();
        return errorMessage_PW;
    }
}
