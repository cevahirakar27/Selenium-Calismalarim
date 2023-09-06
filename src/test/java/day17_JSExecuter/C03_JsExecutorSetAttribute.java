package day17_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutorSetAttribute extends TestBase {

    //amazona gidelım
    // JSExecutorla arama kutusuna java gonderelim.

/*

    sendKeys() methodu ile <input> tagına sahip bir webelemente jsscript kodlarıyla yazılmış ise
bir veri gönderemeyiz. Bu gibi durumlarda js executor ile çok veri gönderebiliriz
 */
    @Test
    public void test01() {

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='java'",aramaKutusu);


    }

    @Test
    public void test02() {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys(aramaKutusu,"nutella");

    }

    @Test
    public void tes03() {
        driver.get("https://www.amazon.com");

        //arama kutusu id attribute degerini ismimiz ile degistirelim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','cevahir')",aramaKutusu);


        // ve arama kutusunda degistirdiğimiz attribute ile iphone aratalım.
        WebElement aramaKutusu2 = driver.findElement(By.id("cevahir"));
        js.executeScript("arguments[0].value='iphone';",aramaKutusu2);

    }
}
