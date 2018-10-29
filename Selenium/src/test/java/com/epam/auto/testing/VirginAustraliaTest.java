package com.epam.auto.testing;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class VirginAustraliaTest {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "d://AutomaticTesting/Selenium/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.virginaustralia.com/");

        WebElement acceptCookies = driver.findElementById("cookieAcceptButton");
        if (acceptCookies != null) {
            acceptCookies.click();
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.id("remindMeLater"))
        );

        WebElement reminder = driver.findElementById("remindMeLater");
        reminder.click();

        WebElement input = driver.findElementById("flights-originSurrogate");
        input.click();

        String selector = "#frequent-routes-AU > div:nth-child(2) > ul > li:nth-child(1) > a";
        wait = new WebDriverWait(driver, 5);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector))
        );

        WebElement sydney = driver.findElementByCssSelector(selector);
        sydney.click();

        Assert.assertEquals("Brisbane (BNE)", input.getAttribute("value"));

        driver.quit();
    }

}