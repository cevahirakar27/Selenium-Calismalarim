package odevlerJunit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C20_Actions extends TestBase {
    //ODEV

        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım


    @Test
    public void test01() {

        //google sayfasına gidelim.
        driver.get("https://www.google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın.
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#APjFqb"));
        aramaKutusu.sendKeys(Keys.SHIFT,"s",Keys.SHIFT,"elenium",Keys.ENTER);


        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim.
        WebElement aramaKutusu2 = driver.findElement(By.cssSelector("#APjFqb"));  // bayatlama oldugu icin tekrar locate aldim
        Actions actions=new Actions(driver);
        actions.doubleClick(aramaKutusu2).perform();
       bekle(1);



       // aramaKutusu.sendKeys(Keys.CONTROL,"a");
        aramaKutusu2.sendKeys(Keys.CONTROL,"x");
        bekle(1);



        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım.
        driver.navigate().back();
        bekle(1);
        aramaKutusu.sendKeys(Keys.CONTROL,"v"+Keys.ENTER);  // buradaki 1. aldigim locate

    }
}
