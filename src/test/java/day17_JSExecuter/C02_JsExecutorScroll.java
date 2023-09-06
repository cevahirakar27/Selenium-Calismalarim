package day17_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorScroll extends TestBase {

    @Test
    public void test01() {
        //amazon sayfasına gidelim.
        driver.get("https://www.amazon.com");

        //""back to school " web elementine kadar scroll yapalim.

        WebElement backtoschoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",backtoschoolWE);
        bekle(2);


        //sayfanın en altina scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);

        //sayfanın en ustune scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    public void test02() {

        //amazon sayfasına gidelim.
        driver.get("https://www.amazon.com");

        //""back to school " web elementine kadar scroll yapalim.

        WebElement backtoschoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
     jsScroll(backtoschoolWE);
        bekle(2);



        //sayfanın en altina scroll yapalım
       jsScrollEnd();
        bekle(2);

        //sayfanın en ustune scroll yapalım
       jsScrollHome();
    }
}
