package Tests.pn;

import TestData.TestCaseBuyGood;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.BasePage;
import page.MainPage;

import java.util.concurrent.TimeUnit;

public class FirstTest extends BaseTest {
    @Test
    public void mainScenario() {
        //selenium webdriver
        //page object pattern
        //Coverage and checks define by yourself.
        //1) Open site
        TestCaseBuyGood testCaseBuyGoods = new TestCaseBuyGood();

        driver.get( testCaseBuyGoods.getSiteUrl() );

        //2) Search "iphone se"
        MainPage mainPage = new MainPage( driver );
        mainPage.enterAndSearchSomeString( testCaseBuyGoods.getSearchString() );

        //check string in dropped list
        mainPage.waitUntilTextChanged( testCaseBuyGoods.getDropLineSelector() , testCaseBuyGoods.getExtpectedDropLine());

        //3) Choose goods from dropdown list and go to category page
        mainPage.webElementXpathLocatorClick(testCaseBuyGoods.getDropLineSelector());
       // mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getDropLineSelector() ) ) );

        //4) Choose any phone with  First color 'Прозорий' Check that colour is selected "active"
        mainPage.webElementXpathLocatorClick(testCaseBuyGoods.getColourListboxFilterSelector());
      //  mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getColourListboxFilterSelector() ) ) );
        mainPage.webElementClickWaitCheckEqualC(testCaseBuyGoods.getFirstColourSelector(), testCaseBuyGoods.getFirstColourSelector() + "/..", testCaseBuyGoods.getSelectedColorState());

        //5) Change color to Блакитний     and check that it is selected
        mainPage.webElementClickWaitCheckEqualC(testCaseBuyGoods.getFirstColourSelector(), testCaseBuyGoods.getFirstColourSelector() + "/..", "");
        mainPage.webElementClickWaitCheckEqualC(testCaseBuyGoods.getSecondColourSelector(),testCaseBuyGoods.getSecondColourSelector() + "/..", testCaseBuyGoods.getSelectedColorState());

        // click on selected goods and check if it same goods that is expected "Toto TPU Case Anti-Shock Apple iPhone SE Blue"
        mainPage.webElementClickWaitCheck(testCaseBuyGoods.getFinalGoodSelector(),testCaseBuyGoods.getFinalGoodName(),testCaseBuyGoods.getFinalGoodNameContent());

        //6) Add product to the basket, check that  basket initially is empty, sequentally click to add there goods and check basket state
        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ), "" );
        mainPage.webElementClickWaitCheck(testCaseBuyGoods.getBasketSelector(),testCaseBuyGoods.getAddToBasketSelector(),"1");
        mainPage.webElementClickWaitCheck(testCaseBuyGoods.getBasketSelector(),testCaseBuyGoods.getAddToBasketSelector(),"0");
        mainPage.webElementClickWaitCheck(testCaseBuyGoods.getBasketSelector(),testCaseBuyGoods.getAddToBasketSelector(),"1");

        //+7)  Check into basket: navigate into basket and check it again as it was done before
        mainPage.webElementClickWaitCheckEqualV(testCaseBuyGoods.getAddToBasketSelector(),testCaseBuyGoods.getBasketGoodsSelector(),"1");
        mainPage.webElementClickWaitCheckEqualV(testCaseBuyGoods.getBasketGoodsIncrementSelector(),testCaseBuyGoods.getBasketGoodsSelector(),"2");
        mainPage.webElementClickWaitCheckEqualV(testCaseBuyGoods.getBasketGoodsDecrementSelector(),testCaseBuyGoods.getBasketGoodsSelector(),"1");

       // at last clear basket and check this case ".//td/a[contains(@class,'delete')]"//проверка по тексту "Список покупок порожній"
        mainPage.webElementClickWaitCheck(testCaseBuyGoods.getBasketGoodsDeleteSelector(),testCaseBuyGoods.getBasketEmptyTextSelector(), testCaseBuyGoods.getBasketEmptyText());
             System.out.println( "Tests.pn-done" );
    }


}