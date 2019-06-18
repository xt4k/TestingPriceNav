package TestData;

import org.testng.annotations.DataProvider;

public class TestCaseBuyGood {
    private String siteUrl;
    private String searchSelector;
    private String searchString;

    private String dropLineSelector;
    private String extpectedDropLine;

    private String colourListboxFilterSelector;
    private String firstColourSelector;
    private String selectedColorState;

    private String secondColourSelector;

    private String finalGoodSelector;
    private String finalGoodName;
    private String finalGoodNameContent;

    private String addToBasketSelector;
    private String basketSelector;

    private String basketGoodsSelector;
    private String basketGoodsIncrementSelector;
    private String basketGoodsDecrementSelector;
    private String basketGoodsDeleteSelector;
    private String basketEmptyTextSelector;
    private String basketEmptyText;

    public String getBasketEmptyTextSelector() {
        return basketEmptyTextSelector;
    }


    public String getBasketEmptyText() {
        return basketEmptyText;
    }


    public String getBasketGoodsDeleteSelector() {
        return basketGoodsDeleteSelector;
    }


    public String getBasketGoodsIncrementSelector() {
        return basketGoodsIncrementSelector;
    }


    public String getBasketGoodsDecrementSelector() {
        return basketGoodsDecrementSelector;
    }



    public String getFinalGoodNameContent() {
        return finalGoodNameContent;
    }



    public String getFinalGoodName() {
        return finalGoodName;
    }

    public String getSelectedColorState() {
        return selectedColorState;
    }


    public String getSiteUrl() {
        return siteUrl;
    }


    public String getSearchSelector() {
        return searchSelector;
    }


    public String getSearchString() {
        return searchString;
    }



    public String getDropLineSelector() {
        return dropLineSelector;
    }

    public String getExtpectedDropLine() {
        return extpectedDropLine;
    }


    public String getColourListboxFilterSelector() {
        return colourListboxFilterSelector;
    }


    public String getFirstColourSelector() {
        return firstColourSelector;
    }


    public String getSecondColourSelector() {
        return secondColourSelector;
    }

    public String getFinalGoodSelector() {
        return finalGoodSelector;
    }


    public String getAddToBasketSelector() {
        return addToBasketSelector;
    }


    public String getBasketSelector() {
        return basketSelector;
    }


    public String getBasketGoodsSelector() {
        return basketGoodsSelector;
    }


    public TestCaseBuyGood() {
        this.siteUrl = "https://pn.com.ua/";
        this.searchSelector = ".//*[contains(@class,'search-text-input')]";
        this.searchString = "iphone se";
        this.dropLineSelector = ".//*[@id=\"search\"]//a[contains(.,'Toto TPU')]";
        this.extpectedDropLine = "Toto TPU Case Anti-Shock Apple iPhone SE";
        this.colourListboxFilterSelector = ".//strong[text()='Цвет']";//Колір']";
        this.firstColourSelector = ".//strong[text()='Цвет']/../..//a[text()='Прозрачный']";//Колір_Прозорий']";
        this.selectedColorState = "active";
        this.secondColourSelector = ".//strong[text()='Цвет']/../..//a[text()='Голубой']";//Колір_Блакитний']";
        this.finalGoodSelector = ".//a[text()='Toto TPU Case Anti-Shock Apple iPhone SE Blue']";
        this.finalGoodName = ".//h1/span";
        this.finalGoodNameContent = "Toto TPU Case Anti-Shock Apple iPhone SE Blue";
        this.addToBasketSelector = ".//span/a[contains(.,'Покупки')]/span";
        this.basketSelector = ".//div[1]/div[5]/a";
        this.basketGoodsSelector = ".//input[contains(@name,'OrderItem_amount')]";
        this.basketGoodsIncrementSelector = ".//input[contains(@name,'OrderItem_amount')]/../a[contains(.,'+')]";
        this.basketGoodsDecrementSelector = ".//input[contains(@name,'OrderItem_amount')]/../a[contains(.,'-')]";
        this.basketGoodsDeleteSelector = ".//td/a[contains(@class,'delete')]";
        this.basketEmptyTextSelector = ".//h2";
        this.basketEmptyText = "Список покупок пустой";//Список покупок порожній";
    }
}

