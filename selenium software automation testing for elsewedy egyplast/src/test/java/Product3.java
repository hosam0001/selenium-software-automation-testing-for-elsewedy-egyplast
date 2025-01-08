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

public class Product3 {
    WebDriver driver;
    String Contact = "https://elsewedy123.github.io/Egyplast/pp-fiber.html";


    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void beforeMethod(){

    }

    @Test
    void Navigate_to_contact_us_pagefrom_Product_3_SPECIAL_COMPOUNDS_page(){
        throw new SkipException("Skipped because navigation button is does not working");
    }

    @Test
    void Navigate_to_home_page_from_Product_3_SPECIAL_COMPOUNDS_page(){
        throw new SkipException("Skipped because navigation button is does not working");
    }

    @Test
    void Navigate_to_login_page_from_Product_3_SPECIAL_COMPOUNDS_page(){
        throw new SkipException("Skipped because navigation button is does not working");

    }

    @Test
    void Navigate_to_register_page_from_Product_3_SPECIAL_COMPOUNDS_page(){
        throw new SkipException("Skipped because navigation button is does not working");

    }




    @AfterTest
    void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}