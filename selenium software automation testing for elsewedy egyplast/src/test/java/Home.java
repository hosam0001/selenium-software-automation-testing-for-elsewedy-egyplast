import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import javax.swing.*;

public class Home {
    Assertion assertion = new Assertion() ;
    WebDriver driver;

    WebElement Login_Button;
    WebElement Home_Button;
    WebElement Register_Button;
    WebElement PVC_COMPOUND;
    WebElement POLYPROPYLENE_FIBER;
    WebElement SPECIAL_COMPOUNDS;

    String home = "https://elsewedy123.github.io/Egyplast/index.html";
    @BeforeTest
    void setup(){

        driver = new ChromeDriver();
    }
    @BeforeMethod
    void beforeMethod(){
        driver.navigate().to(home);
        Login_Button = driver.findElement(By.className("homeheader-login1"));
        Home_Button =driver.findElement(By.className("homeheader-login"));
        Register_Button = driver.findElement(By.className("homeheader-register"));
        PVC_COMPOUND =driver.findElement(By.className("home-button"));
        POLYPROPYLENE_FIBER = driver.findElement(By.className("home-button1"));
        SPECIAL_COMPOUNDS =driver.findElement(By.className("home-button2"));
    }

    @Test

    void Navigate_to_home_page(){
        Actions actions = new Actions(driver);
        actions.moveToElement(Home_Button).perform();
        Home_Button.click();
        String ActualTittle = driver.getTitle();
        String ExpectedTitle = "Egyplast Website";
        assertion.assertEquals(ActualTittle,ExpectedTitle);
    }

    @Test
    void proceed_to_the_login_page_from_home_page(){
        Actions actions = new Actions(driver);
        actions.moveToElement(Login_Button).perform();
        Login_Button.click();
        String ActualTittle = driver.getTitle();
        String ExpectedTitle = "Login - Egyplast Website";
        assertion.assertEquals(ActualTittle,ExpectedTitle);
    }

    @Test
    void proceed_to_the_Polypropylene_fiber_from_home_page(){
        Actions actions = new Actions(driver);
        actions.moveToElement(POLYPROPYLENE_FIBER).perform();
        POLYPROPYLENE_FIBER.click();
        String ActualTittle = driver.getTitle();
        String ExpectedTitle = "PP-Fiber - Egyplast Website";
        assertion.assertEquals(ActualTittle,ExpectedTitle);

    }

    @Test
    void proceed_to_the_PVC_compound_from_home_page(){

        Actions actions = new Actions(driver);
        actions.moveToElement(PVC_COMPOUND).perform();
        PVC_COMPOUND.click();
        String ActualTittle = driver.getTitle();
        String ExpectedTitle = "PVC-Compound - Egyplast Website";
        assertion.assertEquals(ActualTittle,ExpectedTitle);

    }

    @Test
    void proceed_to_the_register_page_from_home_page(){

        Actions actions = new Actions(driver);
        actions.moveToElement(Register_Button).perform();
        Register_Button.click();
        String ActualTittle = driver.getTitle();
        String ExpectedTitle = "Sign-Up - Egyplast Website";
        assertion.assertEquals(ActualTittle,ExpectedTitle);

    }

    @Test
    void proceed_to_the_Special_compounds_from_home_page(){
        throw new SkipException("Skipped becouse navigation button does not work");

    }




    @AfterTest
    void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}