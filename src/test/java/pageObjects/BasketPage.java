package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends DriverHolder {
    public BasketPage(WebDriver browser) {
        super(browser);
    }

    public WebElement getBasketTable() {
        return browser.findElement(By.xpath("//table[@id='DataTables_Table_0']"));
    }
    public WebElement getContinueButton() {
        return browser.findElement(By.xpath("//a[@id='nextButtonId']"));
    }

    public BasketSecondStepPage goBasketSecondStepPage() {
        getContinueButton().click();
        return new BasketSecondStepPage(browser);
    }
}
