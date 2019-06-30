package Tests.pn;

import TestData.TestCaseBuyGood;
import Tests.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.MainPage;

public class CheckInterfaceSwitching extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(CheckInterfaceSwitching.class);

    @Test
    public void SwitchToOtherLanguage(){

        TestCaseBuyGood testCaseBuyGoods = new TestCaseBuyGood();
        driver.get(testCaseBuyGoods.getSiteUrl() );
        MainPage mainPage = new MainPage( driver );
        mainPage.webElementXpathLocatorClick(".//li/span/a[contains(@data-toggle,\"dropdown\")]/span");

        mainPage.webElementXpathLocatorClick("//*[@id=\"userSettings\"]//a[contains(@href,'/my/set-lang/?lang=ru')]");
    }
}
