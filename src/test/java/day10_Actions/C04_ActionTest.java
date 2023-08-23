package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionTest extends TestBase {

    @Test
    public void actions() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");


      //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameindex(0);
        bekle(2);
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,drop).perform();
    }

    @Test
    public void actions1() {
     //2.yol
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");


        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameindex(0);
        bekle(2);
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(dragMe).//drag web elemnetini tut ve bekle.

                moveToElement(drop). //drag web elementini tutup drop web elementinin uzerine goturur
                release().  //web elementi serbest birakir
                perform();
    }

    @Test
    public void name() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");


        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        //drag i istedigimiz bi yere tasiyalim.
        frameindex(0);
        bekle(2);
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(dragMe).moveByOffset(105,90).release().perform();
    }


    // drag web elementinin drop web elementinin uzerine birakildigini test edin.
}
