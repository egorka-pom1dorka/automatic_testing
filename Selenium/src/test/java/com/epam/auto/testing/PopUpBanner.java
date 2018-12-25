package com.epam.auto.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PopUpBanner {

    @CacheLookup
    private WebElement remindMeLater;

    public PopUpBanner skip() {
        if (remindMeLater.isDisplayed()) {
            remindMeLater.click();
        }
        return this;
    }

}
