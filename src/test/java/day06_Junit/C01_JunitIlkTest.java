package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitIlkTest {
       /*
        Projemizde Junit framework'u kullanmak istiyorsak öncelikle mvnrepository.com adresinden junit
    dependency'sini pom.xml dosyamıza koymamız gerekiyor. Bu dependency sayesinde artık main methot
    kullanmadan notasyonlar sayesinde test scriplerimizi yazacayız.Notasyonlar @ işareti ile başlar
        @Test notasyonu içinde oluşturacağimız test methodunda kodlarımızı yazar ve çalıştırırız.
        @Test notasyonuna sahip bir methodu hızlı bir şekilde oluşturmak istersek alt+insert tuşlarına
    basarak test methodunu oluşturabiliriz.
        Junit te testlerimizi istedigimiz siralamada calistirmak istersek alfabetik ve numerik olarak test methodlarinin isimlerini belirtmemiz
        gerekir.

     */



@Test
    public void test01(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://techproeducation.com");

}

    @Test
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }

    @Test
    public void test03() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");

    }

    @Test
    public void test04() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");

    }
}
