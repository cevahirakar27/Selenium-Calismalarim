package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locaters {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Arama kutusuna iphone yazdirip aratiniz.
       WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("iphone", Keys.ENTER);
       Thread.sleep(1000);
       driver.close();

    }
}
