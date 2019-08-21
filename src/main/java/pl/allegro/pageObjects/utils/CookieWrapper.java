package pl.allegro.pageObjects.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Date;


public class CookieWrapper {
    //Friday, August 21, 2020 1:58:31 PM
    public static final long EPOCHINMILIS =1598018311000L;

    public static void addCookie(WebDriver driver,String name, String value, String domain, String path) {
        driver.manage().addCookie(
                new Cookie(name, value, domain, path, new Date(EPOCHINMILIS)));
    }
}
