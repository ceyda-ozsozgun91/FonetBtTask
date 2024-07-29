package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageHelper {

    WebDriver driver;

    WebDriverWait wait;
    public PageHelper() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20L));
    }

public void initializeDriver()
{
    driver = Driver.getDriver();
    driver.manage().window().maximize();
    driver.get("https://demoblaze.com/index.html");
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
}

public void clickAction(WebElement element) throws InterruptedException {
    Thread.sleep(500);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
}

public void sendKeysAction(WebElement element,String value)
{
    wait.until(ExpectedConditions.visibilityOf(element));
    element.sendKeys(value);
}

public void doubleClickAction(WebElement element){
    Actions builder = new Actions(driver);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    builder.doubleClick(element).perform();
}
}
