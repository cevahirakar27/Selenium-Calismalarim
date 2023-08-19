package odevlerJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C17_IframeOdev extends TestBase {

        //1-https://the-internet.herokuapp.com/windows sayfasına gidiniz.
       // 2-Elemental Selenium linkine tıklayıp Sayfa başlığının Elemental Selenium içerdiğini test edin.


    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");


        // 2-Elemental Selenium linkine tıklayıp Sayfa başlığının Elemental Selenium içerdiğini test edin.
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

       // List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualBaslik = driver.getTitle();
        Assert.assertTrue(actualBaslik.contains("Elemental Selenium"));



    }
}
