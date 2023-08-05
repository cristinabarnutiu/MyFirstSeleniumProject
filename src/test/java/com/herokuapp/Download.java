package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class Download {

    WebDriver driver;
   String downloadPath = "C:\\Users\\cristina\\Downloads\\upload.txt";


    @Test
    public void downloadTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/download";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement downloadLink = driver.findElement(By.linkText("upload.txt"));
        downloadLink.click();

        driver.get(downloadPath);
        Assert.assertFalse(downloadPath.isEmpty());





    }
}