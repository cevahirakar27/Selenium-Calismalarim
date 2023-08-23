package odevlerJunit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C18_Actions extends TestBase {

       /*
//Amazon sayfasına gidiniz
//Sayfanın ortalarındaki bir webelementi locate edip o webelemente kadar scroll yapınız
        */

    @Test
    public void test001() {

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");


        //Sayfanın ortalarındaki bir webelementi locate edip o webelemente kadar scroll yapınız.
        WebElement saat = driver.findElement(By.xpath("(//span[@class='a-list-item'])[4]"));
        Actions actions= new Actions(driver);
        actions.scrollToElement(saat).perform();

    }
}