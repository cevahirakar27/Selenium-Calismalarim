package day15_ExtentReport_WebTable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {

    @Test
    public void test01() {

        rapor("Chrome","Amazon Testi");
        extentTest = extentReport.createTest("Extent Report","Test Raporu");
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        extentTest.info("Kullanici Amazon Sayfasina Gider");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("arama kutusu locate edilidi");
        aramaKutusu.sendKeys("iphoe",Keys.ENTER);
        extentTest.info("arama kutusunda iphone aratilidi");
        extentReport.flush();

    }
}
