package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsTest extends TestBase {

    @Test
    public void test01() {

        //Google anasayfasına gidelim.
        driver.get("https://www.google.com");

       //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım.
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#APjFqb"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramaKutusu,Keys.SHIFT).  // arama kutusunda shift tusuna basili tutar.
                sendKeys("selenium"). //selenium yazdirir

                keyUp(Keys.SHIFT).// shift tusundan elini cek.
                sendKeys("-java",Keys.ENTER).perform();

    }

    //hic action kullanmadan yapalim.

    @Test
    public void test02() {
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım.
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#APjFqb"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
      /*
      yukaridaki ornekte action classi kulanmadan da istedigim yaziyi buyuk kucuk harf ile yazdirabilirim.ilk yazdigimiz
       Keys.Shift shift tusuna basili tutar buyuk harf ile yazar.ikinci yazdigimiz Keys.SHİFT İSE shift tusunu serbest birakir.
       klavye tuslarini pratik olarak yukaridaki ornekteki gibi kullanabilirsiniz.
       */
    }

    //ODEV
     /*
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         */
}
