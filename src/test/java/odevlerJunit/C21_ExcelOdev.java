package odevlerJunit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C21_ExcelOdev {

    //-1.satirdaki 2.hucreye gidelim ve yazdiralim
    //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
    //-Satir sayisini bulalim
    //-Fiziki olarak kullanilan satir sayisini bulun
    //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim


    @Test
    public void test01() throws IOException {

        //-1.satirdaki 2.hucreye gidelim ve yazdiralim.
        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim.
        String satir1Hucre2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(satir1Hucre2);

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim.
        String satir2Hucre4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println(satir2Hucre4);  //Kabil

        //-Satir sayisini bulalim.
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(satirSayisi);  //190

        //-Fiziki olarak kullanilan satir sayisini bulun.
      int kullanilan =  workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println(kullanilan);  //191

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim.
        Map<String,String> ulkeBaskentIngilizce = new LinkedHashMap<>();

        for (int i = 0; i <workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
                String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String baskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeBaskentIngilizce.put(ulke,baskent+"\n");


        }
        System.out.println(ulkeBaskentIngilizce);

    }
}
