package pageObjects;

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends DriverHolder {
    public DashboardPage(WebDriver browser) { //constructor
        super(browser);
    }

    public WebElement getTopMenu() {
        return browser.findElement(By.id("topMain"));
    }


    public WebElement getSupliersElementTopMenu() {
        return findElementByXpath("//ul[@id='topMain']/li/a[@href='#']");
    }
    public WebElement getFastOrderElementTopMenu() {
        return findElementByXpath("//ul[@id='topMain']/li/a[@href='/portal/fast-order']");
    }


    public WebElement getFavouriteElementTopMenu() {
        return browser.findElement(By.xpath("//ul[@id='topMain']/li/a[@href='/portal/favorites']"));
    }
    public WebElement getOrderStatusElementTopMenu() {
        return browser.findElement(By.xpath("//ul[@id='topMain']/li/a[@href='/portal/order-status']"));
    }

    public WebElement getClickAndOrderButton() {
        return browser.findElement(By.xpath("//a[@id='anchorScrollToPnpSuppliers']"));
    }

    public List<WebElement> getSuppliers() {    //интерфейс
        return browser.findElements(By.xpath("//div[@class='masonry-container masonry-s2 margin-top-15 masonry']/div"));
    }

    public int getSizeSuppliers() {
        return getSuppliers().size();
    }

    public WebElement getConradArticle() {
        for (WebElement element:getSuppliers()) {
            if (element.getText().equals("Conrad Electronic GmbH & Co KG")) {
                return element;
            }
        }


/*        for (int i = 0; i <=getSizeSuppliers(); i++) {
            if (getSuppliers().get(i).getAttribute("title").contains("Conrad Electronic GmbH & Co KG")) {
                return getSuppliers().get(i);
            }
        }*/
        System.out.println("Element is not found.");
        return null;
    }


    public CoreProductPage goFavoritePageMenu() {
        getFavouriteElementTopMenu().click(); //вызов на прямую
        return new CoreProductPage(browser); //после клика мы попадаем на новую страницу
    }

    public FavouritesPage goFavouritesPage() {
        getFavouriteElementTopMenu().click();
        return new FavouritesPage(browser);
    }

    public OrderStatusPage goOrderStatusPage() {
        getOrderStatusElementTopMenu().click();
        return new OrderStatusPage(browser);
    }

    public SupplierCatalogPage goSupplierCatalogPage() {

        getConradArticle().click();
        return new SupplierCatalogPage(browser);
    }

    public SupplierCatalogPage selectArticle() { //выбор элемента из чекбокса
/*        findElementByXpath("//span[@id='select2-switchHeaderSearchToggle-container']").click();
        findElementByXpath("//li[@id='select2-switchHeaderSearchToggle-result-2tgp-artNr']").click();*/
        browser.get("https://dev.simplesystem.com/catalog/filter/articleId_ta/%221001%22");
        return new SupplierCatalogPage(browser);

    }

    public WebElement getSearchField() {
        return findElementByXpath("//input[@id='allArticleNumbers']");
    }

    public SupplierCatalogPage submitSearch() {
        getSearchButton().click();
        return new SupplierCatalogPage(browser);
    }

    private WebElement getSearchButton() {
        return findElementByXpath("//button[@id='articleSearchBoxBtn1']");
    }

    public CoreProductPage goCoreProductPage() {
        getAddCoreProductButton().click();
        return new CoreProductPage(browser);
    }
    private WebElement getAddCoreProductButton() {
        return findElementByXpath("//button[@id='coreSortimentButtonId']");
    }
}
