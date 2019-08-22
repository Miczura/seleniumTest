package pl.allegro.pageObjects.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ComputersPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

public class ElectronicsMenu extends AbstractPageObject {
    @FindBy(xpath = "//div[@data-box-name='Nagłówek kategorii Komputery i tablety']/descendant::a[2]")
    private WebElement computers;

    public ElectronicsMenu(WebDriver driver) {
        super(driver);
    }

    public ComputersPage selectComputersPage(){
        computers.click();
        return new ComputersPage(getDriver());
    }
}
