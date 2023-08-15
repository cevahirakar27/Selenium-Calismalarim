package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadiuButton {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        //https://www.facebook.com adresine gidin.
        driver.get("https://www.facebook.com");

//"Create an Account" button'una basin
        WebElement kaydolButonu = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        kaydolButonu.click();

//"radio buttons" elementlerini locate edin;
     WebElement kadin=   driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

//Secili degilse cinsiyet butonundan size uygun olani secin
        if (!kadin.isSelected()){
            kadin.click();
        }


    }
}
