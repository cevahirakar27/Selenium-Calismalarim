package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ExplicitWait_FluentWait extends TestBase {

    @Test

    /*
bir web butona tikladigimizda kisa sureli ekranda duran ve kaybolan bir webelementin locate'ni nasil aliriz.
Web sayfasinda sag tus incele dedikten sonra, 'source'(Kaynaklar) kismina basar ve butona tikladigimizda
sagdaki pause isaretiyle web elementlerin yuklenmesini durudurabiliriz. Bu sekilde de kaybolan yazi veya elementin
locateni rahatlikla alabiliriz.

     */
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla.
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et.
        WebElement helloWord = driver.findElement(By.xpath("(//h4)[2]"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)). // max bekleme suresi
        pollingEvery(Duration.ofMillis(200)).    // belirttigimiz surede kontrol eder.
        withMessage("web elementi ve sureyi kontrol et");  //hata durUMUNDA MEASJ VERİR

        wait.until(ExpectedConditions.visibilityOf(helloWord));
        Assert.assertEquals("Hello World!",helloWord.getText());
    }

    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla.
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et.
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
    }

