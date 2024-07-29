package pageModels;

import helpers.Driver;
import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class placeOrderPage extends PageHelper{


    public placeOrderPage(){
        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }



    @FindBy(css = ".btn-success")
    public WebElement placeOrderButton ;
    public void clickPlaceOrderButton() throws InterruptedException {
        clickAction(placeOrderButton);
    }
}
