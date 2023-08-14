package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //	1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //  2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        //	3- Görüntülenen sonuçların sayısını yazdırın.
        WebElement sonucYzzisi = driver.findElement(By.xpath("//*[text()='1-16 of 480 results for']"));
        System.out.println(sonucYzzisi.getText());  //1-16 of 480 results for


        //	4- Listeden ilk urunun resmine tıklayın.
        driver.findElement(By.className("s-image")).click();
        Thread.sleep(5000);

       driver.close();

    }
}
