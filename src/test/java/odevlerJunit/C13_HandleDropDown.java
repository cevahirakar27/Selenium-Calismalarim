package odevlerJunit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C13_HandleDropDown extends TestBase {
    //●https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın.


    @Test
    public void test01() {
        //●https://the-internet.herokuapp.com/dropdown adresine gidin.
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
       String secenek1= select.getFirstSelectedOption().getText();
        System.out.println("SECENEK 1 : "+secenek1);
        bekle(2);


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.(method olusturdum asagida)
        value(ddm,"2");
        String secenk2 = select.getFirstSelectedOption().getText();
        System.out.println("SECENEK2 : "+secenk2);


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
        selectVisible(ddm,"Option 1");
        String secenek01 =select.getFirstSelectedOption().getText();
        System.out.println("SECENEK1 : " +secenek01 );

        System.out.println("***********************************");

        //4.Tüm dropdown değerleri(value) yazdırın.(Optionlari)
        List<WebElement> tumOptionListesi= select.getOptions(); //listedeki butun elementleri verir
            //lambda ile.
        tumOptionListesi.forEach(t-> System.out.println(t.getText()));

        System.out.println("***********************************");

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse false
        System.out.println("OPTION SIZE :" +tumOptionListesi.size());
        int expected =  4;
        int actual= tumOptionListesi.size();
        if (actual==expected){
            System.out.println("true");
        }else {
            System.out.println("false");    //false yazdirir
        }


    }

    public void value(WebElement ddm,String value){
        Select select=new Select(ddm);
        select.selectByValue("2");

    }
}

