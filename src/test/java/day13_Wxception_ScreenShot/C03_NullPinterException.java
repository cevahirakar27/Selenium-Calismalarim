package day13_Wxception_ScreenShot;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPinterException {

    WebDriver driver;
    Faker faker;

    @Test
    public void test01() {
       driver.get("https://amazon.com");  //NullPointerException atama yapmadigimiz icin

    }


    @Test
    public void test02() {
        System.out.println(faker.name().firstName());  //NullPointerException atama yapmadigimiz icin
    }
}
