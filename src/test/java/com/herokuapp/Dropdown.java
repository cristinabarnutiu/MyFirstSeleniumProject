package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown {
    @Test
    public void dropdownTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/dropdown";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select dropdownElement = new Select(dropdown);
        //dropdownElement.selectByValue("1");
        dropdownElement.selectByVisibleText("Option 1");
        WebElement option1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
        Assert.assertTrue(option1.isSelected());
        driver.close();
    }
    @Test
    public void dropdownTest2(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/dropdown";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select dropdownElement = new Select(dropdown);
        //dropdownElement.selectByValue("1");
        dropdownElement.selectByVisibleText("Option 2");
        WebElement option1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
        Assert.assertTrue(option1.isSelected());
        driver.close();
    }
}
