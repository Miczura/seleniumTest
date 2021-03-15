package pl.allegro.pageObjects.components;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.pages.PortableDiscsAndMemoriesPage;
import pl.allegro.pageObjects.utils.WaitWrapper;

import java.util.ArrayList;

public class ComputersMenu extends AbstractPageObject {
    //@FindBy( xpath = "//div[@data-box-name='categories container']/descendant::a[text()=' Dyski i pamięci przenośne ']")
    @FindBy( css = "[data-role='Categories'] a[href*='dyski-i-pamieci-przenosne']")
    private WebElement portableDiscsAndMemoriesLink;

    public ComputersMenu(WebDriver driver) {
        super(driver);
    }
    @Step("Navigate to select portable discs and memories page")
    public PortableDiscsAndMemoriesPage selectPortableDiscAndMemoriesPage(){
        changeTab();
        WaitWrapper.waitForElement(getDriver(),10,portableDiscsAndMemoriesLink);
        portableDiscsAndMemoriesLink.click();


        return new PortableDiscsAndMemoriesPage(getDriver());
    }
    private void changeTab(){
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(0));
        getDriver().close();
        getDriver().switchTo().window(tabs2.get(1));
    }
}
