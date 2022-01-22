package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YouTubeAssertions {

   static WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath(""));

    }
    @Test
    public void titleTest(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        // Assert.assertTrue(actualTitle.equals(expectedTitle));
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void imageTest(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogosu= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(youtubeLogosu.isDisplayed());
    }
    @Test
    public void searchBox(){
        //     ○ searchBox 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='search_query']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitle(){
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
