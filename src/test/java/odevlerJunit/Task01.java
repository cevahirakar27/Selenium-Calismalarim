package odevlerJunit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task01 extends TestBase {
    //- ebay sayfasına gidiniz
    //- electronics bölümüne tıklayınız
    //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    //- Her sayfanın sayfa başlığını yazdıralım


    @Test
    public void test01() {

        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım.
        List<WebElement> liste = driver.findElements(By.xpath("//*[@width=225 and @height=225]"));

        for (int i=0 ;i<liste.size();i++  ){
            liste = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            liste.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

    }
}
