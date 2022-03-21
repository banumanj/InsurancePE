package com.stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ConfigFileReader;
import utils.TestUtil;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    private static ConfigFileReader reader;

    @BeforeAll
    public static void initAll() {
        reader = new ConfigFileReader();
        String browserName = reader.browserName();
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/Drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

@AfterAll
public static void tearDown() {
    driver.close();
}
}
