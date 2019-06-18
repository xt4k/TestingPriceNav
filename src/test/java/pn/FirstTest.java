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
        MainPage mainPage = new MainPage(driver);
        mainPage.enterAndSearchSomeString(testCaseBuyGoods.getSearchString());

        //getSearchSelector        //
       /* driver.findElement( By.xpath( testCaseBuyGoods.getSearchSelector() ) ).click();
        driver.findElement( By.xpath( testCaseBuyGoods.getSearchSelector() ) ).clear();
        driver.findElement( By.xpath( testCaseBuyGoods.getSearchSelector() ) ).sendKeys( testCaseBuyGoods.getSearchString() );*/
        //driver.findElement( By.xpath( testCaseBuyGoods.getSearchSelector() ) ).click();

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.checkWebElementContainText(driver.findElement(By.xpath(testCaseBuyGoods.getDropLineSelector())),testCaseBuyGoods.getExtpectedDropLine());
        // ".//*[@id=\"search\"]//a[contains(.,'Toto TPU')]"
        // WebElement searchStringElement = driver.findElement( By.xpath( testCaseBuyGoods.getDropLineSelector() ) );
       // String str = searchStringElement.getText();
        //"Toto TPU Case Anti-Shock Apple iPhone SE"
        //Assert.assertTrue( str.contains( testCaseBuyGoods.getExtpectedDropLine() ) );

        //3) Choose goods from dropdown list and go to category page
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getDropLineSelector() ) ));
        //driver.findElement( By.xpath( testCaseBuyGoods.getDropLineSelector() ) ).click();

        //4) Choose any phone with  First ("Rose") color and go to product page
        //".//strong[text()='Колір']"
       // driver.findElement( By.xpath( testCaseBuyGoods.getColourListboxFilterSelector() ) ).click();
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getColourListboxFilterSelector() )));

        // ".//strong[text()='Колір']/../..//a[text()='Прозорий']"
       // driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() ) ).click();
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() ) ));

       // WebElement colorState = driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() + "/.." ) );
        //"active"
       // Assert.assertEquals( String.valueOf( colorState.getAttribute( "class" ) ), testCaseBuyGoods.getSelectedColorState() );
        mainPage.checkWebElementClassTextEquals(driver.findElement(By.xpath(testCaseBuyGoods.getFirstColourSelector() + "/..")),testCaseBuyGoods.getSelectedColorState());


        //5) Change color to Second ("Space Gray")
        //driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() ) ).click();
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() ) ));

       // WebElement colorState = driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() + "/.." ) );

        //Assert.assertEquals( String.valueOf( colorState.getAttribute( "class" ) ), "" );        //".//strong[text()='Колір']/../..//a[text()='Блакитний']"
        mainPage.checkWebElementClassTextEquals(driver.findElement( By.xpath( testCaseBuyGoods.getFirstColourSelector() + "/.." ) ),"");

       // driver.findElement( By.xpath( testCaseBuyGoods.getSecondColourSelector() ) ).click();  // ".//strong[text()='Колір']/../..//a[text()='Блакитний']/.."
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getSecondColourSelector() ) ));
        //String strLocator = (testCaseBuyGoods.getSecondColourSelector() + "/..");
        //WebElement colorState = driver.findElement( By.xpath( testCaseBuyGoods.getSecondColourSelector() + "/.." ) );
        //Assert.assertEquals( String.valueOf( colorState.getAttribute( "class" ) ), testCaseBuyGoods.getSelectedColorState() );
        mainPage.checkWebElementClassTextEquals(driver.findElement( By.xpath( testCaseBuyGoods.getSecondColourSelector() + "/.." ) ),testCaseBuyGoods.getSelectedColorState());


        // ".//a[text()='Toto TPU Case Anti-Shock Apple iPhone SE Blue']"
       // driver.findElement( By.xpath( testCaseBuyGoods.getFinalGoodSelector() ) ).click();
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getFinalGoodSelector() ) ));

        // ".//h1/span"
       // WebElement selectedProduct = driver.findElement( By.xpath( testCaseBuyGoods.getFinalGoodName() ) );
        // "Toto TPU Case Anti-Shock Apple iPhone SE Blue"
       //Assert.assertTrue( Boolean.parseBoolean( String.valueOf( selectedProduct.getText().contains( testCaseBuyGoods.getFinalGoodNameContent() ) ) ) );
        mainPage.checkWebElementContainText(driver.findElement( By.xpath( testCaseBuyGoods.getFinalGoodName() ) ),testCaseBuyGoods.getFinalGoodNameContent());

        //6) Add product to the basket
        //".//span/a[contains(.,'Покупки')]/span"
       // WebElement basketContent = driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) );
       // Assert.assertEquals( String.valueOf( basketContent.getText() ), "" );
        mainPage.checkWebElementContainText(driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ),"");


        // ".//div[1]/div[5]/a"
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ));
       // driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ).click();

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // basketContent = driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) );
       // Assert.assertEquals( String.valueOf( basketContent.getText() ), "1" );
        mainPage.checkWebElementContainText(driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ),"1");


      //  driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ).click();
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ));

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // basketContent = driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) );
       // Assert.assertEquals( String.valueOf( basketContent.getText() ), "0" );
        mainPage.checkWebElementContainText(driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ),"0");

        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ));
        //driver.findElement( By.xpath( testCaseBuyGoods.getBasketSelector() ) ).click();


        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // basketContent = driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) );
        //Assert.assertEquals( String.valueOf( basketContent.getText() ), "1" );
        mainPage.checkWebElementContainText(driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ),"1");

        //+7)  Check into basket

       // driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ).click();
        mainPage.webElementClick(  driver.findElement( By.xpath( testCaseBuyGoods.getAddToBasketSelector() ) ));

        // ".//input[contains(@name,'OrderItem_amount')]"
       // String actualBasketGoods = driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ).getAttribute( "value" );
       // Assert.assertEquals( actualBasketGoods, "1" );
        mainPage.checkWebElementValueTextEquals(driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ),"1");

        //".//input[contains(@name,'OrderItem_amount')]/../a[contains(.,'+')]"
       // driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsIncrementSelector() ) ).click();
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsIncrementSelector() ) ));

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // actualBasketGoods = driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ).getAttribute( "value" );
       // Assert.assertEquals( actualBasketGoods, "2" );
        mainPage.checkWebElementValueTextEquals(driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ),"2");


// ".//input[contains(@name,'OrderItem_amount')]/../a[contains(.,'-')]"
       // driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsDecrementSelector() ) ).click();
        mainPage.webElementClick(driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsDecrementSelector() ) ));

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //actualBasketGoods = driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ).getAttribute( "value" );
       // Assert.assertEquals( actualBasketGoods, "1" );
        mainPage.checkWebElementValueTextEquals(driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsSelector() ) ),"1");
//".//td/a[contains(@class,'delete')]"
       // driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsDeleteSelector() ) ).click();
        mainPage.webElementClick( driver.findElement( By.xpath( testCaseBuyGoods.getBasketGoodsDeleteSelector() ) ));

        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
//"Список покупок порожній"
      //  actualBasketGoods = driver.findElement( By.xpath( testCaseBuyGoods.getBasketEmptyTextSelector() ) ).getText();
       // Assert.assertEquals( actualBasketGoods, testCaseBuyGoods.getBasketEmptyText() );
        mainPage.checkWebElementContainText(driver.findElement( By.xpath( testCaseBuyGoods.getBasketEmptyTextSelector() ) ),testCaseBuyGoods.getBasketEmptyText());

        System.out.println( "pn-done" );
    }


}