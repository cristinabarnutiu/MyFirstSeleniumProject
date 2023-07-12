package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWithParameters {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/login";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browsername){
        //open page
        switch(browsername){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
        }

        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"user","pass","msg"})
    @Test
    public void loginTestWithParameters(String username, String password, String message){

        //enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        //enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        //click login
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //verificare
        WebElement alert = driver.findElement(By.id("flash"));
        Assert.assertTrue(alert.getText().contains(message));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        //close browser
        driver.close();
    }
}
