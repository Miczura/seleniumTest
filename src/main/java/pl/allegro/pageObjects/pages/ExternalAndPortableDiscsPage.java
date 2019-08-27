package pl.allegro.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.components.ExternalAndPortableDiscsMenu;

public class ExternalAndPortableDiscsPage extends AbstractPageObject{

    private ExternalAndPortableDiscsMenu externalAndPortableDiscsMenu;

    public ExternalAndPortableDiscsPage(WebDriver driver) {
        super(driver);
        this.externalAndPortableDiscsMenu =new ExternalAndPortableDiscsMenu(driver);
    }

    public ExternalAndPortableDiscsMenu getExternalAndPortableDiscsMenu() {
        return externalAndPortableDiscsMenu;
    }
}
