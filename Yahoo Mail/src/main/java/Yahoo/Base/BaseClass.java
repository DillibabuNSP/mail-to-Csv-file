package Yahoo.Base;


import Yahoo.ActionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {

    public static Properties properties;
    public static WebDriver driver;

@BeforeTest
        public void loadConfig(){
            try{
                properties =new Properties();
                System.out.println("super constructor invoked");
                FileInputStream ip=new FileInputStream("G:"+File.separator+"Yahoo Mail"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"Configuration"+ File.separator +"Config.Properties");
                properties.load(ip);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void LaunchApp(){

            WebDriverManager.chromedriver().setup();
            String browserName= properties.getProperty("browser");

            if(browserName.equalsIgnoreCase("Chrome")){
                driver=new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("FireFox")){
                driver=new FirefoxDriver();
            }else if(browserName.equalsIgnoreCase("Edge")){
                driver=new EdgeDriver();
            }

            Action.implicitWait(60);
            Action.pageLoadTimeOut(60);
            driver.get(properties.getProperty("url"));
            driver.manage().window().maximize();
        }
}