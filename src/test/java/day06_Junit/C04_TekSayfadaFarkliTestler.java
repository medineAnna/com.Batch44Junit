package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

    WebDriver driver;
    @Test
    public void test01(){
        //amazon sayfasindan Nutella icin arama yapip, sonuc yazisinin nutella icerdigini test edelim
    }

    @Test
    public void test02(){
        //amazon sayfasinda java icin arama yapip sonuc yazisinin java icerdigini test edelim

    }

    @Test
    public void test03(){
        //amazon sayfasibdab ali icin arama yapip sonuc yazisinin ali icerdigini test edelim
    }

    @Before
    public void ayarlarDuzenle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }

    @After
    public void ortaligiTopla(){
        driver.close();
    }
}
