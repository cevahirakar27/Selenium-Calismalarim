package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {

    //https://techproeducation.com a git
    //Sayfayi asagi dogru scroll yapalim
    //Sonra sayfanın üstüne doğru gidelim


    @Test
    public void test01() {

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim.

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();  //1kere pagedown yaparsak 1 tik asagi kaydirir.
          bekle(2);

        //Sonra sayfanın üstüne doğru gidelim.
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        /*
    Sayfanın ortalarındaki bir webelementi locate etmek istediğimizde driver sayfayı açtığı zaman
    webelementi göremediği için bazen sayfayı az bir aşağıya doğru scroll yapmamız gerekebilir. Bunun
    için yukarıdaki örnekteki gibi Page_Down ile bunu gerçekleştirebiliriz.
    Sayfadaki bir webelementi locate ettiğimiz halde nosuchelementexception alıyorsak;
        1-Locate'i tekrar kontrol ederiz buna rağmen aynı hatayı alıyorsak;
        2-Webelementin iframe içinde olup olmadığına bakarız. Yine aynı hatayı alıyorsak;
        3-Driver webelementi göremiyordur, dolayısıyla actions class'ı kullanarak scroll yapıp
        elementin görünür olmasını sağlarız.
 */
    }

    @Test
    public void test02() {
        //sayfanin en altina scroll yapalim.
        driver.get("https://techproeducation.com");
        bekle(1);

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform(); //sayfanin en altina scroll yapar
        bekle(1);


        //sayfanin en ustune scroll yapalim
        actions.sendKeys(Keys.HOME).perform(); //sayfanin en ustune scroll yapar.
    }

    @Test
    public void test03() {

        //events e kadar gelelim
        driver.get("https://techproeducation.com");
        bekle(1);
        WebElement events = driver.findElement(By.xpath("(//*[text()='Events'])[2]"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(events).perform();
        bekle(1);
    }


}
