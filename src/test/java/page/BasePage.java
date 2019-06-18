package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    private final int EXPLICITLY_WAIT_TIMEOUT = 5;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    protected void enterText(WebElement textField, String value) {
        textField.click();
        textField.clear();
        textField.sendKeys( value );
    }

    protected void enterTextAndClick(WebElement textField, String value) {
        textField.click();
        textField.clear();
        textField.sendKeys( value );
        textField.click();
    }

    protected void waitUntilTextChanged(String locator, String oldMessage) {
        WebDriverWait webDriverWait = new WebDriverWait( driver, EXPLICITLY_WAIT_TIMEOUT );

        webDriverWait.until( ExpectedConditions.not(
                ExpectedConditions.textToBe( By.cssSelector( locator ), oldMessage ) ) );
    }

    public void checkWebElementContainText(WebElement element, String expectedText) {
        // String str = webElement.getText();
        //"Toto TPU Case Anti-Shock Apple iPhone SE"
       // System.out.println(" text: "+expectedText+" el.text: "+element.getText());
        Assert.assertTrue( element.getText() .contains(expectedText ) );
    }

    public BasePage webElementClick(WebElement element) {
        element.click();
        return this;
    }


    public void checkWebElementTextEquals(WebElement element, String expectedStr) {
        Assert.assertEquals( String.valueOf( element.getAttribute( "class" ) ), expectedStr );
    }
}
