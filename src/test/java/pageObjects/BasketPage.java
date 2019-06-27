package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasketPage extends DriverHolder {
    public BasketPage(WebDriver browser) {
        super(browser);
    }

    public BasketSecondStepPage goBasketSecondStepPage() {
        getContinueButton().click();
        return new BasketSecondStepPage(browser);
    }

    public FavouritesPage addFavourites() {
        getSaveInFavouritesListButton().click();
        return null;
    }

    public WebElement getBasketTable() {
        return browser.findElement(By.xpath("//table[@id='DataTables_Table_0']"));
    }
    public WebElement getContinueButton() {
        return browser.findElement(By.xpath("//a[@id='nextButtonId']"));
    }
    public WebElement getSaveInFavouritesListButton() { return browser.findElement(By.xpath("//button[@id='favoritesButtonId']"));    }
    public WebElement getFormFavourites() {
        return browser.findElement(By.xpath("//div[@id='favoritesModal']/div/div/div/h4[@id='favoritesModalLabel']"));
    }

    public WebElement getFavouriteName() {
        return browser.findElement(By.xpath("//form/div/div/input[@name = 'favoriteName']"));
    }

    public WebElement getCreateNewFavListButton() {
        return browser.findElement(By.xpath("//form/div/div/button[@id = 'createNewFavList']"));
    }

}
