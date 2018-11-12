package com.epam.auto.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CityPicker {

    @CacheLookup
    @FindBy(id = "flights-originSurrogate")
    private WebElement input;

    @CacheLookup
    @FindBy(css = "#frequent-routes-AU > div:nth-child(2) > ul > li:nth-child(1) > a")
    private WebElement sydney;

    public CityPicker chooseSydney() {
        input.click();
        sydney.click();
        return this;
    }

    public String getInputValue() {
        return input.getAttribute("value");
    }

}
