package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
         /*1) Bir class oluşturun: BestBuyAssertions
          2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
           ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
           ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
		   ○ logoTest => BestBuy logosunun görüntülendigini test edin
		   ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin */

        driver.get("https://www.bestbuy.com/");

        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertEquals("Lutfen Test degerlerini gozden gecirin..",expectedURL,actualURL);

        String actualTitle=driver.getTitle();
        String istenmeyenKelime="Rest";
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
        System.out.println("Bu satir calismaz..");

        WebElement logoElement=driver.findElement(By.xpath("//img[@alt='Best Buy Logo']"));
        Assert.assertTrue("Logo gorunmuyor", logoElement.isDisplayed());

        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francais.isDisplayed());
    }

    @After
    public void teardown(){
        //driver.close();
    }
}
