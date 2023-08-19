package odevlerJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public  class C14_HandleDropDownOdev extends TestBase{

    //1.http://zero.webappsecurity.com/ Adresine gidin
//2.Sign in butonuna basin
//3.Login kutusuna “username” yazin
//4.Password kutusuna “password.” yazin
//5.Sign in tusuna basin(not: navigate.Back yapınız)
//6.Pay Bills sayfasina gidin
//7.“Purchase Foreign Currency” tusuna basin
//8.“Currency” drop down menusunden Eurozone’u secin
//9.“amount” kutusuna bir sayi girin
//10.“US Dollars” in secilmedigini test edin
//11.“Selected currency” butonunu secin
//12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
//13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.




    @Test
       public void test01() {
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


            //2.Sign in butonuna basin.
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        bekle(1);


        //3.Login kutusuna “username” yazin
        //4.Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username",
                Keys.TAB,"password",Keys.TAB,Keys.ENTER);
                bekle(2);

        //5.Sign in tusuna basin(not: navigate.Back yapınız).
        driver.navigate().back();
        bekle(1);


        //6.Pay Bills sayfasina gidin.Once ONLINE binkıng e tiklayin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        bekle(2);
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
        bekle(1);

        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        bekle(1);


        //8.“Currency” drop down menusunden Eurozone (euro) secin
        WebElement ddm = driver.findElement(By.cssSelector("#pc_currency"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");


        //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("#pc_amount")).sendKeys("5");


        //10.“U.S dollar (USD)” in secilmedigini test edin
        WebElement usDollars = driver.findElement(By.cssSelector("#pc_inDollars_true"));
        Assert.assertFalse(usDollars.isSelected());


        //11.“Selected currency” butonunu secin
        driver.findElement(By.cssSelector("#pc_inDollars_false")).click();
        bekle(1);


        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.cssSelector("#pc_calculate_costs")).click();
        bekle(1);
        driver.findElement(By.cssSelector("#purchase_cash")).click();
        bekle(1);





        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String expectedYazi ="Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedYazi,sonucYazisi.getText());

    }

    }