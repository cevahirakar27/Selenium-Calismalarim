package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan “Account & Lists” menüsüne git
    //“Account” secenegine tikka
    //Acilan sayfanin Title in “Your Account” icerdigini dogrula


    @Test
    public void test01() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        WebElement accOuntLists = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accOuntLists).perform();


        //“Account” secenegine tikka
        driver.findElement(By.xpath("//*[text()='Account']")).click();
        bekle(1);

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula.
        String actualTitle = driver.getTitle();
        String expectedBaslik ="Your Account";
        Assert.assertTrue(actualTitle.contains(expectedBaslik));
    }
}
