package odevlerJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*

        1.Bir class oluşturun: LoginTest
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
a. http://a.testaddressbook.com adresine gidiniz.
b. Sign in butonuna basin
c. email textbox,password textbox, and signin button elementlerini locate ediniz..
d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
i. Username : testtechproed@gmail.com
ii. Password : Test1234!
e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun.
         */

        //  http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='//www.herokucdn.com/error-pages/no-such-app.html']"));
        driver.switchTo().frame(iframe);

        WebElement tikla= driver.findElement(By.xpath("//*[text()='Build something amazing']"));
        tikla.click();
        Thread.sleep(1000);



        //b. Sign in butonuna basin
        driver.findElement(By.linkText("Log in")).click();


        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailKutusu= driver.findElement(By.xpath("//input[@id='email']"));
        WebElement sifreKutusu= driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginKutusu= driver.findElement(By.xpath("//button[@name='commit']"));



     //   d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
     //   i. Username : testtechproed@gmail.com
     //   ii. Password : Test1234!
        emailKutusu.sendKeys("testtechproed@gmail.com");
        sifreKutusu.sendKeys("Test1234!");
        loginKutusu.click();
        Thread.sleep(1000);

              //  e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
              //  f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
              //  doğrulayin(verify).


        //   3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkSayisi= driver.findElements(By.tagName("a"));
        System.out.println(linkSayisi.size());  //11

        for (WebElement w: linkSayisi){
            System.out.println(w.getText());
        }
        driver.close();


    }
}
