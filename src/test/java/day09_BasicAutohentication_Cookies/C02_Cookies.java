package day09_BasicAutohentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {

    @Test
    public void test01() {

        /*
        cookie denildiginde aklimiza manage() gelmeli.
         */

        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-tum cookie'leri listeleyin.
        Set<Cookie> cookieSet = driver.manage().getCookies();  //tum cooki leri cooki sete attik.
        int sayac = 1;
        for (Cookie w: cookieSet){
            System.out.println(sayac+" . cookie :" +w);
            System.out.println(sayac +" . cookie Name :" +w.getName());
            System.out.println(sayac +  " . cookie Value : " +w.getValue());
            sayac++;

        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin.
        System.out.println("Cookilerin sayisi : "+cookieSet.size()); //7
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin "USD" oldugunu test edin.
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",actualCookieValue);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        System.out.println("**********************************");
        cookieSet = driver.manage().getCookies();  //ekleme yaptiktan sonra cookisete tekrar tum cookileri gonderdik.
        int sayac2 = 1;
        for (Cookie w: cookieSet){
            System.out.println(sayac+" . cookie :" +w);
            System.out.println(sayac +" . cookie Name :" +w.getName());
            System.out.println(sayac +  " . cookie Value : " +w.getValue());
            sayac++;

        }
        System.out.println(cookieSet.size());  //8


        //6-eklediginiz cookie'nin sayfaya eklendigini test et.
      //  Assert.assertTrue(cookieSet.contains(driver.manage().getCookies())); burda hata var bi bak

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        cookieSet = driver.manage().getCookies();
        int sayac3 = 1;
        for (Cookie w: cookieSet){
            System.out.println(sayac+" . cookie :" +w);
            System.out.println(sayac +" . cookie Name :" +w.getName());
            System.out.println(sayac +  " . cookie Value : " +w.getValue());
            sayac++;

        }
        System.out.println(cookieSet.size());  //7
        Assert.assertFalse(cookieSet.contains(driver.manage().getCookieNamed("skin"))); //silinice icermeyecek o yuzden false.

        //8-tum cookie'leri silin ve silindigini test edin.
        driver.manage().deleteAllCookies();
       cookieSet=driver.manage().getCookies();
       Assert.assertTrue(cookieSet.isEmpty());
        System.out.println(cookieSet.size());  //0


    }
}
