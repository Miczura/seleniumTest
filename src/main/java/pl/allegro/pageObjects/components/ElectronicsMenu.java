package pl.allegro.pageObjects.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ComputersPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

public class ElectronicsMenu extends AbstractPageObject {
    @FindBy(xpath = "//div[@data-box-name='Podkategorie w Komputery i tablety']/descendant::a[@title='Komputery stacjonarne']")
    private WebElement computers;

    public ElectronicsMenu(WebDriver driver) {
        super(driver);
    }

    public ComputersPage selectComputersLink(){
        WaitWrapper.waitForElement(getDriver(),10,computers);
        computers.click();
        return new ComputersPage(getDriver());
    }
}
