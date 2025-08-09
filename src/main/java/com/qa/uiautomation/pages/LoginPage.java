package com.qa.uiautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private String loginBtn="//div[@class='d-flex align-items-center']/descendant::button/following-sibling::button";
    private String userName = "//div[@class='mat-mdc-form-field-infix ng-tns-c508571215-1']/child::input";
    private String password = "//div[@class='mat-mdc-form-field-infix ng-tns-c508571215-2']/child::input";
    private String loginButton="//span[@class='mdc-button__label' and text()='Login']";
    private String bookCartPage = "//span[text()=' All Categories ']";
    private String clickCircle="//div[@class='d-flex align-items-center']/descendant::*[contains(text(),'account_circle')]";
    private String loginText="//div[@class='d-flex align-items-center']/descendant::span[@class='mdc-button__label'][1]";
    private String logOut="//span[text()='Logout']";
    private String clickBookCart="//span[contains(text(),'Book Cart')]";
    private Page page;
    public LoginPage(Page page) {
        this.page = page;
    }
    public String getLoginPageTitle() {
        return page.title();
    }
    public String loginToBookcart(String un, String pwd){
        page.click(loginBtn);
        page.fill(userName,un);
        page.fill(password,pwd);
        page.click(loginButton);
        page.locator(bookCartPage).waitFor(new Locator.WaitForOptions().setTimeout(5000));
        String loginUser=page.locator(loginText).textContent();
//        clickLogout();
        return loginUser;
    }

    public void clickLogout(){
        page.click(clickCircle);
        page.click(logOut);
        page.click(clickBookCart);
        page.reload();
    }


}
