package dersTekrarlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();



        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        driver.navigate().back();


        //online bunking e tiklayin
        driver.findElement(By.xpath("//*[text()='Online Banking'][1]")).click();


        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina “2020-09-10” yazdirin
        //9.Pay buttonuna tiklayin
        WebElement amount= driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("5",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB);


        Thread.sleep(2000);
        amount.sendKeys(Keys.ENTER);



        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin.
        String istenen ="The payment was successfully submitted.";
        WebElement sonuCYazisi = driver.findElement(By.xpath("The payment was successfully submitted."));
        sonuCYazisi.getText();
        if (sonuCYazisi.getText().equals(istenen)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");


        driver.close();

    }
}
