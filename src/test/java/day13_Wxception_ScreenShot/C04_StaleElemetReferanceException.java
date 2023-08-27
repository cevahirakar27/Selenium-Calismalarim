package day13_Wxception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElemetReferanceException extends TestBase {

    @Test
    public void test01() {
        /*
        STALEELEMENTREFERANCEEXCEPTION:
        Bir web elemnti locate eetikten sonra sayfada navigate() refresh() ya da forward() back() islemi yaptiysaniz ve tekrar locate ni aldiginiz
        web elementi kullanmak isterseniz bu hatayi alirsiniz.cunku sayfa yenileme sayfada ileri geri yapma isleminden sonra driver
        locateni aldigimiz elementi eskimis(BAYATLAMIS) olarak gorur ve bu hatayi handle etmek icin o elementi tekrar locate etmeniz gerekir.

         List<WebElement> linkler = driver.findElements(By.xpath "sjdnn ")
         yukararidaki linklerin oldugu listeyi bir loop icinde hepsine click yapicaz.
         for(i=0,i<linler.size; i++){
         linkler.get(i).click
         driver.navigate.back
         linkler =driver.findElements(By.xpath "sjdnn ")  --> eger tekrar liste atama yapmazsak  ayni sekilde listin icindeki elementleri eskimis
         kabul edip  STALEELEMENTREFERANCEEXCEPTION firlatacak.
         Dolayisyla loop icinde liste tekrar elementlerin atamasini yaparsak bu exception i handle etmis oluruz.


         }
         */

        driver.get("https://techproeducation.com");
      //Events e tiklayalim back yapip tekrar Events e tiklayalim.

        WebElement events = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        events.click();
        bekle(2);

        driver.navigate().back();
        bekle(2);
        events.click();    //  StaleElementReferenceException


    }

    @Test
    public void tets02() {
        driver.get("https://www.amazon.com");

        //arama kutunda iphone aratalim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        bekle(1);

        //Back ile ana sayfaya donelim.
        driver.navigate().back();


        //tekrar arama kutusunda samsung aratalim.
        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung",Keys.ENTER);  // StaleElementReferenceException cunku elementte bayatlama oldu


    }
}
