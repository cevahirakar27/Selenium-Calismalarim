package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
//Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
//Textbox içindeki yazıyı siliniz.
//Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
//Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.

    @Test
    public void iframe() {

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String  kalinYazi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(kalinYazi.contains("Editor"));



        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

       //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

       //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
       driver.switchTo().defaultContent();
       //  driver.navigate().refresh(); ana sayfaya doner fakat iframe icinde yapilan degisiklikler ilk haline doner.
      //  driver.get(driver.getCurrentUrl());   sayfayi yenile demek
      WebElement yazi =  driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
      Assert.assertEquals("Elemental Selenium",yazi.getText());
    }
}
