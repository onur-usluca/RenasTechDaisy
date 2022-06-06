package students.Mihrican;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lab06 {
  /*  ## Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
      ## Test Scenario:
      #### Go to the above URL.
      #### Get the current window’s handle and write to the console window. It must be the first window handle.
      #### Locate the “Visit W3Schools.com!” link and click it.
      #### Get all window handles and hold them in a list.
      #### Write to total window handle number to the console. It must be 2.
      #### Switch t the second window.
      #### Get the current window’s handle and write to the console window. It must be a second window handle.
      #### Check the upper left side logo in the second window.
      #### Go back (Switch) to the first window.
      #### Get the current window’s handle and write to the console window. It must be the first window handle.
      #### Check the See Run Button Text. It must contain “Run >” text.

   */

    @Test
    void tc1() {
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        String curWind = driver.getWindowHandle();
        System.out.println("current window handle is: " + curWind);

        WebElement w3SFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(w3SFrame);
        driver.findElement(By.xpath("//a[.='Visit W3Schools.com!']")).click();

        Set<String> allWindHandles = driver.getWindowHandles();
        List<String> windowsList = new ArrayList();

        System.out.println(allWindHandles.size() + " is the # of window handles");

        for (String newWin : allWindHandles) {
            windowsList.add(newWin);
            driver.switchTo().window(newWin);
        }

        WebDriver childWind2= driver.switchTo().window(windowsList.get(1));
        String childWind2Handle= childWind2.getWindowHandle();
        System.out.println("after switch the child window handle is: " +childWind2Handle );


        WebElement logoButton = driver.findElement(By.xpath("//i[@class='fa fa-logo']"));
        Assert.assertTrue(logoButton.isDisplayed(), "logo button not present on page");

        driver.switchTo().window(curWind);
        String presentWindHan = driver.getWindowHandle();
        System.out.println("current window handle is : " + presentWindHan);

        Assert.assertEquals(presentWindHan, curWind);

        WebElement runButton = driver.findElement(By.id("runbtn"));
        String runButtonTex = runButton.getText();
        System.out.println(runButtonTex);
        Assert.assertTrue(runButtonTex.contains("Run ❯"), "run button tex not match");

    }
}

