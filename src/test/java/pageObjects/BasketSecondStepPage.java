package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketSecondStepPage extends DriverHolder {
    public BasketSecondStepPage(WebDriver browser) { super(browser); }
    public WebElement getBasketTable() {
        return browser.findElement(By.xpath("//table[@id='DataTables_Table_0']"));
    }
    public WebElement getContinueButton() {
        return browser.findElement(By.xpath("//button[@id='nextButtonId']"));
    }
    public BasketThirdStepPage goBasketThirdStepPage() {
        getContinueButton().click();
        return new BasketThirdStepPage(browser);
    }
}
