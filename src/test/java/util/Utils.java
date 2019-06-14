package util;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartUtils extends DriverHolder {
    public ShoppingCartUtils(WebDriver browser) {
        super(browser);
    }

    /*public WebElement getBasket() {
        return browser.findElement(By.xpath("//a[@id='icon-shopping-cart-place']"));
    }*/

    public WebElement getShoppingCartIcon() { return findElementByXpath("//a[@id='icon-shopping-cart-place']");    }

    public void goShoppingCartPage() {
        getShoppingCartIcon().click();
    }
    public WebElement getShoppingCartDisplay() {
        return browser.findElement(By.xpath("//h3[contains(text(), 'Shopping cart')]"));
    }
}
