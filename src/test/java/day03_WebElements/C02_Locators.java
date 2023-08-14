package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Techproeducation sayfasina gidin
        driver.get("https://www.techproeducation.com");

        //arama kutusunu locate edip java aratalim
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        aramaKutusu.sendKeys("java");
        Thread.sleep(2000);

        //cikan secenkelerden full stack developer secenegine tiklayalaim.
        List<WebElement> linkler= driver.findElements(By.linkText("Full Stack Java Developer"));
        for (WebElement w: linkler){
            System.out.println(w.getText());
        }
        linkler.get(0).click();


        //basligin java icerdigini test edelim.
      if (driver.getTitle().contains("Java")){
          System.out.println("test passed");
      }else {
          System.out.println("test failed");
      }

        //sayfada kac link oldugunu yazdiralim
        System.out.println(linkler.size());

        //sayfadaki linkleri konsola yazdiralim.
        List<WebElement> sayfadakiLinkSayisi = driver.findElements(By.tagName("a"));
        System.out.println(sayfadakiLinkSayisi.size());

        for (WebElement w: sayfadakiLinkSayisi){
            if (!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }


        //lambda ile
        sayfadakiLinkSayisi.forEach(t-> System.out.println(t.getText()));
        sayfadakiLinkSayisi.stream().filter(t-> !t.getText().isEmpty()).forEach(t-> System.out.println(t.getText()));

        driver.close();





    }
}
