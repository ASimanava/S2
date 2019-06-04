package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderStatusPage extends DriverHolder {
    public OrderStatusPage(WebDriver browser) {
        super(browser);
    }

    public WebElement getOrdersTab() {
        return browser.findElement(By.xpath("//li[@class='filter active']"));
    }
}
