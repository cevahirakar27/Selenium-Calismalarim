package day15_ExtentReport_WebTable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {

    /*
Eğer bir sayfada içinde dataların bulunduğu bir tablo ile karşılaşırsak;
       1-<table> tag'ı ile başlıyorsa bu tag bize tüm tabloyu verir. xpath ile //table yazarak
       sayfada kaç tane tablo olduğunu tespit eder birden fazla tablo varsa (//table)[index] ile
       istediğimiz tabloyu bu şekilde locate edip getText() methodu ile yazdırabiliriz.
       2-<thead> table tag'ından sonra bu tag var ise, tablodaki başlıkları thead tag'ı ile alabiliriz
       <thead> tag'îndan sonra <tr>(table row) tag'ı başlıktaki satır'ı, <th> tag'i ise başlıktaki
       her bir hücreyi temsil eder.
       3-<tbody> thead tag'ından sonra tbody tag'ı ile tablodaki başlık altındaki verileri alabiliriz.
       tbody tag'ından sonra <tr> tag'i body içindeki satırla
    //https://the-internet.herokuapp.com/tables sayfasına gidelim
//Task 1 : Table1’i print edin
//Task 2 : 3. Row' datalarını print edin  Task 3 : Son row daki dataları print edin
//Task 4 : 5. Column datalarini print edin
//Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
//Parameter 2 = column numarasi
//printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsinrı, <td> tag'ı ise body içindeki hücreleri
       temsil eder.

 */

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");


        //Task 1 : Table1’i print edin.
        WebElement tablo1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo1 : "+tablo1.getText());
        System.out.println("*****************************");


        //Task 2 : 3. Row' datalarını print edin.
        WebElement row3 = driver.findElement(By.xpath("(//tr)[4]"));
        System.out.println("Row3 : "+row3.getText());


        // Task 3 : Son row daki dataları print edin.
        /*
Xpath kullaniminda eger bir webtable'da son satir bilgisi istenirse yukaridaki ornekteki gibi
satir icindeki index yerine last() function'i kullanabilirsiniz.
 */
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        System.out.println("son satir : " +sonSatir.getText());
        System.out.println("*******************************");


        //Task 4 : 5. Column datalarini print edin.
        WebElement column5Baslik = driver.findElement(By.xpath("(//thead)[1]//tr//th[5]"));
        System.out.println("5.sutundaki baslik : "+column5Baslik.getText()); //Web Site
        System.out.println("******************************************");

      List<WebElement> column5data = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
      for (WebElement w : column5data){
          System.out.println(w.getText());
      }

    // lambda ile column5data.forEach(t-> System.out.println(t.getText()));



        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin.

      printData(2,3);

            }

    private void printData(int satir, int sutun) {
        System.out.println("***********************************");
        WebElement satir2sutun3 = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satir2sutun3.getText());
    }
}

    /*
   ÖDEV:
   3.satirdaki 1. ve 2. sutun bilgilerini yazdiriniz. //--> position()>=1 and position()<=2

    */