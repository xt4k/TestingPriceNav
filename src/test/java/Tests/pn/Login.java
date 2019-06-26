package Tests.pn;

import TestData.TestCaseBuyGood;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AuthFormPage;
import page.MainPage;

public class Login extends BaseTest {
    @Test(dataProvider = "testSuccessAuthDataProvider")
    public void positiveScenario(String loginFromExcelFile, String passwordFromExcelFile, String userNameExpected) {
        // 0) open site
        // 1) click login
        // 2) click on small popup
        // 3) enter e-mail
        // 4) enter password
        // 5) click login
        //
        // .//*[contains(@class,'user-info')]
        //.//*[contains(@onclick,'showLoginForm()')]
        //  email. //*[@id="login-form-login"]
        // password .//*[@id="login-form-password"]
        // login .//*[@id="loginButton"]
        //.//span[contains(@class,'user-info')]//span  == selenium_test_examples
        TestCaseBuyGood testCaseBuyGoods = new TestCaseBuyGood();

        driver.get( testCaseBuyGoods.getSiteUrl() );

        MainPage mainPage = new MainPage( driver );
        String oldMessage = mainPage.getEnterLinkText();
        AuthFormPage authFormPage = mainPage.clickEnterLink();

        authFormPage.openLoginWindowPopup( true );



        authFormPage.enterLogin( loginFromExcelFile );
        authFormPage.enterPassword( passwordFromExcelFile );
        mainPage = (MainPage) authFormPage.submit( true );

        mainPage = mainPage.waitUntilLinkTextChanged( oldMessage );
        String userNameActual = mainPage.getEnterLinkText();
        System.out.println("userNameActual: "+userNameActual);
        System.out.println("userNameExpected: "+userNameExpected);
        Assert.assertEquals( userNameActual, userNameExpected );
    }

    @DataProvider(name = "testSuccessAuthDataProvider")
    private Object[][] testSuccessAuthDataProvider() {
        String loginFromExcelFile = "selenium_test_examples@ukr.net";
        String passwordFromExcelFile = "test_123";
        String userNameExpected = "selenium_test_examples";
//            String login = PropertyReader.from("rozetka").getProperty("login");
//           String password = PropertyReader.from("rozetka").getProperty("password");
//            String userNameExpected = PropertyReader.from("rozetka").getProperty("username");

        return new Object[][]{
                {loginFromExcelFile, passwordFromExcelFile, userNameExpected}
        };
    }


}
