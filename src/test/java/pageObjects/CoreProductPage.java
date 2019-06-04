package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CoreProductPage extends DriverHolder {
    public CoreProductPage(WebDriver browser) {
        super(browser);
    }

    public WebElement getFavouriteListTable() {
        return browser.findElement(By.xpath("//table[@id='favoriteListDetailsTable']"));
    }

    public List<WebElement> getArticles() {
        return browser.findElements(By.xpath("//tbody/tr/td/button[@type='button']"));
    }

    public int getSizeArticles() {
        return getArticles().size();
    }

    public WebElement getRemoveButton() {
        return getArticles().get(0);
    }

    public void waitForPreloaderToDessapeare() {
        new WebDriverWait(browser, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='favoriteListDetailsTable']")));

    }
}
