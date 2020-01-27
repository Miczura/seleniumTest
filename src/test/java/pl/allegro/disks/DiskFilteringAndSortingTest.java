package pl.allegro.disks;

import io.github.bonigarcia.wdm.WebDriverManager;


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
    public void thisOneWillFail(){
        navigateToExternalAndPortableDiscPageAndFailDuringThisOperation();
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
