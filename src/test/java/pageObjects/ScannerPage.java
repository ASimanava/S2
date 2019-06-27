package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScannerPage extends DriverHolder {
    public ScannerPage(WebDriver browser) {
        super(browser);
    }

    public WebElement getScannerDisplay() {
        return browser.findElement(By.xpath("//h3[contains(text(), 'Scanner - simple system')]"));
    }
}
