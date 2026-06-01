import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleTest
{
    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.google.com/?zx=1779960741421");
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(Duration.ofMillis(2000));
        driver.navigate().to("https://www.saucedemo.com/");
        System.out.println("Page Title is: " + driver.getTitle());
        driver.manage().window().maximize();
        Thread.sleep(Duration.ofMillis(5000));
        driver.manage().window().minimize();
        Thread.sleep(Duration.ofMillis(5000));
        driver.quit();
    }
}
