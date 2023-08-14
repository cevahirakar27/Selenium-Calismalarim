package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_Odev {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1-C01_TekrarTesti isimli bir class
        //olusturun 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        Thread.sleep(1000);

        // 3- cookies uyarisini kabul ederek kapatin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='callout']"));
        driver.switchTo().frame(iframe);

        WebElement oturum =   driver.findElement(By.xpath("//*[text()='Oturum açma']"));
        oturum.click();
        Thread.sleep(1000);

        //4. Sayfa basliginin “Google” ifadesi icerdigini test
        //edin
        String actualBaslik=driver.getTitle();
        String expectedBaslik= "Google";
        if (actualBaslik.contains(expectedBaslik)){
            System.out.println("SAYFA " +expectedBaslik +" İCERIYOR");
        }else {
            System.out.println("TEST FAILED");
        }


        //5. Arama cubuguna “Nutella” yazip aratin
        driver.switchTo().defaultContent();
       WebElement aramakUTUSU = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramakUTUSU.sendKeys("Nutella" +Keys.ENTER);
        Thread.sleep(1000);

        //6. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi= driver.findElement(By.xpath("//*[text()='Yaklaşık 255.000.000 sonuç bulundu']"));
        System.out.println(sonucSayisi.getText());
        String sayi[]=sonucSayisi.getText().split(" ");
        String sonuc=sayi[1];
        System.out.println(sayi[1]);  //255000000



        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin.





        //8. Sayfayi kapatin
        driver.close();
    }
}
