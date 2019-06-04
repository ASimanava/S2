package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class TestInit {
    public WebDriver browser;

    @Before
    public void setUpFireFox() {
        System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver_win.exe");
        browser = new FirefoxDriver();

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Явное ожидание. Ждет пояаление эл-та

    }


/*    @Before
    public void setUpChrome() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver_win.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Явное ожидание. Ждет пояаление эл-та
    }*/

    @After
    public void tierDown() {
        browser.quit();
    }

    public void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
