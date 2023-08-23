package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSecme = driver.findElement(By.id("file-upload"));


        //Yuklemek istediginiz dosyayi secelim.
        // "C:\Users\DELL\Desktop\B171.txt"
        String dosyaYolu ="C:\\Users\\DELL\\Desktop\\B171.txt";
        dosyaSecme.sendKeys(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);

       //"File Uploaded!" textinin goruntulendigini test edelim.
        String fileUpload = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",fileUpload);





    }
}
