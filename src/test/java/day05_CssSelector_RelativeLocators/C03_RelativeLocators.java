package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        ////https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        ////Berlin'i 3 farkli relative locator ile locate edin
        WebElement nycElementi= driver.findElement(By.xpath("//img[@id='pid3_thumb']"));
        WebElement areaElementi = driver.findElement(By.id("pid8_thumb"));
        WebElement berlin = driver.findElement(with(By.tagName("img")).below(nycElementi).toLeftOf(areaElementi));
         berlin.click();
         Thread.sleep(2000);


        ////Relative locator'larin dogru calistigini test edin.
        String actualIdDegeri=berlin.getAttribute("id");  //pid7_thumb

        String expectedId= "pid7_thumb";
        if (actualIdDegeri.equals(expectedId)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        driver.close();

      //RELATIVE LOCATORS:
        //Bir web sayfasinda benzer taglara sahip web elemntlerin oldugu durumlarda kullanilir
        //ornegin bir web elemntini locate ettiniz ve o elemntin altindaki bir web elemnte ulasmak icin onundeki baska bir web elementi
        //kapatmaniz gerekir.(Reklam gibi) Bu gibi durumlarda relative locator ile o elementin locate ni almadan yukaridaki ornekteki gibi handle
        //edebilirsiniz.Relative locator ile kullanilan methodlar
             //  above--> belirtilen elementin ustundeki elementi secer.
        //       below--> belirtilen elementin altindaki elementi secer.
        //       to_left --> belirtilen elementin solundaki elementi secer.
        //       to_right_of --> belirtilen elementin sagindaki elementi secer.
        //       near --> belirtilen elementin yaninda/yakinindaki elementi secer.

    }
}
