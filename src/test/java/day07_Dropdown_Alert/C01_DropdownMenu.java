package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {

    /*
    Dropdown menu ; alt basliklarin listelendigi web elemente denir..Bu
     web elementteki alt basliklara ulasabilmek bu alt basliklari handle edebişlmek
    icin oncelikle web elementin locate ni aliriz.sonra select classindan bir obje olusturup parametre olarak.locateni aldigimiz web elementi
    yazariz ve bu obje ile selectByIndex(),selectByValue() ve selectByVisibleTest() methodlarini kullanarak alt basliklri secebiliriz.
    getOptions() methodu bize bu alt basliklarin hepsini verir.
       Cogu zaman bu dropdown bu web elementine sendKeys() methodu ile alt basliklardaki herhangi bir secenegi gonderebiliriz.
       Dropdown menudeki ilke seceili olan secenegi getFirstSelectedOtions() methodu verir
     */

    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {
        // 1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));

        //        b. Select objesi olustur
        Select selectYil = new Select(yil);
        Select selectAy=new Select(ay);
        Select selectGun=new Select(gun);

        //        c. Select object i kullaarak 3 farkli sekilde secim yapiniz.
        selectYil.selectByVisibleText("2012");
        selectAy.selectByIndex(1);   //index 0 dan baslar.
        selectGun.selectByValue("12");

    }

    @Test
    public void test02() {
        // 2.Method:
        //        a. Tüm eyalet isimlerini yazdıralım.

        WebElement eyalet = driver.findElement(By.xpath("//*[@id='state']"));
        Select select=new Select(eyalet);
        List<WebElement> eyaletListesi =select.getOptions();
        System.out.println(eyaletListesi.size());   //52

     //   for (WebElement w:eyaletListesi){
       //     System.out.println(w.getText());
       // }

        //lambda ile yazdiralim
        eyaletListesi.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test03() {
        // 3.Method:
        //        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim.

        WebElement eyalet = driver.findElement(By.xpath("//*[@id='state']"));
        Select select=new Select(eyalet);
        String actualResult= select.getFirstSelectedOption().getText();
        String expectedResult = "Select a State";
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void denemeList() {

        //select kullanmadan butun eyaletleri yazdiralim.
        List<WebElement> eyaletList = driver.findElements(By.xpath("//select[@id='state']//option"));
        eyaletList.forEach(t-> System.out.println(t.getText()));
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
