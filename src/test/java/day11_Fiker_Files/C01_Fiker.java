package day11_Fiker_Files;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Fiker {

    @Test
    public void faker() {


        Faker faker = new Faker();
        //faker objesini kullanarak fake isim yazdiralim.
        System.out.println(faker.name().firstName());

        //faker objesini kullanarak fake soyisim yazdiralim.
        System.out.println(faker.name().lastName());

        //faker objesini kullanarak fake isim -soyisim yazdiralim.
        System.out.println(faker.name().fullName());

        //faker objesini kullanarak fake sehir yazdiralim.
        System.out.println(faker.address().city());

        //faker objesini kullanarak fake adress yazdiralim.
        System.out.println(faker.address().fullAddress());

        //faker objesini kullanarak fake email yazdiralim.
        System.out.println(faker.internet().emailAddress());

        //faker objesini kullanarak fake sayi yazdiralim.
        System.out.println(faker.number().digits(6));  //rastgele 6 haneli sayi.


    }
}
