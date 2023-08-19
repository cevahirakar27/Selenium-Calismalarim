package derstekrarlarim;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Iframe extends TestBase {


    @Test
    public void test01() {

        driver.get("https://html.com/tags/iframe/");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

    }
}
