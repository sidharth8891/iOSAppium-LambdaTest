import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iOS_Test {
    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "15.5");
        capabilities.setCapability("deviceName", "Sidiphone");
        capabilities.setCapability("udid", "auto");
        capabilities.setCapability("bundleId", "<your bundle id>");
        capabilities.setCapability("xcodeOrgId", "<your org id>");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("updatedWDABundleId", "<bundle id in scope of provisioning profile>");
        capabilities.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_.IPA_FILE_COMPILED]");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void testClickAnElement() throws InterruptedException {
        //Opens the browser
        MobileElement browser = (MobileElement) driver.findElementByAccessibilityId("Browser");
        browser.click();
        Thread.sleep(3000);

        WebDriverWait el7 =  new WebDriverWait(driver, 30);
        el7.until(ExpectedConditions.elementToBeClickable(MobileBy.id("url")));
        driver.findElementById("url").sendKeys("https://www.lambdatest.com/");

        //Clicks on the text box
        WebDriverWait el = new WebDriverWait(driver,90);
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("find");
        el.until(ExpectedConditions.elementToBeClickable(el4));
        el4.click();
        el4.sendKeys("Lambdatest");

        //((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        driver.quit();

    }
}