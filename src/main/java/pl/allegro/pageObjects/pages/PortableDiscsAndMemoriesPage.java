package pl.allegro.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.components.PortableDiscsAndMemoriesMenu;

public class PortableDiscsAndMemoriesPage extends AbstractPageObject {

    private PortableDiscsAndMemoriesMenu portableDiscsAndMemoriesMenu;

    public PortableDiscsAndMemoriesPage(WebDriver driver) {
        super(driver);
        this.portableDiscsAndMemoriesMenu= new PortableDiscsAndMemoriesMenu(driver);
    }

    public PortableDiscsAndMemoriesMenu getPortableDiscsAndMemoriesMenu() {
        return portableDiscsAndMemoriesMenu;
    }
}
