package day13_Wxception_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        /*

        SCREENSHOT
         Selenium da tüm sayfanın resmini alabilmek için;
        1-TakeScreenShot arayüsünden bir obje oluşturup driver'a eşitleriz
        Farklı arayüzler olduğu için casting yaparız.
        2-FileUtils class'ından copyFile() method'u içe parametre olarak
        oluşturmuş olduğumuz obje ile getScreenShotAs() methodunu kullanır getScreenshot() methoduna
        parametre olarak OutputType.File ekleriz ve bunu yeni bir dosyaya kaydedmesi için
        new File() diyerek resmi kaydedeceğimiz dosyanın yolunu belirtiriz
         */

        //Amazona gidp sayfa resmini alalim.
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("src/test/java/utilities/TumSayfaResimleri/screenShot.jpeg"));

    }

    @Test
    public void test02() throws IOException {
        //techpro sayfasina gidelim.ekran resmini alalim  //2.yol
        driver.get("https://www.techproeducation.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "src/test/java/utilities/TumSayfaResimleri/techproScreenShot.jpeg";
        File file= new File(dosyaYolu);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),file);

    }

    @Test
    public void test03() throws IOException {

        //facebook sayfasina gidip ekran resmni alalim
        driver.get("https://www.facebook.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "target/facebookScreenShot.png";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
