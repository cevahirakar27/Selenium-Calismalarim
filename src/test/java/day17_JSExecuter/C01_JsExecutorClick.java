package day17_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorClick extends TestBase {


    @Test
    public void test01() {

        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        bekle(2);

        // sell linkine tıklayalım
        WebElement sellElementi = driver.findElement(By.xpath("//*[.='Sell']"));
        sellElementi.click();
        /*
        sell web elementinin önünde pencere çıktığı için elemente click yapamadı.
        bunu javascriptexecuterle yaparız
         */

        }

        @Test
        public void test02() {
          /*
            Js Executor kullanımında öncelikle JavascriptExecutor arayüzünden bir obje oluşturup, TakeScreenShot'taki
        gibi driver'a eşitleriz. Farklı arayüzler olduğu için casting yaparız. Oluşturduğumuz obje ile
        executeScript() methodunu kullanarak bu method içine script kodunu yazarız. Dolayısıyda webDriver ile
        click yapamadığımız webelementini aşağıdaki örnekteki gibi js executor ile click yapabildik.
         */
            //amazon sayfasına gidelim
            driver.get("https://www.amazon.com");
            bekle(2);

            // sell linkine tıklayalım
            WebElement sellElementi = driver.findElement(By.xpath("//*[.='Sell']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;

         js.executeScript("arguments[0].click();",sellElementi);

    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        bekle(2);

        // sell linkine tıklayalım
        WebElement sellElementi = driver.findElement(By.xpath("//*[.='Sell']"));
       jsclick(sellElementi);

    }
}
