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

public class Product1 {

    Assertion assertion = new Assertion() ;
    WebDriver driver;

    WebElement Login_Button;
    WebElement Home_Button;
    WebElement Register_Button;
    WebElement Contact_Us_Button;


    String home = "https://elsewedy123.github.io/Egyplast/pvc-compound.html";
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
        Contact_Us_Button =driver.findElement(By.className("pvc-compound-button"));
    }


    @Test
    void Navigate_to_the_register_page_from_Product_1 (){
        Actions actions = new Actions(driver);
        actions.moveToElement(Register_Button).perform();
        Register_Button.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Sign-Up - Egyplast Website";
        assertion.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Test
    void Navigate_to_login_page_from_Product_1(){
        Actions actions = new Actions(driver);
        actions.moveToElement(Login_Button).perform();
        Login_Button.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Login - Egyplast Website";
        assertion.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Test
    void Navigate_to_home_page(){
        Actions actions = new Actions(driver);
        actions.moveToElement(Home_Button).perform();
        Home_Button.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Egyplast Website";
        assertion.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Test
    void Navigate_to_the_Contact_Us_page_from_Product_1 (){
        Actions actions = new Actions(driver);
        actions.moveToElement(Contact_Us_Button).perform();
        Contact_Us_Button.click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Contact - Egyplast Website";
        assertion.assertEquals(ActualTitle,ExpectedTitle);
    }

    @AfterTest
    void quit(){
        driver.quit();
    }
}