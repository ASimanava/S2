package driverHolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DriverHolder {
    public WebDriver browser;

    public DriverHolder(WebDriver browser) {
        this.browser = browser;
    }

    public void onProject() {
        browser.get("https://dev.simplesystem.com/signin");
    }

    public WebElement findElementByXpath(String xpath) {
        return new WebDriverWait(browser,10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public String url;
    public String companyid;


    public void setConfig() {
        Properties prop = new Properties();
        InputStream input = null;
        String configFile = "src/test/Config.properties";
        try {
            input = new FileInputStream(configFile);
            prop.load(input);
            url = prop.getProperty("url");
            companyid = prop.getProperty("companyid");
            //TODO: peremennie
        } catch (Exception e) {

        }
    }
}
