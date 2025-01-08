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

public class Contact {

    Actions actions;
    Assertion assertion = new Assertion() ;
    WebDriver driver;

    WebElement homebtn;
    WebElement loginbtn;
    WebElement registerbtn;
    WebElement name;
    WebElement email;
    WebElement phone;
    WebElement company;
    WebElement message;

    WebElement sendbtn;
    String Contact = "https://elsewedy123.github.io/Egyplast/contact.html";


    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @BeforeMethod
    void beforeMethod(){
        driver.navigate().to(Contact);
        homebtn = driver.findElement(By.className("homeheader-login"));
        loginbtn = driver.findElement(By.className("homeheader-login1"));
        registerbtn = driver.findElement(By.className("homeheader-register"));
        email = driver.findElement(By.id("email"));
        name = driver.findElement(By.id("name"));
        phone = driver.findElement(By.id("phone"));
        company = driver.findElement(By.id("company"));
        message =driver.findElement(By.id("message"));
        sendbtn = driver.findElement(By.className("app-component-button"));
    }

@Test
   void Leave_field_of_company_null(){
        name.sendKeys("Hosam");
        phone.sendKeys("01229335912");
        email.sendKeys("hoamamkg.1900@gmail.com");
        company.sendKeys("");
        message.sendKeys("Hello");
        sendbtn.click();
        assertion.assertTrue(driver.findElement(By.id("company_error")).isDisplayed());
        assertion.assertEquals(driver.findElement(By.id("company_error")).getText(),"Company is empty");

}

@Test
   void Leave_field_of_email_null(){
    name.sendKeys("Hosam");
    phone.sendKeys("01229335912");
    email.sendKeys("");
    company.sendKeys("Elsewedy");
    message.sendKeys("Hello");
    sendbtn.click();
    assertion.assertTrue(driver.findElement(By.id("email_error")).isDisplayed());
    assertion.assertEquals(driver.findElement(By.id("email_error")).getText(),"Email is empty");

}

@Test
   void Leave_field_of_message_null(){
    name.sendKeys("Hosam");
    phone.sendKeys("01229335912");
    email.sendKeys("hoamamkg.1900@gmail.com");
    company.sendKeys("Elsewedy");
    message.sendKeys("");
    sendbtn.click();
    assertion.assertTrue(driver.findElement(By.id("Message_error")).isDisplayed());
    assertion.assertEquals(driver.findElement(By.id("Message_error")).getText(),"Please enter your message");

}

@Test
   void Leave_field_of_name_null(){
    name.sendKeys("");
    phone.sendKeys("01229335912");
    email.sendKeys("hoamamkg.1900@gmail.com");
    company.sendKeys("Elsewedy");
    message.sendKeys("Hello");
    sendbtn.click();
    assertion.assertTrue(driver.findElement(By.id("name_error")).isDisplayed());
    assertion.assertEquals(driver.findElement(By.id("name_error")).getText(),"name is empty");

}

@Test
   void Leave_field_of_phone_number_null(){
    name.sendKeys("Hosam");
    phone.sendKeys("");
    email.sendKeys("hoamamkg.1900@gmail.com");
    company.sendKeys("Elsewedy");
    message.sendKeys("Hello");
    sendbtn.click();
    assertion.assertTrue(driver.findElement(By.id("phone_error")).isDisplayed());
    assertion.assertEquals(driver.findElement(By.id("phone_error")).getText(),"phone is empty");

    }

 @Test
   void put_number_in_the_field_of_name(){
     name.sendKeys("123");
     phone.sendKeys("01229335912");
     email.sendKeys("hoamamkg.1900@gmail.com");
     company.sendKeys("Elsewedy");
     message.sendKeys("Hello");
     sendbtn.click();
     assertion.assertTrue(driver.findElement(By.id("name_error")).isDisplayed());
     assertion.assertEquals(driver.findElement(By.id("name_error")).getText(),"enter letters please");
 }

 @Test
   void put_wrong_email_address(){
     name.sendKeys("Hosam");
     phone.sendKeys("01229335912");
     email.sendKeys("hoamamkgjfie");
     company.sendKeys("Elsewedy");
     message.sendKeys("Hello");
     sendbtn.click();
     assertion.assertTrue(driver.findElement(By.id("email_error")).isDisplayed());
     assertion.assertEquals(driver.findElement(By.id("email_error")).getText(),"email is invalid");
 }

 @Test
   void Put_wrong_number_phone_in_the_field(){
     name.sendKeys("Hosam");
     phone.sendKeys("012293fef");
     email.sendKeys("hoamamkgjfie");
     company.sendKeys("Elsewedy");
     message.sendKeys("Hello");
     sendbtn.click();
     assertion.assertTrue(driver.findElement(By.id("phone_error")).isDisplayed());
     assertion.assertEquals(driver.findElement(By.id("phone_error")).getText(),"phone is invalid");
 }

 @Test
   void Submit_an_email_with_valid_information(){
     name.sendKeys("Hosam");
     phone.sendKeys("01229335912");
     email.sendKeys("hoamamkg.1900@gmail.com");
     company.sendKeys("Elsewedy");
     message.sendKeys("Hello");
     sendbtn.click();
     Alert alert = driver.switchTo().alert();
     String successMessage = alert.getText();
     assertion.assertEquals(successMessage,"Message is sent");
 }

 @Test
   void Navigate_to_Home_Page_From_contact_page(){
        homebtn.click();
        String actualTitle = driver.getTitle();
        String ExuptionTitle = "Egyplast Website";
        assertion.assertEquals(actualTitle,ExuptionTitle);

 }

 @Test
   void Navigate_to_Login_Page_Page_From_contact_page(){
     Actions actions1 = new Actions(driver);
     actions1.moveToElement(loginbtn).perform();
     loginbtn.click();
     String actualTitle = driver.getTitle();
     String ExuptionTitle = "Login - Egyplast Website";
     assertion.assertEquals(actualTitle,ExuptionTitle);

 }

 @Test
   void Navigate_to_register_Page_Page_From_contact_page(){
     registerbtn.click();
     String actualTitle = driver.getTitle();
     String ExuptionTitle = "Sign-up - Egyplast Website";
     assertion.assertEquals(actualTitle,ExuptionTitle);

 }



    @AfterTest
    void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}