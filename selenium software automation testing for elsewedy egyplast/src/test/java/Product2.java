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

public class Product2 {
    Assertion assertion=new Assertion();
    Actions actions;
    WebElement homeBtn;
    WebElement loginBtn;
    WebElement registerBtn;
    WebElement contactBtn;
    String home="https://elsewedy123.github.io/Egyplast/";
    WebDriver driver;
    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
        actions=new Actions(driver);
    }
    @BeforeMethod
    void beforeMethod(){
        driver.navigate().to(home);

        WebElement Btn =   driver.findElement(By.className("home-button1"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(Btn).perform();
        Btn.click();
        homeBtn= driver.findElement(By.className("homeheader-login"));
        registerBtn= driver.findElement(By.className("homeheader-register"));
        loginBtn= driver.findElement(By.className("homeheader-login1"));
        contactBtn= driver.findElement(By.className("pp-fiber-button"));
    }
    @Test
    void Navigate_to_Home_page(){
        homeBtn.click();
        String aculeTitle=driver.getTitle();
        String ExuptionTitle="Egyplast Website";
        assertion.assertEquals(aculeTitle,ExuptionTitle);

    }
    @Test
    void Navigate_to_the_register_page_from_Product_2(){
        registerBtn.click();
        String aculeTitle=driver.getTitle();
        String ExuptionTitle="Sign-Up - Egyplast Website";
        assertion.assertEquals(aculeTitle,ExuptionTitle);

    }
    @Test
    void Navigate_to_login_page_from_Product_2(){
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(loginBtn).perform();
        loginBtn.click();
        String aculeTitle=driver.getTitle();
        String ExuptionTitle="Login - Egyplast Website";
        assertion.assertEquals(aculeTitle,ExuptionTitle);

    }
    @Test
    void Navigate_to_the_Contact_Us_page_from_Product_2(){

        contactBtn.click();
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(contactBtn).perform();
        String aculeTitle=driver.getTitle();
        String ExuptionTitle="Contact - Egyplast Website";
        assertion.assertEquals(aculeTitle,ExuptionTitle);

    }
    @AfterTest
    void  Quit(){
        driver.quit();
    }
}