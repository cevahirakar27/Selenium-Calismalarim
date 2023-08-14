package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
        Thread.sleep(2000);

        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin
       WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
       login.sendKeys("username",Keys.TAB,"password",Keys.ENTER);

        driver.navigate().back();
        Thread.sleep(2000);

        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        WebElement payyBills = driver.findElement(By.cssSelector("#pay_bills_link"));
        payyBills.click();


        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina “2020-09-10” yazdirin
        //9.Pay buttonuna tiklayin
        WebElement amount = driver.findElement(By.cssSelector("#sp_amount"));
        amount.sendKeys("10",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB);

        Thread.sleep(2000);
         amount.sendKeys(Keys.ENTER);

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonucYzisi = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        sonucYzisi.getText();
        String verilen = "The payment was successfully submitted.";
        if (sonucYzisi.getText().equals(verilen)){
            System.out.println("sonuc yazisi passed");
        }else {
            System.out.println("sonuc yazisi FAILED");
        }


       Thread.sleep(2000);
        driver.close();

    }
}
