package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {

    //bluerentalCar sitesine gidelim
    //Login butonuna basalim
    //Excel dosyasındaki herhangi bir kullanıcı ile login olalim
    //Login olduğumuzu doğrulayalım

    @Test
    public void test01() throws IOException {

        //BlurentalCar sitesine gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalim.
        driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
        bekle(1);


        //Excel dosyasındaki herhangi bir kullanıcı ile login olalim.
        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String userName = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("customer_info").getRow(1).getCell(1).toString();
        driver.findElement(By.xpath("//*[@id='formBasicEmail']")).sendKeys(userName, Keys.TAB
        ,password,Keys.ENTER);




        //Login olduğumuzu doğrulayalım.
          driver.findElement(By.xpath("//*[@id='dropdown-basic-button']")).click();
          bekle(2);

          //sonra profile basıcak
        driver.findElement(By.xpath("//*[.='Profile']")).click();
        bekle(2);

        //email in locate ni alalim.
        String emailText = driver.findElement(By.xpath("//em")).getText();
        Assert.assertEquals(userName,emailText);


        driver.quit();
    }
}
