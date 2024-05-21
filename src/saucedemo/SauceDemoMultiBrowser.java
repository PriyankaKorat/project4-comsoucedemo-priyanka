package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SauceDemoMultiBrowser {
    static WebDriver driver;
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        //Open base url
        driver.get(baseUrl);
        //Put implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("The title of the page is :" + driver.getTitle());
        //Print the current url
        System.out.println("The current url is :" + driver.getCurrentUrl());
        //Print the page source
        System.out.println("The page source is :" + driver.getPageSource());
        //Enter the email to field
        WebElement email = driver.findElement(By.id("user-name"));
        email.sendKeys("standard_user");
        //Enter password to field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.id("login-button")).click();
        //Print the current url
        System.out.println("The current url is :" + driver.getCurrentUrl());
        //Navigate to baseurl
        driver.get(baseUrl);
        //Refresh the page
        driver.navigate().refresh();
        //close browser
        driver.quit();
    }
}