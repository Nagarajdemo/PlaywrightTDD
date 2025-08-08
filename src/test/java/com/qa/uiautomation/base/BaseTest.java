package com.qa.uiautomation.base;

import com.microsoft.playwright.Page;
import com.qa.uiautomation.factory.PlaywrightFactory;
import com.qa.uiautomation.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected LoginPage loginPage;
    @Parameters({ "browser" })
    @BeforeTest
    public void setup(String browserName) {
        pf = new PlaywrightFactory();

        prop = pf.init_prop();

        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }

        page = pf.init(prop);
        loginPage = new LoginPage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }


}
