package Tests.rozetka;

import TestData.RozetkaData;
import TestData.RozetkaData;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.BasePage;
import page.MainPage;

import java.util.concurrent.TimeUnit;

public class NoBuyOnlyClickScenario extends BaseTest {
    @Test
    public void mainScenario() {

        //Create UI test:
        // selenium webdriver
        // page object pattern
        // Coverage and checks define by yourself.
        // 1) Open https://rozetka.com.ua
        // 2) Search "iphone"
        //  3) Choose "iphone se" from dropdown list and go to category page
        //  4) Choose any phone with "Rose" color and go to product page
        //   5) Change color to "Space Gray"
        //   6) Add product to the basket

        RozetkaData rozetkaData = new RozetkaData();

        driver.get( rozetkaData.getSiteUrl() );

        //2) Search "iphone se"
        MainPage mainPage = new MainPage( driver );
        mainPage.enterSearchString( rozetkaData.getSearchString(), rozetkaData.getSearchSelector() );

        //check string in dropped list
        mainPage.waitUntilTextChanged( rozetkaData.getDropLineSelector(), rozetkaData.getExtpectedDropLine() );

        //3) Choose product from dropdown list and go to category page
        mainPage.webElementXpathLocatorClick( rozetkaData.getDropLineSelector() );
        //  mainPage.webElementClick( driver.findElement( By.xpath( rozetkaData.getDropLineSelector() ) ) );

        //4) Choose any product from 1st vendor Check that product is selected "checked"
        mainPage.webElementClickWaitCheckEqualCh( rozetkaData.getFirstVendorSelector(), rozetkaData.getFirstVendorSelector(), "true" );

        //5) Change other vendor  and check that it is selected
        // mainPage.webElementClickWaitCheckEqualCh(rozetkaData.getFirstVendorSelector(), rozetkaData.getSecondVendorSelector(), "" );
        mainPage.webElementClickWaitCheckEqualCh( rozetkaData.getSecondVendorSelector(), rozetkaData.getSecondVendorSelector(), "true" );

        // click on selected goods and check if it same goods that is expected
        mainPage.webElementClickWaitCheck( rozetkaData.getFinalGoodSelector(), rozetkaData.getFinalGoodName(), rozetkaData.getFinalGoodNameContent() );

        //6) Add product to the basket: check that  basket initially is empty, sequentally click to add there goods and check basket state
    mainPage.webElementXpathLocatorClick(rozetkaData.getFinalGoodImageSelector());
//        mainPage.webElementClickWaitCheck( rozetkaData.getFinalGoodImageSelector(), rozetkaData.getBasketCandidateSelector(), rozetkaData.getBasketCandidateTitle() );

        mainPage.webElementClickWaitCheck( rozetkaData.getAddToBasketSelector(), rozetkaData.getBasketGoodsSelector(), rozetkaData.getBasketGoodsActionTitle() );

        /*        mainPage.webElementClickWaitCheck(rozetkaData.getBasketSelector(),rozetkaData.getAddToBasketSelector(),"1");

        //+7)  Check into basket: navigate into basket and check it again as it was done before
        mainPage.webElementClickWaitCheckEqualV(rozetkaData.getAddToBasketSelector(),rozetkaData.getBasketGoodsSelector(),"1");
        mainPage.webElementClickWaitCheckEqualV(rozetkaData.getBasketGoodsIncrementSelector(),rozetkaData.getBasketGoodsSelector(),"2");
        mainPage.webElementClickWaitCheckEqualV(rozetkaData.getBasketGoodsDecrementSelector(),rozetkaData.getBasketGoodsSelector(),"1");

        // at last clear basket and check this case ".//td/a[contains(@class,'delete')]"//проверка по тексту "Список покупок порожній"
        mainPage.webElementClickWaitCheck(rozetkaData.getBasketGoodsDeleteSelector(),rozetkaData.getBasketEmptyTextSelector(), rozetkaData.getBasketEmptyText());*/

        System.out.println( "Tests.rozetka-done" );
    }


}