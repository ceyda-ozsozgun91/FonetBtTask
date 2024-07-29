package pageModels;

import helpers.Actions;
import helpers.Driver;
import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homePage extends PageHelper {
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20L));;
    public homePage(){
        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }
    @FindBy(id="cat")
    public WebElement category;
    public void clickCategory() throws InterruptedException {clickAction(category);}

    @FindBy(css ="[onclick='byCat(\\'phone\\')']" )
    public WebElement phones;
    public void clickPhones() throws InterruptedException {clickAction(phones);}

    @FindBy(css="[onclick='byCat(\\'notebook\\')']")
    public WebElement laptops ;
    public void clickLaptops() throws InterruptedException {clickAction(laptops);}

    @FindBy(css="[onclick='byCat(\\'monitor\\')']")
    public WebElement monitors ;
    public void clickMonitors() throws InterruptedException {clickAction(monitors);}

    @FindBy(xpath = "//div[@id='tbodyid']//div[@class='card h-100']//div[@class='card-block']//h4//a[.='Nokia lumia 1520']")
    public WebElement phoneProduct;



    public void clickAndCopyPhoneProduct() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(phoneProduct));
        Actions.setProductFromHomePageElement(phoneProduct);
        clickAction(phoneProduct);
    }


}
