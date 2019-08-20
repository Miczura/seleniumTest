package pl.allegro.pageObjects.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;

public class MainCategoriesMenu extends AbstractPageObject {

    @FindBy(xpath = "//a[@data-analytics-click-value='Elektronika']")
    private WebElement electronics;

    public MainCategoriesMenu(WebDriver driver) {
        super(driver);
    }

}
