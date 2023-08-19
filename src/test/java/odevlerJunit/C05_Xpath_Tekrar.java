package odevlerJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Xpath_Tekrar {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
/*



        d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
*/
       // a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();


        //  b.Search(ara) “city bike”
   WebElement aramaKutusu=    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city bike" +Keys.ENTER);


        //c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement sonucSayisi= driver.findElement(By.xpath("//*[text()='1-16 of 448 results for']"));
        System.out.println(sonucSayisi.getText()); //1-16 of 448 results for

        String [] arr =sonucSayisi.getText().split(" ");
        System.out.println("sonuc sayisi : " +arr[2]);  //448

        driver.close();



    }

}
