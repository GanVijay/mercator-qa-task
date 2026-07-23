package pages;

import drivers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WaitUtils.assertPageTitle;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void login(String username, String password) {
        launcUrl();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
        assertPageTitle("Swag Labs");
    }

    private void launcUrl() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }
}
