package pl.allegro.pageObjects.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.PortableDiscsAndMemoriesPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

public class ComputersMenu extends AbstractPageObject {
    @FindBy( xpath = "//div[@data-box-name='categories container']/descendant::a[text()='Dyski i pamięci przenośne']")
    private WebElement portableDiscsAndMemoriesLink;

    public ComputersMenu(WebDriver driver) {
        super(driver);
    }

    public PortableDiscsAndMemoriesPage selectPortableDiscAndMemoriesPage(){
        WaitWrapper.waitForElement(getDriver(),10,portableDiscsAndMemoriesLink);
        portableDiscsAndMemoriesLink.click();
        return new PortableDiscsAndMemoriesPage(getDriver());
    }
}
