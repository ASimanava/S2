package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import tests.TestInit;

import static org.testng.Assert.assertTrue;

public class TestSimpleOrder extends TestInit {

    @Test
    public void chooseArtikle() {
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();

        SupplierCatalogPage supplierCatalogPage = dashboardPage.goSupplierCatalogPage();
        sleep(3000);

        assertTrue(supplierCatalogPage.getSupplierCatalogTable().isDisplayed());
        supplierCatalogPage.getArticles().get(0).findElement(By.xpath("./td/button/i")).click();
        supplierCatalogPage.goBasketPage();
        BasketPage basketPage = supplierCatalogPage.goBasketPage();
        sleep(2000);

        assertTrue(basketPage.getBasketTable().isDisplayed());
        BasketSecondStepPage basketSecondStepPage = basketPage.goBasketSecondStepPage();
        sleep(2000);

        assertTrue(basketSecondStepPage.getBasketTable().isDisplayed());
        BasketThirdStepPage basketThirdStepPage = basketSecondStepPage.goBasketThirdStepPage();
        sleep(2000);

        assertTrue(basketThirdStepPage.getBasketTable().isDisplayed());
    }
}
