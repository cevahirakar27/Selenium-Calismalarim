package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alert extends TestBase {

      /*
        Eğer bir sayfadaki butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan uyarı penceresine sağ klik
    yapamıyorsak (incele/inspect) bu tür uyarı pencerelerine js Alert denir. Bu uyarı penceresini handle edemediğimiz
    için driver'i bu pencereye geçiş yaptırmamız gerekir. Bunun içinde switchTo() methodu kullanılır.
    driver.swichTo().alert() methoduyla alert'e geçiş yaparız. Ve alert onaylamak için accept(), iptal etmek için
    dismiss(), alert üzerindeki yazıyı almak için getText() ve alertteki mesaj kutusuna bir text göndermek için
    sendKeys() methodunu kullanırız.
     */
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() {
      //  Bir metod olusturun: acceptAlert
      //  1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
       driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        WebElement birinciButon= driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]"));
        birinciButon.click();
        bekle(2);

        driver.switchTo().alert().accept();
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@id='result']"));
        String actual=sonucYazisi.getText();
        String expected ="You successfully clicked an alert";
        Assert.assertEquals(expected,actual);
        bekle(2);

    }

    @Test
    public void dismissAlert() {
        //   Bir metod olusturun: dismissAlert
        //        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        “successfuly” icermedigini test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        WebElement ikinciButon = driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]"));
        ikinciButon.click();
        driver.switchTo().alert().dismiss();
        WebElement sonucYzisi= driver.findElement(By.xpath("//*[@id='result']"));
        String actualYazi= sonucYzisi.getText();
        String expected ="successfuly";
        Assert.assertFalse(actualYazi.contains(expected));
        bekle(2);

    }

    @Test
    public void sendKeysAlert() {

        //  3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("Berrin");
        bekle(2);
        driver.switchTo().alert().accept();

        WebElement sonucYazisi= driver.findElement(By.cssSelector("#result"));
        String actual= sonucYazisi.getText();
        String expected="Berrin";
        Assert.assertTrue(actual.contains(expected));
        bekle(2);
    }
}
