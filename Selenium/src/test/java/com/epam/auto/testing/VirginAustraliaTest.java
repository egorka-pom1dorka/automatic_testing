package com.epam.auto.testing;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class VirginAustraliaTest {

    private WebDriver driver;

    private final static String DRIVER_PATH = "d://AutomaticTesting/Selenium/chromedriver.exe";
    private final static String MAIN_PAGE = "https://www.virginaustralia.com";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage()
                .window()
                .maximize();
        waitForSeconds(10);
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
        waitForSeconds(10);
        CookiesPrivacyPage cookies = PageFactory.initElements(driver, CookiesPrivacyPage.class);
        cookies.accept();
    }

    private void skipBanner() {
        waitForSeconds(10);
        PopUpBanner banner = PageFactory.initElements(driver, PopUpBanner.class);
        banner.skip();
    }

    @Test
    public void shouldChangeUILanguageWhenNewLanguageSelected() {
        waitForSeconds(10);
        LanguagePicker picker = PageFactory.initElements(driver, LanguagePicker.class);
        picker.chooseLanguage("United Kingdom");
        Assert.assertEquals("United Kingdom", picker.getCurrentLanguage());
    }

    @Test
    public void shouldStopSliderByControlButtonPressing() {
        waitForSeconds(10);
        Slider slider = PageFactory.initElements(driver, Slider.class);
        slider.off();
        Assert.assertFalse(slider.isLaunched());
    }

    @Test
    public void shouldDisableReturnDateInputWhenOneWaySelected() {
        waitForSeconds(10);
        FlightWays ways = PageFactory.initElements(driver, FlightWays.class);
        ways.chooseOneWay();
        DatePicker picker = PageFactory.initElements(driver, DatePicker.class);
        Assert.assertTrue(picker.isReturnDateDisabled());
    }

    @Test
    public void shouldDispatchCityChangedWhenNewCitySelected() {
        waitForSeconds(10);
        CityPicker picker = PageFactory.initElements(driver, CityPicker.class);
        picker.clickOnFromCityInput();
        picker.chooseCityTabByCode("AU");
        picker.chooseCityByCode("BNE");
        Assert.assertEquals("Brisbane (BNE)", picker.getFromCityValue());
    }

    @Test
    public void shouldSelectDateWithCorrectInputData() {
        waitForSeconds(10);
        DatePicker picker = PageFactory.initElements(driver, DatePicker.class);
        picker.chooseDepartureDate(30, 12, 2018);
        Assert.assertEquals("30 Dec, 2018", picker.getFromDateValue());
    }

    @After
    public void close() {
        driver.quit();
    }

}