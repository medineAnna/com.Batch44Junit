package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {
        /* 1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com");

        WebElement usernameKutusu=driver.findElement(By.id("user-name"));
        usernameKutusu.sendKeys("standard_user");

        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement ilkUrunElementIsmi= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi=ilkUrunElementIsmi.getText();
        ilkUrunElementIsmi.click();

        //6. Add to Cart butonuna basin

        WebElement addToCartButonu= driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButonu.click();

        //7. Alisveris sepetine tiklayin

        WebElement alisverisSepetiButonu= driver.findElement(By.className("shopping_cart_link"));
        alisverisSepetiButonu.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        WebElement kontrolKismi= driver.findElement(By.className("inventory_item_name"));
        String sepettekiUrunIsmi=kontrolKismi.getText();

        if (sepettekiUrunIsmi.equals(ilkUrunIsmi)){
            System.out.println("Urun basarili sekilde sepete eklendi test PASS");
        }else {
            System.out.println("Urun basarili sekilde sepete eklenmedi test FAILED");
        }

        //9. Sayfayi kapatin

        driver.close();


    }
}
