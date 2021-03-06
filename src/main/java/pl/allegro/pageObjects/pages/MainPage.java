package pl.allegro.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.components.MainCategoriesMenu;
import pl.allegro.pageObjects.utils.CookieWrapper;
import pl.allegro.pageObjects.utils.Url;

public class MainPage extends AbstractPageObject {
    private MainCategoriesMenu mainCategoriesMenu;

    @FindBy(xpath = "//div[@id='dialog-content']")
    WebElement consent;
    @FindBy(xpath = "//button[text()='przejdź dalej']")
    WebElement button;

    public MainPage(WebDriver driver){
        super(driver);
        this.mainCategoriesMenu=new MainCategoriesMenu(driver);
    }
    @Step("Navigate to allegro.pl")
    public MainPage navigateToMainPage(){
        getDriver().manage().window().maximize();
        getDriver().get(Url.allegroAddress);
        CookieWrapper.setupConsentManual(getDriver(),consent,button);
        return this;
    }

    public MainCategoriesMenu getMainCategoriesMenu() {
        return mainCategoriesMenu;
    }
}

