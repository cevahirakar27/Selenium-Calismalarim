package odevlerJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task03 extends TestBase {

    //*** Aşağıdaki task'i Junit framework'ü ile yapınız

    @Test
    public void test01() {


         //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
          driver.get("https://the-internet.herokuapp.com/windows");


        //-Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

        //-Elemental Selenium linkine tıklayınız
        elementalSelenium.click();

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualBaslik= driver.getTitle();
        String expectedBaslik ="Elemental Selenium";
        Assert.assertTrue(actualBaslik.contains(expectedBaslik));


        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="https://elementalselenium.com/";
        Assert.assertEquals(expectedUrl,actualUrl);


        //A free weekly email of tips to help make
        //Selenium one of the most robust browser
        //automation tools out there.
        //"
        //-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız.
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys("cevahirakar27@gmail.com");

        //-Language dropdown menuden Java seçiniz.
        WebElement ddm = driver.findElement(By.xpath("//select[@name='fields[programming_language]']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Java");

        //-Join the mailing list buttonuna tıklayınız
        driver.findElement(By.xpath("//input[@value='Join the mailing list']")).click();

        //-Sayfada Thank you! yazısının çıktığını doğrulayınız
        WebElement thankYouYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(thankYouYazisi.getText().contains("Thank you!"));
    }
}