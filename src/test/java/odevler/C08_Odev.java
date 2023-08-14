package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Odev {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        //4.- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        //5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualBaslik= driver.getTitle();
        String expectedBaslik="Spend less";
        if (actualBaslik.contains(expectedBaslik)){
            System.out.println("Sayfa "+expectedBaslik+ " iceriyor. TEST PASSED");

        }else {
            System.out.println("Sayfa " +expectedBaslik+ " icermiyor.TEST FAILED");
        }

        //6. Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();
        Thread.sleep(1000);

        //7. Birthday butonuna basin
        driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();
        Thread.sleep(1000);

        //8. Best Seller bolumunden ilk urunu tiklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]"));
        ilkUrun.click();
        Thread.sleep(1000);

        //9. Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//span[@id='a-autoid-28']")).click();

        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement urunFiyati= driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']"));
        System.out.println(urunFiyati.getText());
        String expected="$25.00";
        if (urunFiyati.getText().equals(expected)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //10-Sayfayi kapatin
        driver.close();

    }
}
