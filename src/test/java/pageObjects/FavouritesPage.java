package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FavouritesPage extends DriverHolder {
    public FavouritesPage(WebDriver browser) { super(browser); }

    public CoreProductPage goCoreProductPage() {
        getCoreProductDisplayLink().click();
        return new CoreProductPage(browser);
    }

    private WebElement getCoreProductDisplayLink() {
        return browser.findElement(By.xpath("//button[@class='btn btn-default btn-link noborder nomargin']"));
    }

    public WebElement getFavouritesDisplay() {
        return browser.findElement(By.xpath("//h3[contains(text(), 'Favourites - simple system')]"));
    }

    public WebElement getSelectFavList() {
        return browser.findElement(By.xpath("//span[@id='select2-favoriteLists-container']"));
    }

    public WebElement getSelectFavListType() {
        return browser.findElement(By.xpath("//span/input[@class='select2-search__field']"));
    }

}
