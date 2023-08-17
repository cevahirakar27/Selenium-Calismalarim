package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C15_AmazonDropDown extends TestBase {

    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori
    //sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1.Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin


    @Test
    public void test01() {
        //● https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");


        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin.

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);

        int actualOptionSayisi = select.getOptions().size();
        System.out.println("actualOptionSayisi = " + actualOptionSayisi);
        Assert.assertEquals(28,actualOptionSayisi);

    }

    @Test
    public void test02() {

        //1.Kategori menusunden Books secenegini secin

        driver.get("https://www.amazon.com/");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");


        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucYazisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String expected = "Java";
        Assert.assertTrue(sonucYazisi.getText().contains(expected));


    }
}
