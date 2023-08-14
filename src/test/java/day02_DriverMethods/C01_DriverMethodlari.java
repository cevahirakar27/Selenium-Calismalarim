package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        String amazonUrl = "https://amazon.com";
        String techproUrl = "https://techproeducation.com";

        //Amazon sayfasına gidiniz
        driver.get(amazonUrl);

        //Sayfa başlığını konsola yazdırınız
        String amazonActualTitle = driver.getTitle();//-->Gidilen sayfanın başlığını verir
        System.out.println("Amazon Sayfasi Basligi : "+amazonActualTitle);

        //Sayfanın Url'ini konsola yazdırınız
        String amazonActualUrl = driver.getCurrentUrl();//-->Gidilen sayfanın Url'ini verir
        System.out.println("Amazon Sayfasi Url'i : "+amazonActualUrl);

        //Techproeducation sayfasına gidiniz
        driver.get(techproUrl);


        //Sayfa başlığını konsola yazdırınız
        String techproActualTitle = driver.getTitle();
        System.out.println("Techpro Sayfa Başlığı : "+techproActualTitle);

        //Sayfanın Url'ini konsola yazdırınız
        String techproActualUrl = driver.getCurrentUrl();
        System.out.println("Techpro Sayfasi Url'i : "+techproActualUrl);
       Thread.sleep(2000);
       driver.close();



    }
}
