package pl.allegro.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ComputersPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

public class ElectronicsMenu extends AbstractPageObject {
    //constatly changing page....
    //@FindBy(xpath = "//div[@data-box-name='category - Elektronika']/descendant::a[text()='Komputery']")
    //@FindBy(xpath = "//a[@title='Komputery stacjonarne']")
    //@FindBy(xpath="//div[@data-box-name='Komputery i tablety stara']/descendant::a[@title='Komputery stacjonarne'][2]")
    @FindBy(xpath="//div[@data-box-name='category - Elektronika']/descendant::a[@href='/kategoria/komputery']")

    private WebElement computers;

    public ElectronicsMenu(WebDriver driver) {
        super(driver);
    }
    @Step("Navigate to computers page")
    public ComputersPage selectComputersLink(){
        WaitWrapper.waitForElement(getDriver(),10,computers);
        computers.click();
        return new ComputersPage(getDriver());
    }
}
