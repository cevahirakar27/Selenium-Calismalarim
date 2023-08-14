package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(1000);

      //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.cssSelector("button[class='added-manually']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("delete butonu gorunur.TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //Delete tusuna basin.
        deleteButonu.click();


        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveElementi= driver.findElement(By.cssSelector("h3"));
        if (addRemoveElementi.isDisplayed()){
            System.out.println("passed");
        }else {
            System.out.println("test failed");
        }
        driver.close();

        /*
        CssSelector kullanmak icin ilk olarak tagname sonrasinda koseli parantez icinde attribute ve degeri yazilir.
        SYNTAX:
        tagname[attributename='attribute degeri']

      1)  Xpath ile CssSelector arasindaki fark Xpath ile bir web element icin birden fazla sonuc verirseindex ile bunu tek e dusurebiliriz.
        Fakat css ile index kullanamayiz.

       2) Xpath ile bir taga sahip web elementin text ini locate edebiliriz fakat Css ile bunu yapamayiz.
       3) CssSelektor Xpath e gore daha hizli calisir.
         */


        //ODEV: YUKARİDAKİ ADRESE GİDİP ADD ELEMET BUTONUNA 100 KERE BASİNİZ.DELETE BUTONUNA 90 KEZ BASİNİZ VE 90 KEZ BASİLDİGİNİ
        // DOGRULAYİNİZ.
    }
}
