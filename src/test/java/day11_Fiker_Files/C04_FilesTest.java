package day11_Fiker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesTest extends TestBase {

    @Test
    public void test01() {


        // https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim.
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
        


        //"C:\Users\DELL\Downloads\b10 all test cases, code.docx"

        String farkliYol = System.getProperty("user.home");

        String ortakYol = "/Downloads/b10 all test cases, code.docx";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println("dosyaYolu = " + dosyaYolu);
       boolean  dosyaVarmi = Files.exists(Paths.get(dosyaYolu));
        System.out.println("dosyaVarmi = " + dosyaVarmi);


        //Dosyanın başarıyla indirilip indirilmediğini test edelim.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
