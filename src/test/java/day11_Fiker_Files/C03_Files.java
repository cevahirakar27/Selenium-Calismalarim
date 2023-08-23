package day11_Fiker_Files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Files {

    @Test
    public void test01() {


     //   String dosyaYolu = "C:\\Users\\DELL\\Desktop\\B171.txt";

        //"C:\Users\DELL\Desktop\B171.txt"
        String farkliYol = System.getProperty("user.home");
        System.out.println("farkliYol = " + farkliYol);  //    C:\Users\DELL

       String ortakYol = "/Desktop/B171.txt";


       String dosyaYolu = farkliYol+ortakYol;

       boolean dosyaVarmi = Files.exists(Paths.get(dosyaYolu));
        System.out.println("dosyaVarmi = " + dosyaVarmi);


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}