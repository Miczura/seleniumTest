package pl.allegro.pageObjects.components;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pl.allegro.pageObjects.pages.AbstractPageObject;
import pl.allegro.pageObjects.utils.WaitWrapper;

import java.util.List;
import java.util.stream.Collectors;

public class ExternalAndPortableDiscsMenu extends AbstractPageObject {
    @FindBy(xpath = "//input[@id='pojemnosc-dysku-od']")
    private WebElement fromCapacityFilter;
    @FindBy(xpath = "//input[@id='pojemnosc-dysku-do']")
    private WebElement toCapacityFilter;
    @FindBy(xpath = "//select[@data-value='m']")
    private WebElement select;
    @FindBy(xpath = "//section[descendant::h2[text()='Oferty']]//span[@class='fee8042']")
    private WebElement listOfProducts;
    @FindBy(xpath = "//div[@data-box-name='chipsAboveFilters']/descendant::div[text()='do 300 GB']")
    private WebElement filterVelue;

    public ExternalAndPortableDiscsMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Select filter for disc capacity from {0} to {1} Gb")
    public ExternalAndPortableDiscsMenu setupfilteringDiscCapacity(String minCapacity,String maxCapacity){
        WaitWrapper.waitForElement(getDriver(),5,fromCapacityFilter);
        fromCapacityFilter.clear();
        fromCapacityFilter.sendKeys(minCapacity);
        toCapacityFilter.clear();

        toCapacityFilter.sendKeys(maxCapacity);
        toCapacityFilter.click();
        WaitWrapper.waitForElement(getDriver(),3,filterVelue);
        return this;
    }

    @Step("Select sorting method from most expensive descendant")
    public ExternalAndPortableDiscsMenu selectSortingMethod(){
        Select statusDropdown=new Select(select);
        statusDropdown.getOptions().get(2).click();
        return this;

    }
    @Step("Get result list of prices")
    public List<Double> getListOfPrices() {
        getDriver().navigate().refresh();
        int count = 5;
        while (true) {
            System.out.println(count);
            count--;
            try {
                List<WebElement> listOfWebElements = listOfProducts.
                        findElements(By.xpath("//section[descendant::h2[text()='Lista ofert']]//span[@class='fee8042']"));
                List<String> listOfStringsPrises = listOfWebElements.
                        stream().
                        map(webElement -> webElement.getText().replaceAll("zł", "").replaceAll(",", ".").trim()).
                        collect(Collectors.toList());
                return listOfStringsPrises.
                        stream().
                        map(stringElement -> Double.parseDouble(stringElement.replaceAll(" ", ""))).
                        collect(Collectors.toList());

            } catch (StaleElementReferenceException e) {
                if(count==0){
                    throw e;
                }
            }

        }

    }
    @Step("Check if prices are sorted")
    public void checkIfPricesAreSorted(List<Double> list){
        double element=Double.POSITIVE_INFINITY;
        for(Double e:list){
            if(element>=e) {
                element=e;
            } else if(element<e){
                Assert.fail("List is not sorted descendant: Price: "+element+" is smaller than next price : "+e);
            }
        }

    }

}

