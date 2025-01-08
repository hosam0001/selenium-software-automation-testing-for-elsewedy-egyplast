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

public class Register {

    Assertion assertion = new Assertion() ;
    WebDriver driver;

    WebElement first_name;
    WebElement Last_name;
    WebElement email;
    WebElement password;
    WebElement confirm_Password;
    WebElement Home_Button;
    WebElement Login_Button;
    WebElement Signin_Button;
    String Register = "https://elsewedy123.github.io/Egyplast/index.html";


    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void beforeMethod(){
        driver.navigate().to(Register);
        driver.findElement(By.className("homeheader-register")).click();
        first_name = driver.findElement(By.id("fname"));
        Last_name = driver.findElement(By.id("lname"));
        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.id("password"));
        confirm_Password = driver.findElement(By.id("cpassword"));
        Signin_Button = driver.findElement(By.id("reg_button"));
        Home_Button =driver.findElement(By.className("loginheader-login"));
    }


    @Test
    void Go_to_login_from_Register_page (){
        Login_Button.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Login - Egyplast Website";
        assertion.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Test
    void Go_to_home_page_from_Register_page (){
        Home_Button.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Egyplast Website";
        assertion.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Test
    void enter_invalid_email (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamldfl;");
        password .sendKeys("P@ssw0rd123");
        confirm_Password .sendKeys("P@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("email_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("email_error")).getText(), "invalid email");

    }

    @Test
    void enter_password_less_than_8_characters (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("hos@123");
        confirm_Password .sendKeys("P@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "password is less than 8 characters");
    }


    @Test
    void Leave_password_field_blank (){

        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("");
        confirm_Password .sendKeys("P@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "Password is empty");

    }

    @Test
    void Leave_email_field_blank (){

        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("");
        password .sendKeys("P@ssw0rd123");
        confirm_Password .sendKeys("P@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("email_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("email_error")).getText(), "Email is empty");
    }

    @Test
    void enter_password_without_upper_case_characters (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("p@ssw0rd123");
        confirm_Password .sendKeys("p@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "password doesnot contain Upercase");
    }

    @Test
    void enter_password_without_lowercase_characters (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("HOSAM@123");
        confirm_Password .sendKeys("HOSAM@123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "password doesnot contain Lowercase");
    }

    @Test
    void enter_password_without_number (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("P@ssw0rd");
        confirm_Password .sendKeys("P@ssw0rd");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "password doesnot contain number");
    }

    @Test
    void enter_password_without_special_character (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("passw0rd123");
        confirm_Password .sendKeys("passw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("password_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("password_error")).getText(), "password without special character");
    }

    @Test
    void Leave_confirm_password_field_blank (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("p@ssw0rd123");
        confirm_Password .sendKeys("");
        Signin_Button.click();
        //results
        assertion.assertTrue(driver.findElement(By.id("cpassword_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("cpassword_error")).getText(), "Passwords is empty");
    }

    @Test
    void enter_different_confirm_password (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("p@ssw0rd123");
        confirm_Password .sendKeys("P@ssw0rd");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("cpassword_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("cpassword_error")).getText(), "confirm Password is incorrect");
    }

    @Test
    void Leave_first_name_field_blank (){
        first_name .sendKeys("");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("p@ssw0rd123");
        confirm_Password .sendKeys("p@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("fname_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("fname_error")).getText(), "first name is empty");
    }
    @Test
    void Leave_last_name_field_blank (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("p@ssw0rd123");
        confirm_Password .sendKeys("p@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("lname_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("lname_error")).getText(), "last name is empty");
    }

    @Test
    void enter_number_in_first_name (){
        first_name .sendKeys("47888");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("p@ssw0rd123");
        confirm_Password .sendKeys("p@ssw0rd123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("fname_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("fname_error")).getText(), "first name is invalid");
    }

    @Test
    void enter_number_in_last_name (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("85285");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("Passwrd@123");
        confirm_Password .sendKeys("Passwrd@123");
        Signin_Button.click();

        assertion.assertTrue(driver.findElement(By.id("lname_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("lname_error")).getText(), "last name is invalid");
    }

    @Test
    void enter_valid_data (){
        first_name .sendKeys("Hosam");
        Last_name .sendKeys("Ahmed");
        email .sendKeys("hosamamkg.1900@gmail.com");
        password .sendKeys("Passwrd@123");
        confirm_Password .sendKeys("Passwrd@123");
        Signin_Button.click();
        Alert alert= driver.switchTo().alert();
        String successMessage = alert.getText();
        assertion.assertEquals(successMessage,"User Registered Successfully");
    }


    @AfterTest
    void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}