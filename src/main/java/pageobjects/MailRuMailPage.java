package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuMailPage {
    By exitLink = By.id("PH_logoutLink");
    By enterLink = By.id("PH_authLink");
    private WebDriver driver;
    private WebElement myDynamicElement;

    public MailRuMailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExitValue() {
        return driver.findElement(exitLink).getText();
    }

    public MailRuLoginPage logout() {
        driver.findElement(exitLink).click();
        myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(enterLink)));
        return new MailRuLoginPage(driver);
    }
}