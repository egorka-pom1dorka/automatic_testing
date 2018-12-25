package com.epam.auto.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePicker {

    private WebDriver driver;

    @CacheLookup
    @FindBy(id = "flights-departure-date")
    private WebElement fromDate;

    @CacheLookup
    @FindBy(id = "flights-return-date")
    private WebElement returnDate;

    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    public DatePicker chooseDepartureDate(int day, int month, int year) {
        fromDate.click();
        WebElement date = getDateElement(day, month, year);
        date.click();
        return this;
    }

    public DatePicker chooseReturnDate(int day, int month, int year) {
        returnDate.click();
        WebElement date = getDateElement(day, month, year);
        date.click();
        return this;
    }

    private WebElement getDateElement(int day, int month, int year) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String path = ".//td[@data-month='" + (month - 1) + "'][@data-year='" + year + "']/a[text()='" + day + "']";
        return driver.findElement(By.xpath(path));
    }

    public String getFromDateValue() {
        return fromDate.getAttribute("value");
    }

    public boolean isReturnDateDisabled() {
        boolean isDisabled = false;
        try {
            String value = returnDate.getAttribute("disabled");
            if (value != null){
                isDisabled = true;
            }
        } catch (Exception e) {

        }

        return isDisabled;
    }

}
