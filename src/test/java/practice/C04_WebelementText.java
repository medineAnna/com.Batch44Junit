package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebelementText {
    /*
    ...Exercise4...
    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
    sonuc sayisini yazdiriniz
    cikan ilk urune tiklayiniz
    sepete ekleyiniz
    sepetime git e tiklayiniz
    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    Alisverisi tamamlayiniz
    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz
*/
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");

        driver.findElement(By.id("search-input")).sendKeys("Oppo" + Keys.ENTER);
        System.out.println("Sonuc Yazisi: " + driver.findElement(By.className("plp-info")).getText());//sonuc yazi

        JavascriptExecutor jss=(JavascriptExecutor) driver;//asagi kaydirir 200 pixel
        jss.executeScript("scrollBy(0,200)");

        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        System.out.println("Siparis Ozeti Yazi: " + driver.findElement(By.className("cart-sum-title")).getText());

        driver.findElement(By.xpath("//span[text()='Alışverişi Tamamla']")).click();

        System.out.println("Hosgeldiniz: " + driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")));

        driver.close();
    }

}
