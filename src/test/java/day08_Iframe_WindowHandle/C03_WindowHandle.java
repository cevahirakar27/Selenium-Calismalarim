package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {

    //Window 1'de https://www.techproeducation.com adresine gidiniz
//Başlığın "TechPro Education" olduğunu doğrulayın
//Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
//Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
//techproeducation sayfasına geçiniz:
//youtube sayfasına geçiniz:
//linkedIn sayfasına geçiniz:


    @Test
    public void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());


       //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW); // WindowType.WINDOW--> yeni pencere
                                                         //WindowType.TAB --> yeni sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(1);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(1);


         //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(1);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(1);

    }

    @Test
    public void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());


        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB); // WindowType.WINDOW--> yeni pencere
        //WindowType.TAB --> yeni sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(1);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(1);


        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(1);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(1);


    }

    @Test
    public void test03() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");


        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());


        //Window 2'de (yeni bir sekemede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB); // WindowType.WINDOW--> yeni pencere
        //WindowType.TAB --> yeni sekme acar
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekemede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

       List<String> pencereler = new ArrayList<>(driver.getWindowHandles()); // acilmis penceredeki butun handle degerlerini verir.
        /*
        yyukaridaki arrayList sayesinde acilmis olan tum pencereleri  getWindowsHandles methodu sayesinde alip index ile istedigimiz
        pencereye gecis yapariz.
         */

        bekle(1);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(0));

        bekle(1);


        //youtube sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(1));
        bekle(1);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(2));
        bekle(1);

    }

    @Test
    public void test04() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");


        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());


        //Window 2'de (yeni bir sekemede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB); // WindowType.WINDOW--> yeni pencere
        //WindowType.TAB --> yeni sekme acar
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekemede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

        List<String> pencereler = new ArrayList<>(driver.getWindowHandles()); // acilmis penceredeki butun handle degerlerini verir.
        /*
        yyukaridaki arrayList sayesinde acilmis olan tum pencereleri  getWindowsHandles methodu sayesinde alip index ile istedigimiz
        pencereye gecis yapariz.
         */

        bekle(1);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(0));
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString()); // bu sekilde de gecis yapilabilir

        bekle(1);


        //youtube sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(1));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(1);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(pencereler.get(2));
        bekle(1);

    }


}
