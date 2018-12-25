package com.epam.auto.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class CityPicker {

    WebDriver driver;

    @CacheLookup
    @FindBy(id = "flights-originSurrogate")
    private WebElement fromCity;

    @CacheLookup
    @FindBy(id = "flights-destinationSurrogate")
    private WebElement departureCity;

    public CityPicker(WebDriver driver) {
        this.driver = driver;
    }

    public CityPicker clickOnFromCityInput() {
        fromCity.click();
        return this;
    }

    public CityPicker clickOnDepartureCityInput() {
        departureCity.click();
        return this;
    }

    public CityPicker chooseCityTabByCode(String code) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement tab = driver.findElement(By.id(code));
        tab.click();
        return this;
    }

    public CityPicker chooseCityByCode(String code) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement city = driver.findElement(By.cssSelector("[data-iata='" + code + "']"));
        city.click();
        return this;
    }

    public String getFromCityValue() {
        return fromCity.getAttribute("value");
    }

}
