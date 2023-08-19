package odevlerJunit;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C16_IframeOdev extends TestBase {

    //1-https://html.com/tags/iframe/ sayfaya gidiniz.
    // 2- Youtube videosunda play butonuna basınız

    @Test
    public void iframe() {

        //1-https://html.com/tags/iframe/ sayfaya gidiniz.
        driver.get("https://html.com/tags/iframe/");


        // 2- Youtube videosunda play butonuna basınız.
        driver.switchTo().frame(0);

        // 2- Youtube videosunda play butonuna basınız

        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();


    }
}
