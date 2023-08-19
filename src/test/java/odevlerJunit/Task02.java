package odevlerJunit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Task02 extends TestBase {

    //-Amazon sayfasına gidelim
    //-Arama Kutusundaki Dropdown menuyu yazdıralım
    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

    @Test
    public void test01() {

        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();


        //-Arama Kutusundaki Dropdown menuyu yazdıralım.
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(ddm);
      List<WebElement>liste =  select.getOptions();
        System.out.println(liste.size());  //28

        for (WebElement w:liste){
            System.out.println(w.getText());
        }


        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım.


    }
}
