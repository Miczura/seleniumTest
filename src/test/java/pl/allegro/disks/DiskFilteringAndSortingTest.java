package pl.allegro.disks;

import io.github.bonigarcia.wdm.WebDriverManager;


import io.qameta.allure.Description;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pl.allegro.pageObjects.pages.ExternalAndPortableDiscsPage;
import pl.allegro.pageObjects.pages.MainPage;
import pl.allegro.pageObjects.utils.ScreenShotFailedTests;


public class DiskFilteringAndSortingTest {
    private static WebDriver driver;
    private ExternalAndPortableDiscsPage externalAndPortableDiscsPage;
    private MainPage mainpage = new MainPage(driver);
    @Rule
    public ScreenShotFailedTests failure = new ScreenShotFailedTests(driver);

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        driver = new ChromeDriver(options);

    }

    @Test
    @Description("Navigate from allegro.pl to portable disc and memories page, set filters " +
            "for disc capacity and sort results from most expensive desc")
    public void testIfProductsOnExternalAndPortableDiscsPageAreSortedWithExpectedFiltering()  {
        //given
       navigateToExternalAndPortableDiscPage();
        //when
       externalAndPortableDiscsPage.getExternalAndPortableDiscsMenu()
              .setupfilteringDiscCapacity("200","300")
              .selectSortingMethod();
        //then checking if prices are sorted descending
       externalAndPortableDiscsPage.getExternalAndPortableDiscsMenu()
              .checkIfPricesAreSorted(externalAndPortableDiscsPage
                      .getExternalAndPortableDiscsMenu()
                      .getListOfPrices());

    }



    @AfterClass
    public static void teardown(){
        driver.close();
        driver.quit();
    }

    private void navigateToExternalAndPortableDiscPage(){
        externalAndPortableDiscsPage= mainpage.navigateToMainPage().getMainCategoriesMenu()
                .selectElectronicsLink()
                .getElectronicsMenu()
                .selectComputersLink()
                .getComputersMenu()
                .selectPortableDiscAndMemoriesPage()
                .getPortableDiscsAndMemoriesMenu()
                .selectExternalAndPortableDiscsLink();
    }


}
