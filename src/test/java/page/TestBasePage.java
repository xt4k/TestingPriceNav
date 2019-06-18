package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBasePage {
    private final int EXPLICITLY_WAIT_TIMEOUT = 5;

    protected WebDriver driver;

    public TestBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        return;
    }

}
