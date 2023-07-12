package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KeyActions {
    public void waitFor(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/key_presses";


    @BeforeMethod
    public void setUp(){
        //open page
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void testInput() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"target\"]"));
        inputField.click();
        new Actions(driver).sendKeys(Keys.SPACE).perform();
        waitFor(2000);

        WebElement result = driver.findElement(By.xpath("//*[@id=\"result\"]"));


        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("You entered: SPACE"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        //close browser
        driver.close();
    }
}
