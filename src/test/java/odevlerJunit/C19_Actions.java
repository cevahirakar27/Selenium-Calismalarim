package odevlerJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C19_Actions extends TestBase {

    //https://jqueryui.com/droppable/ adresine gidelim.
    //Drag me to my target webelementini Drop here webelementi üzerine bıkalım.
    // drag web elementinin drop web elementinin uzerine birakildigini test edin.


    @Test
    public void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim.
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım.
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

        // drag web elementinin drop web elementinin uzerine birakildigini test edin.
        WebElement dropped = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals("Dropped!",dropped.getText());


    }
}
