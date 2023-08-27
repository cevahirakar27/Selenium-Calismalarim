package day13_Wxception_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void test01() {
  /*
      TİMEOUTEXCEPTION:
   1) kullanilan explicit waitteki max sureyi kontrol etmemiz gerekir.
   2) explicit wait ile kullandiginiz elementin locateni kontrol etmemiz gerekir
   3) expilict wait ile kullandigimiz methodu dogru secmemiz gerekir.

   */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

       //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // timeoutexception almak icin sureyi azalttik.
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!",helloWorldWE.getText());

    }

    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("yanlis locate")));  //gecrsiz locate
        //wait icinde yanlis locate de bize timeoutexception verir.
        //NOT: Eger yanlis locator(örnegin :xpath yerine css gibi)  kullanirsaniz "InvalidSelectorException"
    }
}
