package com.epam.auto.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LanguagePicker {

    WebDriver driver;

    @CacheLookup
    @FindBy(id = "current-pos")
    WebElement dropdown;

    @CacheLookup
    @FindBy(css = "#current-pos .ui-corner-all")
    WebElement currentLanguage;

    @CacheLookup
    WebElement posSelectBtn;

    public LanguagePicker(WebDriver driver) {
        this.driver = driver;
    }

    public LanguagePicker chooseLanguage(String country) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dropdown.click();
        WebElement region = driver.findElement(By.cssSelector("a[aria-label='" + country + "']"));
        region.click();
        posSelectBtn.click();
        return this;
    }

    public String getCurrentLanguage() {
        return currentLanguage.getText();
    }

}