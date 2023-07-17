package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class StudentRegistrationForm {
    WebDriver driver;
    String url = "https://demoqa.com/automation-practice-form";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void fillInStudentRegistrationForm(){
        //enter firstname
        WebElement firstnameInput = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstnameInput.sendKeys("Jon");

        //enter lastname
        WebElement lastnameInput = driver.findElement(By.cssSelector("#lastName.mr-sm-2"));
        lastnameInput.sendKeys("Doe");

        //enter email
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("jon.doe@email.com");

        //select gender
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        maleRadioButton.click();

        //add phone number
        WebElement phoneNumberInput = driver.findElement(By.cssSelector("input#userNumber"));
        phoneNumberInput.sendKeys("1234567890");

        //enter date of birth
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();

        //click on month drop-down
        WebElement monthSelector = driver.findElement(By.cssSelector("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--select > select"));
        monthSelector.click();
        //select month
        Select month = new Select(monthSelector);
        month.selectByVisibleText("July");

        //click on year drop-down
        WebElement yearSelector = driver.findElement(By.cssSelector("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--select > select"));
        yearSelector.click();
        //scroll and selecte year
        new Actions(driver)
                .scrollByAmount(0, 200)
                .perform();
        Select year = new Select(yearSelector);
        year.selectByVisibleText("2000");

        WebElement daySelector = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]"));
        daySelector.click();
        //WebElement daySelector = driver.findElement(By.cssSelector("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(4) > div.react-datepicker__day.react-datepicker__day--021"));
        //daySelector.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subjectInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subjectsInput")));
        subjectInput.click();
        subjectInput.sendKeys("Maths");
        subjectInput.sendKeys(Keys.ENTER);

        waitFor(3);

        //adding address
        //WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addressInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"currentAddress\"]")));
        addressInput.click();
        addressInput.sendKeys("123 Test Street");

        waitFor(3);

        //after adding the address, we move on to other elements using TAB and enter text using a sequence of sendKeys
        addressInput.sendKeys(Keys.TAB,"ncr",Keys.ENTER,Keys.TAB,"delhi", Keys.ENTER,Keys.TAB,Keys.ENTER);

        //WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

        //verification of the success modal display & content
        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertTrue(modal.isDisplayed());
        Assert.assertTrue(modal.getText().contains("Thanks for submitting the form"));

        //verification of the close modal button presence
        WebElement closeModal = driver.findElement(By.id("closeLargeModal"));
        Assert.assertTrue(closeModal.isDisplayed());

        //wait for 2 seconds then close the modal
        waitFor(2);
        closeModal.click();
    }

    @AfterMethod
    private void tearDown(){
    //  wait for 2 seconds then close the page
        waitFor(2);
        driver.close();
    }

    private void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
