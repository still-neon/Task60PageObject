package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuLoginPage {
    private static final String LOGIN = "seleniumtests10@mail.ru";
    private static final String PASSWORD = "060788avavav";
    private String URL = "http://mail.ru";
    By login = By.id("mailbox__login");
    By password = By.id("mailbox__password");
    By enterButton = By.id("mailbox__auth__button");
    By enterLink = By.id("PH_authLink");
    By exitLink = By.id("PH_logoutLink");
    private WebDriver driver;
    private WebElement myDynamicElement;

    public MailRuLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void load() {
        driver.get(URL);
    }

    public MailRuMailPage login() throws InterruptedException {
        driver.findElement(login).sendKeys(LOGIN);
        driver.findElement(password).sendKeys(PASSWORD);
        driver.findElement(enterButton).click();
        myDynamicElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(driver.findElement(exitLink)));
        return new MailRuMailPage(driver);
    }

    public MailRuMailPage login(String login, String password) {
        driver.findElement(this.login).sendKeys(login);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(enterButton).click();
        myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(exitLink)));
        return new MailRuMailPage(driver);
    }

    public String getEnterValue() {
        return driver.findElement(enterLink).getText();
    }
}