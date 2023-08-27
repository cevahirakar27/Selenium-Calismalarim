package day13_Wxception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {

        /*
        NosuchElementexception :
        Eger bu exception i aliyorsaniz
           1) yanlis locate almis olabiliriz.dolayisiyla locate duzeltmeniz gerekir.
           2) locate ni aldiginiz web eleent iframe icinde olabilir.dolayiisyla iframe gecis yapmaniz gerekir
           3) bir tiklama isleminden sonra yeni bir pencere acildiysa driveri o pencereye gecirmez isek bu hatayi aliriz.
           Dolayisyla pencereye gecis yapmamiz gerekir.
           4) Locate etmek istedigimiz web element sayfanin altinda ise bazen bazi sayfalar scroll yapmadan bu web elementi goremez.
           Dolayiisyla drivere elementi gostermemiz gerekir.

         */


        driver.get("https://techproeducation.com");
        WebElement aramaKutusu = driver.findElement(By.xpath("fasedbdbs"));  //noSuchException



    }
}
