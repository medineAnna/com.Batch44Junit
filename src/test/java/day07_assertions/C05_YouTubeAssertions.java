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
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//tp-yt-paper-button[@aria-label='Agree to the use of cookies and other data for the purposes described']")).click();
    }
    @Test
    public void titleTesting() {
//    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String titleTest = driver.getTitle();
        String actualTitle = "YouTube";
        Assert.assertEquals(titleTest, actualTitle);
    }
    @Test
    public void imageTesting() {
//    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageElement=driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue("imageTesting FAILED",imageElement.isDisplayed());
    }
    @Test
    public void searchBoxTesting() {
//    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElement=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("searchBoxTesting FAILED",searchBoxElement.isEnabled());
    }
    @Test
    public void wrongTitleTest() {
//    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualYoutubeTitle=driver.getTitle();
        String expectedYoutubeTitle="Youtube";
        Assert.assertFalse("wrongTitleTest FAILED",actualYoutubeTitle.contains(expectedYoutubeTitle));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}