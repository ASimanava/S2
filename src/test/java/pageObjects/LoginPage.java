package pageObjects; //pattern. Класс обьекта страницы.

import driverHolder.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends DriverHolder {

    public LoginPage(WebDriver browser) { //constructor

        super(browser);
    }

    public WebElement getUserName() {
        return browser.findElement(By.xpath("//input[@name='username']"));
    }

    public WebElement getPassword() {
        return browser.findElement(By.xpath("//input[@id='pass']"));
    }

    public WebElement getCompanyId() {
        return browser.findElement(By.xpath("//input[@name='companyId']"));
    }

    public WebElement getLoginButton() {
        return browser.findElement(By.xpath("//button[@id='login-submit']"));
    }

    public String getUrl() {
        return browser.getCurrentUrl();
    }

    public WebElement getLoginError() {
        return browser.findElement(By.xpath("//strong[contains(text(), 'Login was invalid')]"));
    }

    public DashboardPage login() {
        onProject();

        getUserName().sendKeys("admin_tester");
        getPassword().sendKeys("12345678");
        getCompanyId().sendKeys("7701958");
        getLoginButton().click();
        return new DashboardPage(browser); //создаем новый обьект новой страницы и возвращаем новую страницу
    }

}