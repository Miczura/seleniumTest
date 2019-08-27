package pl.allegro.disks;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.allegro.pageObjects.pages.ExternalAndPortableDiscsPage;
import pl.allegro.pageObjects.pages.MainPage;


public class DiskFilteringAndSortingTest {
    private static WebDriver driver;
    private ExternalAndPortableDiscsPage externalAndPortableDiscsPage;
    MainPage mainpage = new MainPage(driver);

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Before
    public void navigateToExternalAndPortableDiscs()  {
        //given
        navigateToExternalAndPortableDiscPage();
    }

    @Test
    public void testIfProductsOnExternalAndPortableDiscsPageAreSortedWithExpectedFiltering()  {
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
