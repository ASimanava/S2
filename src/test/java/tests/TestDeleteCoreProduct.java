package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.CoreProductPage;
import pageObjects.DashboardPage;
import pageObjects.FavouritesPage;
import pageObjects.LoginPage;

import static org.junit.Assert.*;

public class TestDeleteCoreProduct  extends TestInit {

    //TODO: run this test after TestAddCoreProduct

    @Test
    public void deleteCoreProduct() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();
        FavouritesPage favouritesPage = dashboardPage.goFavouritesPage();
        sleep(2000);
        CoreProductPage coreProductPage = favouritesPage.goCoreProductPage();

        assertTrue(coreProductPage.getFavouriteListTable().isDisplayed());
        coreProductPage.getRemoveButton().click();

        assertTrue(coreProductPage.getFavouriteListTable().isDisplayed());
        int count = coreProductPage.getSizeArticles();
        int countNew = coreProductPage.getSizeArticles();

        assertTrue((countNew-1)==(count-1));
        System.out.println("Count before"+(count));
        System.out.println("Count after"+(countNew-1));

    }
}
