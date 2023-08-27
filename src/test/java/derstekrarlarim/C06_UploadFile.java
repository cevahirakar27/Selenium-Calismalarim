package derstekrarlarim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_UploadFile extends TestBase {

    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.

    //Upload butonuna basalim.
    //"File Uploaded!" textinin goruntulendigini test edelim.


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        bekle(2);

        //Yuklemek istediginiz dosyayi secelim.
        //    "C:\Users\DELL\Desktop\B171.txt"
        String dosyaYolu ="C:\\Users\\DELL\\Desktop\\B171.txt";
          dosyaSec.sendKeys(dosyaYolu);
          bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        String actual = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",actual);
    }
}
