package com.epam.auto.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FlightWays {

    @CacheLookup
    @FindBy(id = "flights-oneway")
    WebElement oneWay;

    @CacheLookup
    @FindBy(id = "flights-return")
    WebElement returnWay;

    public FlightWays chooseOneWay() {
        oneWay.click();
        return this;
    }

    public FlightWays chooseReturnWay() {
        returnWay.click();
        return this;
    }

}
