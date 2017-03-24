package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuLoginPage {
    private static final String LOGIN = "seleniumtests10@mail.ru";
    private static final String PASSWORD = "060788avavav";
    private String URL = "http://mail.ru";
    @FindBy(how = How.ID, using = "mailbox__login")
    private WebElement login;
    @FindBy(how = How.ID, using = "mailbox__password")
    private WebElement password;
    @FindBy(how = How.ID, using = "mailbox__auth__button")
    private WebElement enterButton;
    @FindBy(how = How.ID, using = "PH_authLink")
    private WebElement enterLink;
    @FindBy(how = How.ID, using = "PH_logoutLink")
    private WebElement exitLink;
    private WebDriver driver;
    private WebElement myDynamicElement;

    public MailRuLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(URL);
    }

    public MailRuMailPage login() {
        login.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        enterButton.click();
        myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(exitLink));
        return new MailRuMailPage(driver);
    }

    public MailRuMailPage login(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        enterButton.click();
        myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(exitLink));
        return new MailRuMailPage(driver);
    }

    public String getEnterValue() {
        return enterLink.getText();
    }
}