package pl.allegro.pageObjects.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ExternalAndPortableDiscsPage;

public class PortableDiscsAndMemoriesMenu extends AbstractPageObject {
    @FindBy(xpath = "//*[text()='Dyski zewnętrzne i przenośne']")
    private WebElement externalAndPortableDiscs;

    public PortableDiscsAndMemoriesMenu(WebDriver driver) {
        super(driver);
    }

    public ExternalAndPortableDiscsPage selectExternalAndPortableDiscsLink() {
        externalAndPortableDiscs.click();
        return new ExternalAndPortableDiscsPage(getDriver());
    }
}
