package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import static org.testng.Assert.assertTrue;

public class TestLogin extends TestInit {

    @Test
    public void LoginCorrect() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        DashboardPage dashboardPage = loginPage.login();

        assertTrue(loginPage.getUrl().equals("https://www.test.s2/dashboard"));
    }

    @Test
    public void LoginIncorrect() {
        WebDriver browser = getBrowser();
        LoginPage loginPage = new LoginPage(browser);
        loginPage.onProject();
        loginPage.getUserName().sendKeys("S2");
        loginPage.getPassword().sendKeys("S2S2S2");
        loginPage.getCompanyId().sendKeys("7701958");
        loginPage.getLoginButton().click();

        assertTrue(loginPage.getLoginError().isDisplayed());
    }
}
