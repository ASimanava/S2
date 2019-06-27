package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestInit {
    protected static ThreadLocal<RemoteWebDriver> browser = new ThreadLocal();

/*    @Before
    public void setUpFireFox() {
        System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver_win.exe");
        browser = new FirefoxDriver();

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Явное ожидание. Ждет пояаление эл-та

    }*/


/*    @Before //в один поток
    public void setUpChrome() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver_win.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Явное ожидание. Ждет пояаление эл-та
    }*/

    @Before //для потоков
    @Parameters(value = {"browser"})
    public void setUpChrome(String browser) {
/*        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver_win.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String url = "http://localhost:4444/wd/hub";

        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            profile.setPreference("network.proxy.type", 0);
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
            capabilities.setCapability("browserName", browser);
            try {
                this.browser.set(new RemoteWebDriver(new URL(url), capabilities));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            String osName = System.getProperty("os.name");
            if (osName.contains("Win") || osName.contains("Lin")) {
                options.addArguments("start-maximized");
            }

//            else {
//                options.addArguments("--kiosk");
//            }
            options.setCapability(ChromeOptions.CAPABILITY, options);
            try {
                this.browser.set(new RemoteWebDriver(new URL(url), options));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            getBrowser().manage().window();

        }
    }

    public WebDriver getBrowser() {
        return browser.get();
    }

    @After
    public void tierDown() {
        getBrowser().quit();
    }

    public void sleep ( int msec){
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
