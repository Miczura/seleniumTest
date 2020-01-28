package pl.allegro.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.components.MainCategoriesMenu;
import pl.allegro.pageObjects.utils.CookieWrapper;
import pl.allegro.pageObjects.utils.Url;

public class MainPage extends AbstractPageObject {
    private MainCategoriesMenu mainCategoriesMenu;

    public MainPage(WebDriver driver){
        super(driver);
        this.mainCategoriesMenu=new MainCategoriesMenu(driver);
    }
    @Step("Navigate to allegro.pl")
    public MainPage navigateToMainPage(){
        getDriver().manage().window().maximize();
        getDriver().get(Url.allegroAddress);
        CookieWrapper.addCookie(getDriver(),"gdpr_permission_given","1",".allegro.pl","/");
        getDriver().get(Url.allegroAddress);
        return this;
    }

    public MainCategoriesMenu getMainCategoriesMenu() {
        return mainCategoriesMenu;
    }
}

