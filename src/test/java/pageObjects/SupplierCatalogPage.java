package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SupplierCatalogPage extends DriverHolder {

    public SupplierCatalogPage(WebDriver browser) {super(browser);}   //super why?

    public WebElement getSupplierCatalogTable() {
        return browser.findElement(By.xpath("//table[@id='DataTables_Table_0']"));
    }

    public List<WebElement> getArticles() {
        return browser.findElements(By.xpath("//tbody[@id='items']/tr"));
    }

    public WebElement getBasket() {

        return browser.findElement(By.xpath("//a[@id='icon-shopping-cart-place']"));
    }
    public BasketPage goBasketPage() {
        getBasket().click();
        return new BasketPage(browser);
    }

    public void waitForPreloaderToDessapeare() {
        //findElementByXpath("//div[@class='panel-body']//i[@class='icon-spinner icon-spin icon-2x']").isDisplayed();
        /*for (int i=0; i<=20; i++) { //пол секунды
            if (browser.findElement(By.xpath("//div[@class='panel-body']//i[@class='icon-spinner icon-spin icon-2x']")).isDisplayed()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }*/
        new WebDriverWait(browser, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='DataTables_Table_0']")));
    }

}
