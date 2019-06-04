package testsExamples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.TestInit;

public class TestSelectExample extends TestInit {

    @Test
    public void selectTest(){
        browser.get("http://htmlbook.ru/html/select");
        new Select(browser.findElement(By.xpath("//select[@name='select2']"))).selectByIndex(1);
        sleep(3000);

    }
}
