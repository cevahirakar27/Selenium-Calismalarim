package odevlerJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C12_DropDownOdev extends TestBase  {

    //https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidelim
//programming languages ddm den istediğiniz 4 seçeneği seçiniz
//sadece seçili olan option'ları yani seçenekleri yazdıralim
//Seçeneklerden 4 tane seçtiğimizi doğrulayalım
//Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
//Seçtiğimiz seçeneklerin hepsini kaldıralim
//visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim.


    @Test
    public void test01() {
        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        //sadece seçili olan option'ları yani seçenekleri yazdıralim
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement ddm = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("C");
        select.selectByVisibleText("Ruby");
        select.selectByVisibleText("C#");
        select.selectByVisibleText("Java");

       List<WebElement>seciliOlanlar= select.getAllSelectedOptions();
       seciliOlanlar.forEach(t-> System.out.println(t.getText()));


        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım.
        int seciliOlanlarSayisi=seciliOlanlar.size();
        Assert.assertEquals(4,seciliOlanlarSayisi);



      //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
        String actualIlk   = select.getFirstSelectedOption().getText();
        System.out.println("İLK SECENEK : "+ actualIlk);
        String ilk = "Java";
        Assert.assertEquals(ilk,actualIlk);  //ilk secenegin java oldugunu dogruladik


        //Seçtiğimiz seçeneklerin hepsini kaldıralim
        select.deselectAll();  //sectigimiz secenekleri kaldirdik.


        //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim.
        visibleTest(ddm,"C#");


    }

    public void visibleTest(WebElement ddm,String visible){   //visibleTest methodunu ayni sayfada olusturdum.
        Select select=new Select(ddm);
        select.selectByVisibleText(visible);
    }
}
