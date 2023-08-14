package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



      //  "https://the-internet.herokuapp.com/add_remove_elements/" adresine gidin
           driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

      //  2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

      //  3Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //  4Delete tusuna basin
        deleteButonu.click();

       // 5“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (sonucYazisi.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        driver.close();


    }
}
