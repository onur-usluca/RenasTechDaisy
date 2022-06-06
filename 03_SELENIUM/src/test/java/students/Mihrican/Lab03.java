package students.Mihrican;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lab03 {

   // 1. Open Chrome browser
   // 2. Go to https://demo.guru99.com/test/radio.html
   // 3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
   // 4. Click to checkbox3
   // 5. Verify checkbox3 is selected

    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" https://demo.guru99.com/test/radio.html");
        WebElement checkbox1= driver.findElement(By.xpath("//input[@value='checkbox1']"));
        if(!checkbox1.isSelected()) {
            System.out.println("checkbox1 verification passed");
        }
        else {
            System.out.println("checkbox1 verification failed");}
        WebElement checkbox2= driver.findElement(By.xpath("//input[@value='checkbox2']"));
        checkbox2.click();
        if(checkbox2.isSelected()) {
            System.out.println("checkbox2 verification passed");
        }
        else {
            System.out.println("checkbox2 verification failed");}
        driver.quit();

    }
}

