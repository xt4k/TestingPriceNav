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

    public void waitUntilTextChanged(String locator, String oldMessage) {
        WebDriverWait webDriverWait = new WebDriverWait( driver, EXPLICITLY_WAIT_TIMEOUT );

        webDriverWait.until( ExpectedConditions.not(
                ExpectedConditions.textToBe( By.cssSelector( locator ), oldMessage ) ) );
    }

    public BasePage webElementXpathLocatorClick(String locator) {
        driver.findElement( By.xpath( locator ) ).click();
        return this;
    }

    public BasePage webElementClick(WebElement element) {
        element.click();
        return this;
    }

    public void checkWebElementContainText(WebElement element, String expectedText) {
        System.out.println("check WE contains Text.| web-el.text: " + element.getText()+"| is contain | exp.text: " + expectedText+" |");
        Assert.assertTrue( element.getText().contains( expectedText ) );
    }

    public void checkWebElementClassTextEquals(WebElement element, String expectedStr) {
        //System.out.println("check WE Text Is Equal.| web-el.attr 'class:'" + String.valueOf( element.getAttribute("class" ))+"|=|"+"exp.text: " + expectedStr +" |");
        Assert.assertEquals( String.valueOf( element.getAttribute( "class" ) ), expectedStr );
    }

    public void checkWebElementValueTextEquals(WebElement element, String expectedStr) {
        //System.out.println("check WE Text Is Equal.| web-el.attr 'value:'" + String.valueOf( element.getAttribute("value" ))+"|=|"+"exp.text: " + expectedStr +" |");
        Assert.assertEquals( String.valueOf( element.getAttribute( "value" ) ), expectedStr );
    }

    public void checkWebElementCheckedTextEquals(WebElement element, String expectedStr) {
       // System.out.println("webelement:"+element.toString());
      //  System.out.println("webelement.attribute.'checked':"+element.getAttribute( "checked" ).toString());
       // System.out.println("check WE Text Is Equal.| web-el.attr 'checked:'" + String.valueOf( element.getAttribute("checked" ))+"|=|"+"exp.text: " + expectedStr +" |");
        Assert.assertEquals( String.valueOf( element.getAttribute( "checked" ) ), expectedStr );
    }


}
