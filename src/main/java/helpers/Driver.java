package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            System.setProperty("web-driver.gecko.driver", "C:\\Users\\Emre\\IdeaProjects\\FonetBtTask\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
