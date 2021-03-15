package pl.allegro.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.ExternalAndPortableDiscsPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

public class PortableDiscsAndMemoriesMenu extends AbstractPageObject {
    //@FindBy(xpath = "//div[@data-box-name='categories container']/descendant::a[text()=' Dyski zewnętrzne i przenośne ']")
    @FindBy(css = "[data-role='Categories'] a[href*='dyski-zewnetrzne-i-przenosne']")
    private WebElement externalAndPortableDiscs;

    public PortableDiscsAndMemoriesMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to external and portable discs page")
    public ExternalAndPortableDiscsPage selectExternalAndPortableDiscsLink() {
        WaitWrapper.waitForElement(getDriver(),5,externalAndPortableDiscs);
        externalAndPortableDiscs.click();
        return new ExternalAndPortableDiscsPage(getDriver());
    }
}
