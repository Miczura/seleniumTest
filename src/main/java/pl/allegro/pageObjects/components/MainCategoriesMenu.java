package pl.allegro.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ElectronicsPage;

public class MainCategoriesMenu extends AbstractPageObject {

    @FindBy(xpath = "//div[@data-group-id='departments_Elektronika']")
    private WebElement electronics;

    public MainCategoriesMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to electronics page")
    public ElectronicsPage selectElectronicsLink(){
        electronics.click();
        return new ElectronicsPage(getDriver());
    }

}
