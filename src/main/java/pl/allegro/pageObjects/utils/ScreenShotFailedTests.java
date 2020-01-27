package pl.allegro.pageObjects.utils;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pl.allegro.pageObjects.pages.AbstractPageObject;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
                    captureScreenShot(frameworkMethod.getName());
                    throw t;
                }
            }


    public void captureScreenShot(String fileName) throws IOException {

        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        fileName += UUID.randomUUID().toString();
        File targetFile = new File(System.getProperty("user.dir") +"\\printscreens\\"+ fileName + ".png");
        FileUtils.copyFile(scrFile, targetFile);

    }

};

    }
}
