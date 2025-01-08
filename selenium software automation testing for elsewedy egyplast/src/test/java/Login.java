import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import javax.swing.*;

public class Login {
    Actions actions;
    Assertion assertion=new Assertion();
    WebElement email;
    WebElement password;
    WebElement loginBtn;
    WebElement homeBtn;
    WebElement registerBtn;
    WebDriver driver;
    String home="https://elsewedy123.github.io/Egyplast/";
    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
        actions=new Actions(driver);
    }
    @BeforeMethod
    void beforeMethod(){
        driver.navigate().to(home);
        driver.findElement(By.className("homeheader-login1")).click();
        email=driver.findElement(By.id("login_email"));
        password=driver.findElement(By.id("login_password"));
        loginBtn=driver.findElement(By.id("login_button"));
        homeBtn=driver.findElement(By.className("loginheader-login"));
        registerBtn=driver.findElement(By.className("loginheader-register"));

    }


    @Test

    void Check_user_login_with_valid_email_and_password(){
        email.sendKeys("hosamamkg.1900@gmail.com");
        password.sendKeys("P@ssw0rd123");
        loginBtn.click();
        Alert alert = driver.switchTo().alert();
        String successMessage = alert.getText();
        assertion.assertEquals(successMessage,"welcom to your account");

    }

    @Test
    void Leave_the_field_of_email_is_blank(){
        email.sendKeys("");
        password.sendKeys("P@ssw0rd123");
        loginBtn.click();

        assertion.assertTrue(driver.findElement(By.id("email_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("email_error")).getText(), "Email not found");

    }

    @Test
    void Leave_the_field_of_password_is_blank(){
        email.sendKeys("hosamamkg.1900@gmail.com");
        password.sendKeys("");
        loginBtn.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "Password is not correct");
    }

    @Test
    void Navigate_to_home_page_from_login_page(){
        homeBtn.click();
        String aculeTitle = driver.getTitle();
        String ExupthionTitle = "Egyplast Website";
        assertion.assertEquals(aculeTitle,ExupthionTitle);

    }

    @Test
    void Navigate_to_register_page_from_login_page(){
        registerBtn.click();
        String aculeTitle = driver.getTitle();
        String ExupthionTitle = "Sign-Up - Egyplast Website";
        assertion.assertEquals(aculeTitle,ExupthionTitle);

    }

    @Test
    void Put_a_true_email_with_a_worn_password(){
        email.sendKeys("hosamamkg.1900@gmail.com");
        password.sendKeys("hosamwdwd");
        loginBtn.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "Password is not correct");
    }

    @Test
    void Put_an_email_that_dose_not_exist(){
        email.sendKeys("hiope.1900@gma.com");
        password.sendKeys("P@ssw0rd123");
        loginBtn.click();

        assertion.assertTrue(driver.findElement(By.id("email_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("email_error")).getText(), "email is not correct");
    }


    @AfterTest
    void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}