package tests;

import org.junit.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import static org.testng.Assert.assertTrue;

public class TestDashboard extends TestInit {

    @Test
    public void checkSuppliers() {
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();

        assertTrue(dashboardPage.getSuppliers().size()>0);
        //assertTrue(dashboardPage.getSuppliers().size()==38);
        //dashboardPage.getSuppliers().get(0).click();
    }

    @Test
    public void checkMenu() {
        LoginPage loginPage = new LoginPage(browser); // точка входа в мой pageObjects LoginPage
        DashboardPage dashboardPage = loginPage.login();

        assertTrue(dashboardPage.getSupliersElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getFastOrderElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getFavouriteElementTopMenu().isDisplayed());

        assertTrue(dashboardPage.getOrderStatusElementTopMenu().isDisplayed());

        //TODO add Scanner menu is displayed
        //TODO add the checking a C&O section
        //TODO add the checking a System information
        //TODO add the checking a news section
    }

    @Test
    public void checkCAO() {
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();

        assertTrue(dashboardPage.getClickAndOrderButton().isDisplayed());
    }
}