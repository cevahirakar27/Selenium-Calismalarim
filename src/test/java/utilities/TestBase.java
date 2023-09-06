package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public  class TestBase {

    //rapor methodu icin
    protected ExtentReports extentReport;//-->raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    protected ExtentTest extentTest;//-->Test adımlarına bilgi eklenir


    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    //HARD WAIT
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Select VisibleText
    public void selectVisible(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //Select index
    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //WindowHandles
    public void window(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //iframe
    public void frameindex(int index) {
        driver.switchTo().frame(index);
    }

    //UploadFile Robot Class
    public void robotClass(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //ScrrenShot
    public void ekranResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/screenShot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void webElementEkranGoruntusu(WebElement element) {

        //sonuc yazisi webelementiinin resmini alalim.

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/WebElementEkranGoruntusu/screenShot" + tarih + ".png";
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Extent Report
    public void rapor(String browser, String reportName) {

        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester", "Cevahir");
        extentReport.setSystemInfo("browser", browser);
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);

    }

    //JS Click Method
    public void jsclick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }

    }

    //JS scrollTo Element
    public void jsScroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }


    //JS scrollToEnd
    public void jsScrollEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //JS scrollToHome
    public void jsScrollHome(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    //JS SendKeys
    public void jsSendKeys(WebElement element,String value){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+value+"'",element);

    }

}
