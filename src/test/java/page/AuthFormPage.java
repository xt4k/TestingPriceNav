package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthFormPage extends BasePage {

    @FindBy(xpath="login-form-login")
    WebElement loginField;

    @FindBy(xpath = ".//*[contains(@onclick,'showLoginForm()')]")
    WebElement openLoginWindow;

    @FindBy(xpath="login-form-password")
    WebElement passwordField;

    @FindBy(xpath = "loginButton")
    WebElement submitButton;

    public AuthFormPage(WebDriver driver) {
       super(driver);
    }

    public AuthFormPage enterLogin (String login) {
//        loginField.click();
//        loginField.clear();
//        loginField.sendKeys(login);
        enterText(loginField, login);
        return this;
    }

    public AuthFormPage enterPassword (String password){
//        passwordField.click();
//        passwordField.clear();
//        passwordField.sendKeys(password);
        enterText(passwordField, password);
        return  this;
    }

    public BasePage submit (boolean isCorrect){
        submitButton.click();
        if (isCorrect)
            return new MainPage (driver);
        else
            return this;
    }


    public BasePage openLoginWindowPopup (boolean isCorrect){
        openLoginWindow.click();
        if (isCorrect)
            return new MainPage (driver);
        else
            return this;
    }
}
