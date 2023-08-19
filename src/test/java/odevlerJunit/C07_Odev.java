package odevlerJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_Odev {
    public static void main(String[] args) {

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //ODEV: YUKARİDAKİ ADRESE GİDİP ADD ELEMET BUTONUNA 100 KERE BASİNİZ.DELETE BUTONUNA 90 KEZ BASİNİZ VE 90 KEZ BASİLDİGİNİ
        // DOGRULAYİNİZ.

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButonu = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {
            addButonu.click();
        }

        //DELETE BUTONUNA 90 KEZ BASİNİZ VE 90 KEZ BASİLDİGİNİ
        // DOGRULAYİNİZ.

WebElement deletButonu;
        int sayac=0;
        for (int i = 0; i <90 ; i++) {

            deletButonu = driver.findElement(By.xpath("//*[text()='Delete'][1]"));
            deletButonu.click();
            sayac++;
        }

       List<WebElement> liste = driver.findElements(By.xpath("//*[text()='Delete']"));
        System.out.println(liste.size());

        if (sayac==90){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        driver.close();
    }
}
