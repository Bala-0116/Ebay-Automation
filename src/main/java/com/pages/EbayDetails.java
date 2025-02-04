package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayDetails {

        WebDriver driver;

        public EbayDetails(WebDriver driver) {
            this.driver = driver;
            //This initElements method will create all WebElements
            PageFactory.initElements(driver, this);
        }


        @FindBy(xpath = "//input[@class='gh-search-input gh-tb ui-autocomplete-input']")
        public WebElement searchbox;

        @FindBy(xpath = "//button[@class='gh-search-button btn btn--primary']")
        public WebElement searchbtn;

        @FindBy(xpath = "//*[@id=\"item57841b8566\"]/div/div[1]/div/a/div/img")
        public WebElement bookdetail;


       /* @FindBy(xpath = "//a[@id='atcBtn_btn_1']")
        public WebElement addtocartbtn;*/

        //@FindBy(xpath = "//a[@id='atcBtn_btn_1']")
        //@FindBy(xpath = "//span[text()='Add to cart']")
        @FindBy(xpath = "(//span[@role='heading'])[3]")
        public WebElement addtocartbtn;

        @FindBy(xpath = "//span[@class='gh-cart__icon']")
        public WebElement carticon;

        @FindBy(xpath = "//span[@class='badge']")
        public WebElement cartcountindicator;



    }
