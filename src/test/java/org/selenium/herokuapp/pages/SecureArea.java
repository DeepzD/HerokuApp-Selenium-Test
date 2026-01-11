package org.selenium.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea {

    WebDriver driver;

    By PageTitle = By.xpath("//h2[normalize-space()='Secure Area']");
    By subHeading = By.xpath("//h4[contains(text(),'Welcome')]");
    By logoutButton = By.xpath("//a[@href='/logout']");


    public SecureArea(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickLogout()
    {
        driver.findElement(logoutButton).click();
    }

    public String VerifyPageTitle() {
        String Title = driver.findElement(PageTitle).getText();
        return Title;
    }
    public String SubHeadingMessage() {
        String SubHeader= driver.findElement(subHeading).getText();
        return SubHeader;
    }
    public void clickOnLogout()
    {
        driver.findElement(logoutButton).click();
    }

}
