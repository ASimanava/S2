package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import util.Utils;

import static org.testng.Assert.assertTrue;

public class TestFavouriteList extends TestInit{

    @Test
    public void add_deleteArticleToFavouriteList() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();
        SupplierCatalogPage supplierCatalogPage = dashboardPage.goSupplierCatalogPage();
        sleep(2000);
        supplierCatalogPage.getArticles().get(0).findElement(By.xpath("./td/button/i")).click();
        supplierCatalogPage.goBasketPage();
        BasketPage basketPage = supplierCatalogPage.goBasketPage();
        sleep(2000);
        basketPage.addFavourites();
        sleep(2000);

        assertTrue(basketPage.getFormFavourites().isDisplayed());
        basketPage.getFavouriteName().sendKeys("TestList");
        basketPage.getCreateNewFavListButton().click();
        sleep(2000);
        FavouritesPage favouritesPage = dashboardPage.goFavouritesPage();
        sleep(2000);
        favouritesPage.getSelectFavList().click();
        favouritesPage.getSelectFavListType().sendKeys("TestList");
        favouritesPage.getSelectFavListType().sendKeys(Keys.ENTER);
        Utils utils = new Utils(browser);

        assertTrue(utils.getArticles().get(0).isDisplayed());
        int count = utils.getSizeArticles();

        utils.getRemoveButton().click();
        int countNew = utils.getSizeArticles();

        Assert.assertTrue((countNew-1)==(count-1));
        System.out.println("Count before"+(count));
        System.out.println("Count after"+(countNew-1));
    }



}
