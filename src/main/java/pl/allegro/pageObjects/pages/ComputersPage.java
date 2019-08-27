package pl.allegro.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.components.ComputersMenu;

public class ComputersPage extends AbstractPageObject {

    private ComputersMenu computersMenu;

    public ComputersPage(WebDriver driver) {
        super(driver);
        this.computersMenu=new ComputersMenu(driver);
    }

    public ComputersMenu getComputersMenu() {
        return computersMenu;
    }

}
