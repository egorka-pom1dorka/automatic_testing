package com.epam.auto.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class PopUpBannerPage {

    @CacheLookup
    private WebElement remindMeLater;

    public PopUpBannerPage skip() {
        remindMeLater.click();
        return this;
    }

}
