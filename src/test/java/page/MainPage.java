package page;

import TestData.TestCaseBuyGood;
import com.academy.framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pn.FirstTest;

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
//        searchString.click();
//        searchString.clear();
//        searchString.sendKeys(login);
        enterTextAndClick( searchString, stringForSearch );
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
