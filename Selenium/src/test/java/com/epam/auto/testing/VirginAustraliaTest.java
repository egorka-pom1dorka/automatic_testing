package com.epam.auto.testing;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class VirginAustraliaTest {

    private WebDriver driver;

    private final static int TIMEOUT = 10;
    private final static String DRIVER_PATH = "d://AutomaticTesting/Selenium/chromedriver.exe";
    private final static String MAIN_PAGE = "https://www.virginaustralia.com";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage()
                .window()
                .maximize();
        waitForSeconds(TIMEOUT);
        driver.get(MAIN_PAGE);

        acceptCookies();
        skipBanner();
    }

    private void waitForSeconds(int secs) {
        driver.manage()
                .timeouts()
                .implicitlyWait(secs, TimeUnit.SECONDS);
    }

    private void acceptCookies() {
        waitForSeconds(TIMEOUT);
        CookiesPrivacyPage cookies = PageFactory.initElements(driver, CookiesPrivacyPage.class);
        cookies.accept();
    }

    private void skipBanner() {
        waitForSeconds(TIMEOUT);
        PopUpBannerPage banner = PageFactory.initElements(driver, PopUpBannerPage.class);
        banner.skip();
    }

    @Test
    public void shouldDispatchCityChangedWhenNewCitySelected() {
        waitForSeconds(TIMEOUT);
        CityPicker picker = PageFactory.initElements(driver, CityPicker.class);
        picker.chooseSydney();
        Assert.assertEquals("Brisbane (BNE)", picker.getInputValue());
    }

    @After
    public void close() {
        driver.quit();
    }

}