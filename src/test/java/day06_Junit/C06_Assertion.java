package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {


    //1)https://www.youtube.com adresine gidin
    //2)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //=> Sayfa başlığının “YouTube” oldugunu test edin
    //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
   static WebDriver driver;


    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1)https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");


    }


    @AfterClass
    public static void afterClass() throws Exception {
     driver.close();
    }

    @Test
    public void test01() {
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle= "YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtube = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtube.isDisplayed());

    }

    @Test
    public void test02() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test03() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin.
        String actualTitle = driver.getTitle();
        String istenmeyenBaslik="youtube";
      Assert.assertNotEquals(istenmeyenBaslik,actualTitle);
    }
}
