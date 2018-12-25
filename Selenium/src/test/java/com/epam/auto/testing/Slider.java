package com.epam.auto.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Slider {

    @CacheLookup
    @FindBy(css = "li[role='button']")
    WebElement controlButton;

    boolean autoPlay = true;

    public Slider on() {
        if (!autoPlay) {
            controlButton.click();
            autoPlay = true;
        }
        return this;
    }

    public Slider off() {
        if (autoPlay) {
            controlButton.click();
            autoPlay = false;
        }
        return this;
    }

    public boolean isLaunched() {
        return autoPlay;
    }

}
