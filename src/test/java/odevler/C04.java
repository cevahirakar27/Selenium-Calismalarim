package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.lalshoes.com/");
        driver.findElement(By.xpath("(//span[@class='dropdown-toggle'])[2]")).click();

        WebElement girisYApElement = driver.findElement(By.xpath("(//a[@class='userlink-login active-hover'])[1]"));
        girisYApElement.click();
        ////*[text()='Üye Ol']

        WebElement uyeOlElement = driver.findElement(By.xpath("//*[text()='Üye Ol']"));
        uyeOlElement.click();

        driver.findElement(By.id("FirstName")).sendKeys("Berrin");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Akar");
        driver.findElement(By.xpath("//input[@id='EmailOrPhone']")).sendKeys("rourke.nimai@fixedfor.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("bc_123....");
        driver.findElement(By.id("register-button")).click();



    }
}
