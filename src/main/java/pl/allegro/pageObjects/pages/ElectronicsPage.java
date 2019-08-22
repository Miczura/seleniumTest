package pl.allegro.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.components.ElectronicsMenu;

public class ElectronicsPage extends AbstractPageObject {

    private ElectronicsMenu electronicsMenu;

    public ElectronicsPage(WebDriver driver) {
        super(driver);
        this.electronicsMenu= new ElectronicsMenu(driver);
    }

    public ElectronicsMenu getElectronicsMenu() {
        return electronicsMenu;
    }

}
