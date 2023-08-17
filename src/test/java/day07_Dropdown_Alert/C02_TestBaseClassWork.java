package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {

    @Test
    public void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // 1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));
        bekle(2);
      selectIndex(ay,4);
      selectVisible(yil,"2012");



    }
}
