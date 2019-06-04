package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavouritesPage extends DriverHolder {
    public FavouritesPage(WebDriver browser) { super(browser); }

    public CoreProductPage goCoreProductPage() {
        getCoreProductDisplayLink().click();
        return new CoreProductPage(browser);
    }

    private WebElement getCoreProductDisplayLink() {
        return browser.findElement(By.xpath("//button[@class='btn btn-default btn-link noborder nomargin']"));
    }
}
