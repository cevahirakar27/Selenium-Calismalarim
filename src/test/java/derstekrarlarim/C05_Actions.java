package derstekrarlarim;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

    //https://techproeducation.com a git
    //Sayfayi asagi dogru scroll yapalim
    //Sonra sayfanın üstüne doğru gidelim


    @Test
    public void test01() {

        //https://techproeducation.com a git.
        driver.get("https://techproeducation.com");

        //Sayfayi asagi dogru scroll yapalim.
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

        //Sonra sayfanın üstüne doğru gidelim.
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }
}
