package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        /*
Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes


    Checkbox2 seçili değilse onay kutusunu tıklayın

 */ //Checkbox1 ve checkbox2 elementlerini locate edin
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        WebElement checkbox2= driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
        Thread.sleep(2000);

       // Checkbox1 seçili değilse onay kutusunu tıklayın.
        if (!checkbox1.isSelected()){    //secili degilse
            checkbox1.click();


        }if (!checkbox2.isSelected()){     //secili degilse
            checkbox2.click();

        }
    }
}
