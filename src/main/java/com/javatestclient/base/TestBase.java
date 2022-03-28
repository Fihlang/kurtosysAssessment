package com.javatestclient.base;

import com.javatestclient.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private String configPropertiesPath= "/src/main/java/com/javatestclient/config/config.properties";
    public static WebDriver driver;
    private static Properties prop;

   public TestBase(){

       try {
           prop = new Properties();
           FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + configPropertiesPath);
           prop.load(ip);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }
   }

   public static void initialize(){

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
   }



}
