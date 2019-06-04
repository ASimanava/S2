package tests;

import org.junit.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SupplierCatalogPage;

import static org.testng.Assert.assertTrue;

public class TestSearchByArticle extends TestInit {

    @Test
    public void searchByArticle() {
        LoginPage loginPage = new LoginPage(browser); // точка входа в мой pageObjects LoginPage
        DashboardPage dashboardPage = loginPage.login();
        SupplierCatalogPage supplierCatalogPage = dashboardPage.selectArticle();
        supplierCatalogPage.waitForPreloaderToDessapeare();

        assertTrue(supplierCatalogPage.getSupplierCatalogTable().isDisplayed());
        assertTrue(supplierCatalogPage.getArticles().get(0).isDisplayed());
    }
}
