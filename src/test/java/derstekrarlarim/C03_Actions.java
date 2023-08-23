package derstekrarlarim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    //https://the-internet.herokuapp.com/context_menu sitesine gidin
    //Kutuya sag tıklayın
    //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    //Tamam diyerek alert’i kapatın


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın.
            //once locate alalim.
        WebElement kutu = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(kutu).perform();
        bekle(1);

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualYazi = driver.switchTo().alert().getText();
        String expected ="You selected a context menu";
        Assert.assertEquals(actualYazi,expected);
        bekle(1);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
        bekle(1);



    }
}
