package com.ui.tests;

import com.ui.pageobjects.HomePage;
import com.ui.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest {

    @Test
    public void testLogin() {
        //System.setProperty("webdriver.chrome.driver", "/Users/gurudattsa/IdeaProjects/Selenium4-test/driver/
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        LoginPage signInPage = new LoginPage(driver);
        HomePage homePage = signInPage.loginValidUser("userName", "password");
        assertThat(homePage.getMessageText(), is("Hello userName"));
    }
}
