import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class NewAssignment {
    static void main() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        String name = "Smeta";
        String email = "Smeta@gmail.com";

        driver.findElement(By.linkText("Signup / Login")).click();
        String text=  driver.findElement(By.xpath("//div[@class='signup-form']//h2")).getText();
        System.out.println(text);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Smeta");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("Smeta@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        String ExpectName= driver.findElement(By.id("name")).getAttribute("name");
        String ExpectEmail=driver.findElement(By.id("email")).getAttribute("email");

        if(name.equals(ExpectName))
        {
            System.out.println("Name is correct");
        }
        else {
            System.out.println("Name is incorrect");
        }

        if(email.equals(ExpectEmail))
        {
            System.out.println("Email is correct");
        }
        else {
            System.out.println("Email is incorrect");
        }

        Thread.sleep(6000);


        //Enter Account Info

        String AccInfo = driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
        System.out.println(AccInfo);


        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc@145");

        //DOB
       WebElement DAY= driver.findElement(By.id("days"));
       WebElement MONTH= driver.findElement(By.id("months"));
       WebElement YEAR= driver.findElement(By.id("years"));

       Select NewDay= new Select(DAY);
       Select NewMonth = new Select(MONTH);
       Select NewYear = new Select(YEAR);

       NewDay.selectByValue("30");
       NewMonth.selectByValue("5");
       NewYear.selectByValue("1999");


       //Checkbox

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Number of Checkboxes: "+checkboxes.size());
        WebElement checkBox_1 = checkboxes.get(0);
        if(!checkBox_1.isSelected()){
            checkBox_1.click();
        }

        WebElement checkBox_2 = checkboxes.get(1);
        if(!checkBox_2.isSelected()){
            checkBox_2.click();
        }

        // Address Info
        driver.findElement(By.id("first_name")).sendKeys("Smita");
        driver.findElement(By.id("last_name")).sendKeys("Patil");
        driver.findElement(By.id("company")).sendKeys("Infy");
        driver.findElement(By.id("address1")).sendKeys("abc Pune");
        driver.findElement(By.id("address2")).sendKeys("xyz Pune");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("Maharashtra");
        driver.findElement(By.id("city")).sendKeys("Pune");
        driver.findElement(By.id("zipcode")).sendKeys("356772");
        driver.findElement(By.id("mobile_number")).sendKeys("28393920202");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();




    // Account Created
        String Acc_Create = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(Acc_Create);

        String WelCome = driver.findElement(By.xpath("//p[@style='font-size: 20px; font-family: garamond;'][1]")).getText();
        System.out.println(WelCome);

        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        //LoggedIn User
        String LoggedInUser = driver.findElement(By.xpath("//a[text()=' Logged in as ']")).getText();
        System.out.println(LoggedInUser);

        if(name.equals(LoggedInUser))
        {
            System.out.println("correct user is logged in");
        }
        else {
            System.out.println("incorrect user is logged in");
        }

        //LogOut
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        System.out.println("Logout successfully");








        driver.quit();
    }
}
