package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ButtonCheck {
    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        
        createButtonMethod(driver,100);
        deleteButtonMethod(driver,60);
    }

    private static void createButtonMethod(WebDriver driver, int creat) {
        WebElement addButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int j = 0; j < creat; j++) {
            addButton.click();
        }
    }

    private static void deleteButtonMethod(WebDriver driver, int delete) {
        List<WebElement> elementList=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeBeforeDelete=elementList.size();

        List<WebElement> buttonDeleteElementList=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sayac=0;

        for (WebElement each:buttonDeleteElementList) {
            sayac++;
            if(sayac>delete){
                break;
            }
            each.click();
        }
        List<WebElement> elementsAfter=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeAfterDelete=elementsAfter.size();

        if((sizeBeforeDelete-delete)==sizeAfterDelete){
            System.out.println("sizeAfterDelete = " + sizeAfterDelete);
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }
    }
}
