package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

public class MailRuLoginPage {

    @FindBy(how= How.ID, using="mailbox__login")
    private WebElement login;
    @FindBy(how= How.ID, using="mailbox__password")
    private WebElement password;
    @FindBy(how= How.ID, using="mailbox__auth__button")
    private WebElement enterButton;
    @FindBy(how= How.ID, using="PH_authLink")
    private WebElement enterLink;
    private WebDriver driver;
    private String url = "http://mail.ru";

    public MailRuLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public MailRuMailPage login() {
        this.login.sendKeys("seleniumtests10@mail.ru");
        this.password.sendKeys("060788avavav");
        enterButton.click();
        return new MailRuMailPage(driver);
    }

    public void checkEnter() {
        assertEquals(this.enterLink.getText(), "Вход");
    }
}