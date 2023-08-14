package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C02_Xpath {
    public static void main(String[] args) {
        /*

        a.web sayfasına gidin. https://www.amazon.com/
b.Search(ara) “city bike”
c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);


       WebElement sonucYazisi =  driver.findElement(By.xpath("//*[text()='1-16 of 475 results for']"));
       System.out.println(sonucYazisi.getText());

        //sadece sonuc sayisini yazdirin  1-16 of 475 results for  (477)
        String [] sonucSayisi= sonucYazisi.getText().split(" ");
        System.out.println("sonuc sayisi : " +sonucSayisi[2]);

        //ilk resme tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


       driver.close();


        /*
        Xpath kullanimimni //sembolleri ile baslariz.Bu sembollerden sonra tag name belirtmemiz gerekir..
        tag name yerine * sembolunu kullanabiliriz.Bu sembol tag name farketmeksizin anlamin agelir.sonra koseli parantez acip
        kullanacagimiz attribute den once @ sembolu kullanmaliyiz.Sonrasinda da attribute yazilip tek tirnak icinde attribute in degeri
        yazilmalidir ve koseli parantez kapatilir.

        SYNTAX

        //tagname[@attributename='attribute degeri']
        //*[@*='attribute degeri'] eger bu kullanimda 1den fazla sonuc verirse * koydugumuz yerlere tag name ve attribute name i belirtmemmiz gerekir.
        buna ragmen 1den fazla sonuc verirse o webelemntin indexini asagidaki sekilde belirtiriz.
        //tagname[@attributename='attribute degeri'][index]
         */






    }
}
