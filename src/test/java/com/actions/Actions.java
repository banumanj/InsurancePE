package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigFileReader;

public class Actions {

    WebDriver driver;
    ConfigFileReader fileReader;
    Logger logger = LoggerFactory.getLogger(Actions.class);


    public Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void openDetailsPolicyExpertPage() {
        fileReader = new ConfigFileReader();
        driver.get(fileReader.getUrl());

    }
    public void setSelectValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
            }

    public void clickButton(WebElement webElement) {
        webElement.click();
    }

    public void setTextBoxValue(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

}
