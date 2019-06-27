package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import util.Utils;

import static org.testng.Assert.assertTrue;

public class TestAddCoreProduct extends TestInit {

    @Test
    public void addCoreProduct() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();

        SupplierCatalogPage supplierCatalogPage = dashboardPage.goSupplierCatalogPage();
        //supplierCatalogPage.waitForPreloaderToDessapeare();
        sleep(3000);

        assertTrue(supplierCatalogPage.getSupplierCatalogTable().isDisplayed());
        supplierCatalogPage.getArticles().get(0).findElement(By.xpath("./td/button/i")).click();
        supplierCatalogPage.goBasketPage();
        CoreProductPage coreProductPage = dashboardPage.goCoreProductPage();
        coreProductPage.waitForPreloaderToDessapeare();

        Utils utils = new Utils(browser);
        assertTrue(coreProductPage.getFavouriteListTable().isDisplayed());
        assertTrue(utils.getArticles().get(0).isDisplayed());
        //TODO: check that our elements in this table


    }
}
