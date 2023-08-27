package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {

    //Amazon sayfasina gidelim
    // arama kutusunda iphone aratalim.
    // ekran resmini alalim.
    //sonuc yazisi webelementiinin resmini alalim.
    @Test
    public void test01() throws IOException {

        /*
        eger sadece bir web elementin resmini almak istersek o elementin locateni alip WebElement.getScreenShotAs() methodu ile
        web elementin resmini alabiliriz.Bunun icin TakeScreenShot arayuzune gerek kalmadan webelementin locate ile getScreenShotAs
        methodunu kullanarak File.Utils classi ile copyFile ile resmi aliyoruz
         */

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        // arama kutusunda iphone aratalim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone "+ Keys.ENTER);
        // ekran resmini alalim.
        ekranResmi();

        //sonuc yazisi webelementiinin resmini alalim.

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="target/WebElementEkranGoruntusu/screenShot"+tarih +".png";
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test02() {

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        // arama kutusunda iphone aratalim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone "+ Keys.ENTER);
        // ekran resmini alalim.
        ekranResmi();

        //sonuc yazisi webelementiinin resmini alalim.

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="target/WebElementEkranGoruntusu/screenShot"+tarih +".png";
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        webElementEkranGoruntusu(sonucYazisi);
    }
}
