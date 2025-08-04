package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "userId")
    WebElement userIdInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "togglePassword")
    WebElement eyeIcon;

    @FindBy(id = "errorMsg")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserId(String userId) {
        userIdInput.sendKeys(userId);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public void togglePasswordVisibility() {
        eyeIcon.click();
    }

    public String getPasswordFieldType() {
        return passwordInput.getAttribute("type");
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
