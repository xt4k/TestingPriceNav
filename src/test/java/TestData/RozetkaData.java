package TestData;

public class RozetkaData {
    private String siteUrl;
    private String searchSelector;
    private String searchString;

    private String dropLineSelector;
    private String extpectedDropLine;

    private String firstVendorSelector;
    private String selectedVendorState;
    private String secondVendorSelector;

    private String finalGoodSelector;
    private String finalGoodName;
    private String finalGoodNameContent;
    private String finalGoodImageSelector;

    private String basketCandidateTitle;// ="Korg nanoKONTROL Studio (222888)";
    private String basketCandidateSelector;//=".//*[@id=\"cdk-overlay-28\"]//h2";

    private String addToBasketSelector;
    private String basketGoodsSelector;
    private String basketGoodsActionTitle;

    private String basketGoodsIncrementSelector;
    private String basketGoodsDecrementSelector;

    private String basketGoodsDeleteSelector;
    private String basketGoodsDeleteConfirmSelector;

    private String basketEmptyTextSelector;
    private String basketEmptyText;

    public String getBasketGoodsActionTitle() {
        return basketGoodsActionTitle;
    }

    public String getBasketCandidateTitle() {
        return basketCandidateTitle;
    }

    public String getBasketCandidateSelector() {
        return basketCandidateSelector;
    }

    public String getFinalGoodImageSelector() {
        return finalGoodImageSelector;
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

    public String getFirstVendorSelector() {
        return firstVendorSelector;
    }

    public String getSecondVendorSelector() {
        return secondVendorSelector;
    }

    public String getFinalGoodSelector() {
        return finalGoodSelector;
    }

    public String getFinalGoodName() {
        return finalGoodName;
    }

    public String getFinalGoodNameContent() {
        return finalGoodNameContent;
    }

    public String getAddToBasketSelector() {
        return addToBasketSelector;
    }

    public String getBasketGoodsSelector() {
        return basketGoodsSelector;
    }

    public String getBasketGoodsIncrementSelector() {
        return basketGoodsIncrementSelector;
    }

    public String getBasketGoodsDecrementSelector() {
        return basketGoodsDecrementSelector;
    }

    public String getBasketGoodsDeleteSelector() {
        return basketGoodsDeleteSelector;
    }

    public String getBasketGoodsDeleteConfirmSelector() {
        return basketGoodsDeleteConfirmSelector;
    }

    public String getBasketEmptyTextSelector() {
        return basketEmptyTextSelector;
    }

    public String getBasketEmptyText() {
        return basketEmptyText;
    }

    public RozetkaData() {
        this.siteUrl = "https://rozetka.com.ua/";
        this.searchSelector = ".//input";
        this.searchString = "iphone 8";
        this.dropLineSelector = ".//div//a[contains(.,'iphone 8 64')]";
        this.extpectedDropLine = "//*[@id=\"search_result_title_text\"]";

        this.firstVendorSelector = ".//*[@id=\"sort_producer\"]//i[contains(.,'Valenta')]";
        this.secondVendorSelector = ".//*[@id=\"sort_producer\"]//i[contains(.,'Korg')]";
        this.selectedVendorState = "true";//checked";// .//*[@id="sort_producer"]//input[contains(@checked,'checked')]

        this.finalGoodSelector = ".//*[@id=\"image_item14463866\"]";//
        this.finalGoodName = ".//h1";
        this.finalGoodNameContent = "Korg nanoKONTROL Studio (222888)";
        this.finalGoodImageSelector =".//pp-main-photo//a";

        this.basketCandidateTitle ="Korg nanoKONTROL Studio (222888)";
        this.basketCandidateSelector=".//*[@id=\"cdk-overlay-39\"]//h2";//.//*[@id=\"cdk-overlay-39\"]//h2";

        this.addToBasketSelector = ".//rz-cart-button-simple//form";//.//*[@id=\"cdk-overlay-0\"]//span/span";//.//pp-photo-block/div[1]";
        this.basketGoodsSelector = ".//*[@id=\"cdk-overlay-1\"]//h2";
        this.basketGoodsActionTitle = "Вы добавили товар в корзину";//Ви додали товар у кошик";

        this.basketGoodsIncrementSelector = ".//button//rz-svg-sprite[contains(@icon,'plus')]";
        this.basketGoodsDecrementSelector = ".//button//rz-svg-sprite[contains(@icon,'minus')]";

        this.basketGoodsDeleteSelector = "//*[@id=\"close-cross\"]";
        this.basketGoodsDeleteConfirmSelector = ".//rz-svg-sprite[contains(@icon,'remove')]/..";

        this.basketEmptyText = "Корзина пуста";
        this.basketEmptyTextSelector = ".//div[contains(@class,'cart-dummy-inner')]";

    }
}

