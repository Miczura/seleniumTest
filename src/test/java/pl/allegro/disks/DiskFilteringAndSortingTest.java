package pl.allegro.disks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.allegro.pageObjects.pages.MainPage;

public class DiskFilteringAndSortingTest {
    private MainPage mainpage  = new MainPage(driver);
    private static WebDriver driver;

    @BeforeClass
    public static void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Before
    public void openAllegro(){
        mainpage.navigateToMainPage();
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(2000);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
