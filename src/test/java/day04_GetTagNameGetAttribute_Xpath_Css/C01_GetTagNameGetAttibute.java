package day04_GetTagNameGetAttribute_Xpath_Css;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttibute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //techpro sayfasina gidelim.
        driver.get("https://www.techproeducation.com");


        //arama kutusunu locate edelim.
        WebElement aramaKutusu=driver.findElement(By.id("searchHeaderInput"));


        //arama kutusunun tag namenin "input oldugunu dogrulayalim.
        System.out.println("Tag Name : " +aramaKutusu.getTagName());  //input
        String gercekTagname = aramaKutusu.getTagName();
        String istenenTagname = "input";
        if (gercekTagname.equals(istenenTagname)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //aramakutusunun class attribute nin form-input oldugunu test edelim.
        System.out.println("Class Attribute Degeri : " +aramaKutusu.getAttribute("class"));   //form-input


        String gercekAttribute = aramaKutusu.getAttribute("class");
        String istenenAttribute = "form-input";
        if (gercekAttribute.equals(istenenAttribute)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.close();



    }
}
