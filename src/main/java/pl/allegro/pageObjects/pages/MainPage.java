package pl.allegro.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.components.MainCategoriesMenu;
import pl.allegro.pageObjects.utils.Url;

public class MainPage extends AbstractPageObject {
    private MainCategoriesMenu mainCategoriesMenu;

    public MainPage(WebDriver driver){
        super(driver);
        this.mainCategoriesMenu=new MainCategoriesMenu(driver);
    }
    public MainPage navigateToMainPage(){
        getDriver().manage().window().maximize();
        getDriver().get(Url.allegroAddress);
        return this;
    }
}
