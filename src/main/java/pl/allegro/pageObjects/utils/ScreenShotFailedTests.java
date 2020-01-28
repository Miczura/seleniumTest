package pl.allegro.pageObjects.utils;

import io.qameta.allure.Attachment;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.pages.AbstractPageObject;


public class ScreenShotFailedTests extends AbstractPageObject implements MethodRule {

    public ScreenShotFailedTests(WebDriver driver) {
        super(driver);
    }

    @Override
    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    captureScreenShot();
                    throw t;
                }
            }

            @Attachment("Screenshot on failure")
            public byte[] captureScreenShot() {
                return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            }
        };

    }
}