package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_WindowHandles extends TestBase {

    //  https://the-internet.herokuapp.com/windows adresine gidin.
//  ilk sayfasının Handle degerini alın yazdırın
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
//  "Click Here" butonuna tıklayın.
//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
//  ikinci sayfaya tekrar geçin.
//  ilk sayfaya tekrar dönün.

    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

       //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();

      //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

      //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

      //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        bekle(1);
        Set<String> pencereler = driver.getWindowHandles();
        for (String w: pencereler){
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
            }
        }

      //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String ikinciSayfaHandle = driver.getWindowHandle();
        Assert.assertEquals("New Window",driver.getTitle());


      //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        bekle(2);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

      //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);

      //  ilk sayfaya tekrar dönün.
         driver.switchTo().window(ilkSayfaHandle);
          }


    @Test
    public void test02() {


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
       List<String> pencereler =  new ArrayList<>(driver.getWindowHandles());


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(pencereler.get(1));
        Assert.assertEquals("New Window",driver.getTitle());


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        bekle(2);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));

    }

    @Test
    public void test03() {


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();



        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals("New Window",driver.getTitle());


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

    }

    @Test
    public void test04() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();



        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        window(1);
        Assert.assertEquals("New Window",driver.getTitle());


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        window(0);
        bekle(2);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        window(1);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
       window(0);

    }
}
