package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class MailRuMailPage {
    @FindBy(how= How.ID, using="PH_logoutLink")
    private WebElement exitLink;
    private WebDriver driver;

    public MailRuMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void close() {
        this.driver.close();
    }

    public void checkExit() {
        assertEquals(this.exitLink.getText(), "выход");
    }

    public MailRuLoginPage logout() {
        exitLink.click();
        return new MailRuLoginPage(driver);
    }
}