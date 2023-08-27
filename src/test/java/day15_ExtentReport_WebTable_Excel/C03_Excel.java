package day15_ExtentReport_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel {


    @Test
    public void test01() throws IOException {

        /*
        Eger projemizde excel dosyasindan veri almak istiyorsak mvnrepository den arama cubuguna poi yazarak apache poi ve poi_ooxml
        kutuphanesini ekleriz.her iki dependyce nin versionlari ayni olmali




         */

        //1) projemize resources package altina koydugumuz excel dosyamizin yolunu aliriz.
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        // 2) dsoyayi okuyabilmemiz icin akisa almamiz gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3) Java ortaminda bir excel dosyasi olusturabilmek icin
        Workbook workbook= WorkbookFactory.create(fis);

        //4) olusturdugumuz excel dosyasina sayfa secmemiz gerekir.
        Sheet sheet= workbook.getSheet("Sheet1");

        //5) Belirttigimiz sayfadaki satir bilgisini secmemiz gerekir.
        Row row = sheet.getRow(0);  //index 0 dan baslar.

        //6) Belirttigimz satirdaki hucre bilgisin secmemiz gerekir
        Cell cell= row.getCell(0);


        //sout icindeki cell bilgisini yazdirdigimizda 1.satir 1.hucredeki bilgiyi verir.
        System.out.println(cell);

        /*
       Excel acikken calistirirsak hata alabiliriz
       Excel icinde degisiklik yaparsek cikarken kaydetme dememiz
       gerekir yoksa dosya hata verebilir.
      */
    }
}
