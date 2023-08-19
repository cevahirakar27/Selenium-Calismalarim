package odevlerJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_Odev {

    /*
//https://www.facebook.com adresine gidin
//Url'in facebook içerdiğini test(assertion ile)
//"Create an Account" button'una basin
//Çıkan formu doldurunuz
//kaydol butonuna tıklayınız
Not: Before methodda driver ayarlarını yapınız
    After ile sayfayı kapatınız
 */
   static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {

        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(3000);
      driver.close();
    }

    @Test
    public void test01() {

        //Url'in facebook içerdiğini test(assertion ile)

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "facebook";
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        //"Create an Account" button'una basin
        //Çıkan formu doldurunuz
          //kaydol butonuna tıklayınız
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement adKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        adKutusu.sendKeys("Berrin", Keys.TAB,"acar",Keys.TAB,"kylar.simcha@fixedfor.com",
                Keys.TAB,"acar2435.?"
        ,Keys.TAB,Keys.TAB,"12",Keys.TAB,"Eyl",Keys.TAB,"2001");

        WebElement kadınButonu = driver.findElement(By.xpath("//input[@class='_8esa'][1]"));
        kadınButonu.click();


        WebElement kaydol= driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _6o _6v']"));
        kaydol.click();




    }
}
