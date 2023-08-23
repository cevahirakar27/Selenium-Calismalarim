package derstekrarlarim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void name() {

        driver.get("https://www.amazon.com");
        driver.navigate().refresh();

        String ilkSayfaWindowHandle = driver.getWindowHandle();

        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select = new Select(ddm);
        select.selectByIndex(5);
        bekle(3);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        String ikinciSayfaHandle = driver.getWindowHandle();
        driver.navigate().refresh();
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        bekle(1);
        driver.switchTo().window(ilkSayfaWindowHandle);
            bekle(1);
        driver.switchTo().window(ikinciSayfaHandle);

    }
}
