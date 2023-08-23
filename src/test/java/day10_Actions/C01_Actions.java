package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    //https://the-internet.herokuapp.com/context_menu sitesine gidin
    //Kutuya sag tıklayın
    //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    //Tamam diyerek alert’i kapatın


    @Test
    public void actions() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin.
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).perform();  // locate ettitgimiz web elemente sag click yapar.
        bekle(2);
        //Kullandığımız action'ı işleme alması için perform() methodu kullanmamız gerekiyor



        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",actualAlertYazi);
        //methodu ile alert üzerindeki mesajı aldık ve doğrulama yaptık

        //Tamam diyerek alert’i kapatın.
        driver.switchTo().alert().accept();


    }
}
