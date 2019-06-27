package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FastOrderPage extends DriverHolder {
    public FastOrderPage(WebDriver browser) {
        super(browser);
    }

    public WebElement getFastOrderDisplay() {
        return browser.findElement(By.xpath("//h3[contains(text(),'Fast order - simple system')]"));
    }



}
