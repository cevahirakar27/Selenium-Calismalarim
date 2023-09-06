package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {

        /*
    Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
    (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
      */

  String dosyaYolu = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue(712816);
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(2161000);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(8982000);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(5663000);

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
         fos.close();
         workbook.close();

    }

}
