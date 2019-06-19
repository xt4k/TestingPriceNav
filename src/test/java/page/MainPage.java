package page;

import TestData.TestCaseBuyGood;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPage extends page.BasePage {

    private final String enterLinkLocator = "body > app-root > div > div:nth-child(2) > div.app-rz-header > header > div > div.header-topline > div.header-topline__user.js-rz-auth > div.header-topline__user-wrapper > p > a";
    private final String searchSubString = new TestCaseBuyGood().getSearchString();
    private final String searchStr = ".//*[contains(@class,'search-text-input')]";

    //    @FindBy(css = "body > app-root > div > div:nth-child(2) > div.app-rz-header > header > div > div.header-topline > div.header-topline__user.js-rz-auth > div.header-topline__user-wrapper > p > a")
    @FindBy(css = enterLinkLocator)
    private WebElement enterLink;

    @FindBy(xpath = searchStr)
    private WebElement searchString;

    @FindBy(xpath = ".//*[@id=\"search\"]//a[contains(.,'Toto TPU')]")
    private WebElement webElement;

    public MainPage enterAndSearchSomeString(String stringForSearch) {
        System.out.println("string search: "+ stringForSearch);
//        searchString.click();
//        searchString.clear();
//        searchString.sendKeys(login);
        enterTextAndClick( searchString, stringForSearch );
        return this;
    }

    public MainPage enterSearchString(String stringForSearch, String locator) {
        System.out.println("string search: "+ stringForSearch);
        enterTextAndClick( driver.findElement( By.xpath( locator ) ), stringForSearch );
        return this;
    }




    public MainPage webElementClickWaitCheck(String locator1, String locator2, String expectedValue) {
        webElementClick( driver.findElement( By.xpath( locator1 ) ) );
        waitUntilTextChanged( locator2, driver.findElement( By.xpath(locator2 ) ).getText());
        checkWebElementContainText( driver.findElement( By.xpath(locator2 ) ), expectedValue);
        System.out.println("locator1: "+ locator1 +"|  locator2: "+ locator2 +" | exp.text:"+ expectedValue );
        return this;
    }

    public MainPage webElementClickWaitCheckEqualV(String locator1, String locator2, String expectedValue) {

        webElementClick( driver.findElement( By.xpath( locator1 ) ) );
        waitUntilTextChanged( locator2, driver.findElement( By.xpath(locator2 ) ).getText());
  /*      try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        checkWebElementValueTextEquals( driver.findElement( By.xpath(locator2 ) ), expectedValue);
        return this;
    }

    public MainPage webElementClickWaitCheckEqualC(String locator1, String locator2, String expectedValue) {
        webElementClick( driver.findElement( By.xpath( locator1 ) ) );
        waitUntilTextChanged( locator2, driver.findElement( By.xpath(locator2 ) ).getText());
          checkWebElementClassTextEquals( driver.findElement( By.xpath(locator2 ) ), expectedValue);
        return this;
    }

    public MainPage webElementClickWaitCheckEqualCh(String locator1, String locator2, String expectedValue) {
        webElementClick( driver.findElement( By.xpath( locator1 ) ) );
        locator2=locator2.concat( "/../../../input");
        //System.out.println("locator2: "+locator2);
        waitUntilTextChanged( locator2, driver.findElement( By.xpath(locator2 ) ).getText());
        checkWebElementCheckedTextEquals( driver.findElement( By.xpath(locator2 ) ), expectedValue);
        return this;
    }




    public MainPage(WebDriver driver) {
        super( driver );
    }


    public MainPage waitUntilLinkTextChanged(String oldMessage) {
        waitUntilTextChanged( enterLinkLocator, oldMessage );
        return this;
    }


}
