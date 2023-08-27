package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {


    @Test
    public void test01() throws IOException {

        // amazon sayfasina gidelim.sayfanin resmini alalim

        driver.get("https://www.amazon.com");

        String dosyaYolu ="src/test/java/utilities/screenSot/ekranGoruntusu.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {


        // amazon sayfasina gidelim.sayfanin resmini alalim

        driver.get("https://www.amazon.com");

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="target/ekranGoruntusu/screenShot"+tarih +".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test03() {


        // youtube sayfasina gidelim.sayfanin resmini alalim

        driver.get("https://www.youtube.com");
        ekranResmi(); // test base classindaki method ile ekran resmini aldik.
    }
}
