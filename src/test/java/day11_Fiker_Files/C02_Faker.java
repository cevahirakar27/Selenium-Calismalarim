package day11_Fiker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void faker() {

        //1."https://facebook.com" Adresine gidin
        //2.“create new account” butonuna basin
        //3.“firstName” giris kutusuna bir isim yazin
        //4.“surname” giris kutusuna bir soyisim yazin
        //5.“email” giris kutusuna bir email yazin
        //6.“email” onay kutusuna emaili tekrar yazin
        //7.Bir sifre girin
        //8.Tarih icin gun secin
        //9.Tarih icin ay secin
        //10.Tarih icin yil secin
        //11.Cinsiyeti secin
        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //13.Sayfayi kapatin


            //1."https://facebook.com" Adresine gidin.
            driver.get("https://facebook.com");

            //2.“create new account” butonuna basin.
            WebElement hesapOlustur = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
            hesapOlustur.click();
            bekle(1);

            //3.“firstName” giris kutusuna bir isim yazin
            //4.“surname” giris kutusuna bir soyisim yazin
            //5.“email” giris kutusuna bir email yazin
            //6.“email” onay kutusuna emaili tekrar yazin
            //7.Bir sifre girin
            //8.Tarih icin gun secin
            //9.Tarih icin ay secin
            //10.Tarih icin yil secin
            //11.Cinsiyeti secin
            WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));

            Faker faker= new Faker();
            String fakeEmail =faker.internet().emailAddress();
            firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,fakeEmail);
            bekle(2);
            firstName.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,fakeEmail,Keys.TAB,faker.internet().password(),Keys.TAB,Keys.TAB,
                    "25",Keys.TAB,"Agu",Keys.TAB,"2007",Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
            bekle(1);

            //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
            WebElement kadin = driver.findElement(By.xpath("(//*[@value='1'])[4]"));
            Assert.assertTrue(kadin.isSelected());

            //13.Sayfayi kapatin
            driver.close();
    }
}
