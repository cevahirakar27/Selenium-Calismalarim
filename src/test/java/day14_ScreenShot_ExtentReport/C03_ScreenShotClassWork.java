package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase {

    //Techprıeducation sayfasina gidelim.
    // Events linkine tiklayalim
    //Baligin Events oldugunu dogrulayalim.
    //sayfanin resmini alalim.
    //yeni bir sekmede amazon sayfasina gidelim
    // ve sayfanin resmini alalim
    //arama kutusunda iphone aratalim.
    //cikan sonuc yazisinin resmini alalim.
    //Techpro sayfasina geri donelim
    //ve sayfanin resmini alalim.


    @Test
    public void test01() throws IOException {

        //Techprıeducation sayfasina gidelim.
        driver.get("https://www.Techproeducation.com");
        String windowHandle1 = driver.getWindowHandle();

        // Events linkine tiklayalim
        driver.findElement(By.xpath("(//*[.='Events'])[1]")).click();

        //Basligin Events icerdigini dogrulayalim.
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Events"));

        //sayfanin resmini alalim.
        TakesScreenshot ts = (TakesScreenshot) driver;
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/ekranGoruntusu"+tarih+".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //yeni bir sekmede amazon sayfasina gidelim.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        bekle(1);

        // ve sayfanin resmini alalim.
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        String tarih1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu1= "target/ekranGoruntusu/ekranGoruntusu"+tarih1+".jpeg";
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE),new File(dosyaYolu1));

        //arama kutusunda iphone aratalim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone "+ Keys.ENTER);

        //cikan sonuc yazisinin resmini alalim.
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String zaman = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String yol= "target/ekranGoruntusu/WebElementEkranGoruntusu"+zaman+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(yol));

        //Techpro sayfasina geri donelim.
        driver.switchTo().window(windowHandle1);
        // window(0) bunu da kullanabilirs method olarak

        //ve sayfanin resmini alalim.

        TakesScreenshot ts2 = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String pathYol= "target/ekranGoruntusu/ekranGoruntusu"+date+".jpeg";
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE),new File(pathYol));

    }

    @Test
    public void test02() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement eventsWE = driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
        eventsWE.click();

        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));

        //Ve sayfanın resmini alalım
        ekranResmi();

        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        ekranResmi();

        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //Çıkan sonun yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementEkranGoruntusu(sonucYazisi);

        //Techpro sayfasına geri dönelim
        window(0);

        //ve sayfanın resmini alalım
        ekranResmi();
    }
}
