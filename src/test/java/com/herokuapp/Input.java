package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Input {
    @Test
    public void inputTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/inputs";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement input = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
        input.click();
        input.sendKeys("1234567890");
        input.clear();
        //System.out.println(input.getText());

        Assert.assertTrue(input.isDisplayed());

        //Assert.assertTrue(input.getText().contains("1234567890"));


        //add number to input
        //verify input value
    }
}
