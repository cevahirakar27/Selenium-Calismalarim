package day02_DriverMethods;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class C02_DriverMethodlari {
    public static void main(String[] args) {

        /*

       getWindowHandle() methodu ile kendimiz isteyerek baska bir pencereye gecis yaptigimizda iki
tane pencere acmis olucaz. Dolayisiyla ilk actigimiz pencereye tekrar gecis yapmak istedigimizde
ilk actigimiz pencereden sonra almis oldugumuz window handle degeri ile gecis yapabibliriz.
Pencereler arasi gecis konusunda bunu detayli görecegiz.Birde bir sayfaya gittigimizde bir linke tikladigimizda bizim kontrolümüz
 disinda yeni bir pencere acilabilir. Bu gibi durumlarda da getWindowHandles() methodu ile driver in acmis
 oldugu pencerelerin handle degerlerini bir list e assign ederiz ve istedigimiz pencereye index ile
 cok rahat gecis yapabiliriz


         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       // 1.Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://techproeducation.com");

        //2.Sayfa basligini(title) yazdirin
        String actualTitle= driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //3.Sayfa basliginin “TechPro” icerdigini test edin
        String expected = "TechPro";
        if (actualTitle.contains(expected)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //4.Sayfa adresini(url) yazdirin
        String actualUrl= driver.getCurrentUrl();

        //5.Sayfa url’inin “techpro” icerdigini test edin.
        if (actualUrl.contains("techpro")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


      //  6.Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle()); //7218DB0E1F639CD550C1A0163AE4FDCF her seferinde farkli cikar.



      //  7.Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String sayfaKaynakKodlari= driver.getPageSource();
      //  System.out.println("sayfaKaynakKodlari = " + sayfaKaynakKodlari);

        if (sayfaKaynakKodlari.contains("text")){
            System.out.println("İCERİYOR");
        }else {
            System.out.println("İCERMİYOR");
        }



       // 8.Sayfayi kapatin.
        driver.close();






    }
}
