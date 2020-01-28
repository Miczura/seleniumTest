package pl.allegro.disks;

import io.github.bonigarcia.wdm.WebDriverManager;


import io.qameta.allure.Description;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();

    }
//    @Before
//    public void navigateToExternalAndPortableDiscs()  {
//        //given
//
//    }

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

    @Test
    @Description("Navigate from allegro.pl to portable disc and memories page, with wrong " +
            "locator and take screenshot for broken test")
    public void thisOneWillBeBroken(){
        navigateToExternalAndPortableDiscPageAndFailDuringThisOperation();

    }


    @Test
    @Description("Navigate from allegro.pl to portable disc and memories page " +
            "fail on dummy assertion and take a screenshot")
    public void thisOneWillFail(){
        navigateToExternalAndPortableDiscPage();
        Assert.assertTrue(1>2);
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
    private void navigateToExternalAndPortableDiscPageAndFailDuringThisOperation(){
        externalAndPortableDiscsPage= mainpage.navigateToMainPage().getMainCategoriesMenu()
                .selectElectronicsLink()
                .getElectronicsMenu()
                .selectComputersLinkAndFail()
                .getComputersMenu()
                .selectPortableDiscAndMemoriesPage()
                .getPortableDiscsAndMemoriesMenu()
                .selectExternalAndPortableDiscsLink();
    }

}
