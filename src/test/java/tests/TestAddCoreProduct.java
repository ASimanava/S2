package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;

import static org.testng.Assert.assertTrue;

public class TestAddCoreProduct extends TestInit {

    @Test
    public void addCoreProduct() {
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

        assertTrue(coreProductPage.getFavouriteListTable().isDisplayed());
        assertTrue(coreProductPage.getArticles().get(0).isDisplayed());
        //TODO: check that our elements in this table


    }
}
