package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    //Inheriting the BaseTest Class
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    } @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        WebElement registerText = driver.findElement(By.xpath("//h1[text()='Register']"));
        Assert.assertEquals(registerText.getText(),"Register");

    } @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']"))
                .sendKeys("Mahi");
        driver.findElement(By.xpath("//input[@id='LastName']"))
                .sendKeys("Thakur");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))
                .sendKeys("4");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))
                .sendKeys("January");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))
                .sendKeys("2012");
        driver.findElement(By.xpath("//input[@id='Email']"))
                .sendKeys("mehekthakur@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']"))
                .sendKeys("Mv12345");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"))
                .sendKeys("Mv12345");
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        String successMessage = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        Assert.assertEquals(successMessage, "Your registration completed");
    }


    @After
   public void closeBrowser() {//close the browser
      driver.close();
    }
}