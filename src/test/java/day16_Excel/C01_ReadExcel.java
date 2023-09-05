package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {

    //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
//3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
//Kullanılan satır sayısın bulun
//Sayfadaki satır sayısını yazdırınız
//Ülke-Başkent şeklinde verileri yazdırın
    @Test
    public void test01() throws IOException {

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın.
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin.
       String satır3Sutun1 =  workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satır3Sutun1);
        Assert.assertEquals("France",satır3Sutun1);

        //Kullanılan satır sayısını bulun
        System.out.println("Kullanılan satır " +workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        // ici dolu olan satırların saayısı


       //Sayfadaki satır sayısını yazdırınız.
        System.out.println("satır sayısı " +workbook.getSheet("Sheet1").getLastRowNum());  // son satıra kadar sayısı

        /*
        getPhysicalNumberOfRows() indexi "1" dan alır dolu olan hücreleri sayarak satır sayısını verir
        getLastRowNum() en son kullanılan hücreye kadar dolu veya bos butun satırları sayar index "0" dan baslar.

         */
        
        //Ülke-Başkent şeklinde verileri yazdırın.
        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            for (int j = 0; j <workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells() ; j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
                /*
                getPhysicalNumberOfCells() kullanılan sutun sayısını verir.kullanılan sutun sayısını alabilmek icin
                önce satır sayısını belirtiriz dolayısıyla o satırdaki kullanılan o hücre sayısını verir.
                 */
            }
            System.out.println();
        }
        
    }

    @Test
    public void test02() throws IOException {
        //Ülke-Başkent şeklinde verileri yazdırın.
        //maple cozelim.

        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        Map<String,String>ulkeBaskent = new LinkedHashMap<>();
        String ulke ="";
        String sehir = "";

        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            sehir= workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");

        }
        System.out.println(ulkeBaskent);
    }
}
