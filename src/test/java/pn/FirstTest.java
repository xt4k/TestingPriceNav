package pn;

import TestData.TestCaseBuyGood;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import java.util.concurrent.TimeUnit;

public class FirstTest extends page.BaseTest {
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

        
        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//check string in dropped list // ".//*[@id=\"search\"]//a[contains(.,'Toto TPU')]" //"Toto TPU Case Anti-Shock Apple iPhone SE"
        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getDropLineSelector() ) ), testCaseBuyGoods.getExtpectedDropLine() );

        //3) Choose goods from dropdown list and go to category page
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getDropLineSelector() ) ) );

        //4) Choose any phone with  First color and go to product page       //".//strong[text()='Колір']"// ".//strong[text()='Колір']/../..//a[text()='Прозорий']"
        // Check that colour is selected "active"
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getColourListboxFilterSelector() ) ) );
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() ) ) );
        mainPage.checkWebElementClassTextEquals( driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() + "/.." ) ), testCaseBuyGoods.getSelectedColorState() );

        //5) Change color
        // step a - deselect 1st colour and check that colour is not selected  .//strong[text()='Колір']/../..//a[text()='Блакитний']"
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() ) ) );
        mainPage.checkWebElementClassTextEquals( driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() + "/.." ) ), "" );
        //step b - select other colour ".//strong[text()='Колір']/../..//a[text()='Блакитний']/.." and check that it is selected
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getSecondColourSelector() ) ) );
        mainPage.checkWebElementClassTextEquals( driver.findElement( By.xpath( testCaseBuyGoods.getSecondColourSelector() + "/.." ) ), testCaseBuyGoods.getSelectedColorState() );

        // click on selected goods ".//a[text()='Toto TPU Case Anti-Shock Apple iPhone SE Blue']"
        // and check if it same goods that is expected ".//h1/span" // "Toto TPU Case Anti-Shock Apple iPhone SE Blue"

        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getFinalGoodSelector() ) ) );
        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getFinalGoodName() ) ), testCaseBuyGoods.getFinalGoodNameContent() );

        //6) Add product to the basket   //".//span/a[contains(.,'Покупки')]/span"
        // check that  basket initially is empty  // ".//div[1]/div[5]/a" then sequentally click to add there goods and check basket state
        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ), "" );
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ) );

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ), "1" );
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ) );

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ), "0" );
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ) );

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ), "1" );

        //+7)  Check into basket
//navigate into basket and check it again as it was done before
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ) );

        // ".//input[contains(@name,'OrderItem_amount')]"//"1" );
        mainPage.checkWebElementValueTextEquals( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ), "1" );
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsIncrementSelector() ) ) );

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.checkWebElementValueTextEquals( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ), "2" );
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsDecrementSelector() ) ) );

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.checkWebElementValueTextEquals( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ), "1" );
// at last clear basket and check this case ".//td/a[contains(@class,'delete')]"
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsDeleteSelector() ) ) );

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
//проверка по тексту "Список покупок порожній"
        mainPage.checkWebElementContainText( driver.findElement( By.xpath( testCaseBuyGoods.getBasketEmptyTextSelector() ) ), testCaseBuyGoods.getBasketEmptyText() );

        System.out.println( "pn-done" );
    }


}