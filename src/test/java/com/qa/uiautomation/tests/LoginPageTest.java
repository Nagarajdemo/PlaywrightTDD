package com.qa.uiautomation.tests;

import com.microsoft.playwright.Page;
import com.qa.uiautomation.base.BaseTest;
import com.qa.uiautomation.factory.PlaywrightFactory;
import com.qa.uiautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPageTest extends BaseTest {

    @Test
    public void checkForLoginTitle(){
        Assert.assertEquals("Home",loginPage.getLoginPageTitle());
    }
    @DataProvider
    public Object[][] getUNPWD() {
        return new Object[][] {
                { "ortoni","pass1234" },
                { "cucumber1","Pass12345" },
                {"cucumber2","Pass1234"}
        };
    }

    @Test(dataProvider = "getUNPWD")
    public void checkForSuccessfulLogin(String username, String password){
        String loginValidation=loginPage.loginToBookcart(username,password);
        Assert.assertEquals(loginValidation.trim(),loginValidation.trim());
        System.out.println(loginValidation);
    }


}
