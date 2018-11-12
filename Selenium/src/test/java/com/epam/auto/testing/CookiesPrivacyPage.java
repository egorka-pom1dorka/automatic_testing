package com.epam.auto.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class CookiesPrivacyPage {

    @CacheLookup
    private WebElement cookieAcceptButton;

    public CookiesPrivacyPage accept() {
        cookieAcceptButton.click();
        return this;
    }

}
