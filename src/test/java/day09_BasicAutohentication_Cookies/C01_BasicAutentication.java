package day09_BasicAutohentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAutentication extends TestBase {

    @Test
    public void test01() {

         //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        //    Başarılı girişi doğrulayın.

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


        //    Başarılı girişi doğrulayın.

        //elemental selenium linkine tiklayin
        driver.findElement(By.xpath("(//a)[2]")).click();

        //baslgin Elemental selenium icerdigini test edin.
        window(1);   //-->  //test basedeki method

        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));



    }
}
