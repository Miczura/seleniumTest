package pl.allegro.pageObjects.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ComputersPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

public class ElectronicsMenu extends AbstractPageObject {
    //@FindBy(xpath = "//div[@data-box-name='category - Elektronika']/descendant::a[text()='Komputery']")
    //@FindBy(xpath = "//a[@title='Komputery stacjonarne']")
    @FindBy(xpath="//div[@data-box-name='Komputery i tablety stara']/descendant::a[@title='Komputery stacjonarne'][2]")
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
