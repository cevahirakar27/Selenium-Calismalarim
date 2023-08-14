package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Xpath_Tekrar {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        //2. Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(2000);

        //3. Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //4. Delete tusuna basin
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        Thread.sleep(2000);

        //5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("//h3"));
        if (sonucYazisi.isDisplayed()){
            System.out.println("SONUC YAZİSİ GORUNUR TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.close();
    }
}
