package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import util.Utils;

import static org.testng.Assert.assertTrue;

public class TestDashboard extends TestInit {

    @Test
    public void checkMenu() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser); // точка входа в мой pageObjects LoginPage
        DashboardPage dashboardPage = loginPage.login();

        assertTrue(dashboardPage.getSupliersElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getFastOrderElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getFavouriteElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getOrderStatusElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getScannerElementTopMenu().isDisplayed());

        //assertTrue(dashboardPage.getClickAndOrderButton().isDisplayed());

        assertTrue(dashboardPage.getSystemInformationSection().isDisplayed());

        assertTrue(dashboardPage.getNewsSection().isDisplayed());
    }

    @Test
    public void checkCAO() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login(); //Я ДОЛЖНА ЭТО ПОВТОРЯТЬ КАЖДЫЙ РАЗ?

        assertTrue(dashboardPage.getClickAndOrderButton().isDisplayed());
    }

    @Test
    public void checkSuppliers() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();

        assertTrue(dashboardPage.getSuppliers().size()>0);
        //assertTrue(dashboardPage.getSuppliers().size()==38);
        //dashboardPage.getSuppliers().get(0).click();
    }

    @Test
    public void checkFastOrder() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser); // точка входа в мой pageObjects LoginPage
        DashboardPage dashboardPage = loginPage.login();
        dashboardPage.getFastOrderElementTopMenu().click();
        FastOrderPage fastOrderPage = dashboardPage.goFastOrderPage();
        sleep(3000);

        assertTrue(fastOrderPage.getFastOrderDisplay().isDisplayed());

    }

    @Test
    public void checkFavourites() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();
        dashboardPage.getFavouriteElementTopMenu().click();
        FavouritesPage favouritesPage = dashboardPage.goFavouritesPage();
        sleep(3000);

        assertTrue(favouritesPage.getFavouritesDisplay().isDisplayed());
    }

    @Test
    public void checkOrderStatus() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();
        dashboardPage.getOrderStatusElementTopMenu().click();
        OrderStatusPage orderStatusPage = dashboardPage.goOrderStatusPage();
        sleep(3000);

        assertTrue(orderStatusPage.getOrdersTab().isDisplayed());
    }

    @Test
    public void checkScanner() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();
        dashboardPage.getScannerElementTopMenu().click();
        ScannerPage scannerPage = dashboardPage.goScannerPage();
        sleep(3000);

        assertTrue(scannerPage.getScannerDisplay().isDisplayed());
    }

    @Test
    public void checkShoppingCart() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login();
        Utils shoppingCartUtils = new Utils(browser);
        shoppingCartUtils.getShoppingCartIcon().click();
        shoppingCartUtils.goShoppingCartPage();
        sleep(3000);

        assertTrue(shoppingCartUtils.getShoppingCartDisplay().isDisplayed());
    }
}