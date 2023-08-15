package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tüm class dan once tek bir sefer calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her methoddan önce 1 kez calisir.");

    }

    @Test
    public void test01() {
        System.out.println("test 01 calisti");

    }

    @Test
    public void test02() {
        System.out.println("test 02 calisti");

    }

    @Test
    public void test03() {
        System.out.println("test 03 calisti");
    }

    @Test
    public void test04() {
        System.out.println("test 04 calisti");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her methoddan sonra 1 kez calişir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("tum classlardan sonra 1kez calisir.");
    }

}
