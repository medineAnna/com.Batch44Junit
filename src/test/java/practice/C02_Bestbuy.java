package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_Bestbuy {
    static WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeClass
    public void testOncesi(){

        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void testTitle(){
        String title=driver.getTitle();
        boolean iceriyormu=title.contains("Best");
        Assert.assertTrue("Title test kelimesi icermiyor",iceriyormu);
         /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,
    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    Ayrica Relative Locator kullanarak;
    logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
     mexicoLinkTest => L inkin gorunutulenip goruntulenmedigini dogrulayin
 */
    }
    @Test
    public void logoTest(){
        WebElement helloElement=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloElement));
        //boolean logoGorunuyormu= logo.isDisplayed();
        // Assert.assertTrue(logoGorunuyormu);
        Assert.assertTrue(logo.isDisplayed() );
    }
    @Test
    public void linkTest(){
        WebElement usLink=driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLink=driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }
    @AfterClass
    public static void treadDown(){
        driver.close();
    }
}
