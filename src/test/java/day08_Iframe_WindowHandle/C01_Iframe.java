package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void iframe() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

       //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim.
        WebElement text= driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']"));
        String actual = text.getText();
        Assert.assertTrue(actual.contains("black border"));


      //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim.

        driver.switchTo().frame(0); // --> index ile 1. iframe gectik.
        WebElement applicationList = driver.findElement(By.xpath("//h1"));

        String sonuc = applicationList.getText();
        Assert.assertEquals("Applications lists",sonuc);

     //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().defaultContent();

        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("iframe",iframeYazisi.getText());



    }


    /*
    bir html dokumani icine yerlestirilmis baska bir html dokumanina inline Frame(iframe) denir.sayfadaki bir web elemnti locate ettigimizde
    nosucheelementexception aliyorsak once locate i kontrol ederiz. ve yine ayni hatayi aliyorsak locate etmek istedigimiz webelement iframe icinde olabilir.
    dolayisiyla iframe icindeki bir web elementi locate etmek icin driverimizi iframe gecirmemiz gerekir
     Alertten bilidigimiz ayni gecis komutu olan switchto methodunu kullanarak gecis yapariz.frame methodu parametre olarak hangi frame geci
     lecegini ister
     driver.switchto.frame(1.sayfadaki iframe in indexi (index 0 dan baslar)
     driver.switchto.frame(2. < iframe > tagindaki id/name attribute degeri)
     driver.switchto.frame(3. iframe nin locate)
     bu 3 yontem ile iframe gecis yapabiliriz.

    Ana sayfaya gecmek istersek defaultContent methodu ile
    Eger ic ice iframe lere gecis yaptiysak parentFrame methodu ile bir ust iframe gecis yapariz
     */
}
