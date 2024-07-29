package pageModels;

import helpers.Driver;
import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class placeOrderFormPage extends PageHelper{

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20L));
    public placeOrderFormPage(){
        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    @FindBy(id="orderModalLabel")
    public WebElement formPage;
    public boolean isFormPageVisible(){

        try
        {
            wait.until(ExpectedConditions.visibilityOf(formPage));
            return true;
        }catch (Exception ex){return false;}
    }

    @FindBy(id = "name")
    public WebElement nameLabel ;
    public void clickNameLabel() throws InterruptedException {
        clickAction(nameLabel);
    }
    public void sendKeyInNameLabel(String value){
        sendKeysAction(nameLabel,value);
    }

    @FindBy(id = "country")
    public WebElement countryLabel ;
    public void clickCountryLabel() throws InterruptedException {
        clickAction(countryLabel);
    }
    public void sendKeyInCountryLabel(String value){
        sendKeysAction(countryLabel,value);
    }



    @FindBy(id = "city")
    public WebElement cityLabel ;
    public void clickCityLabel() throws InterruptedException {
        clickAction(cityLabel);
    }
    public void sendKeyInCityLabel(String value){
        sendKeysAction(cityLabel,value);
    }

    @FindBy(id = "card")
    public WebElement cardLabel ;
    public void clickCardLabel() throws InterruptedException {
        clickAction(cardLabel);
    }
    public void sendKeyInCardLabel(String value){
        sendKeysAction(cardLabel,value);
    }

    @FindBy(id = "month")
    public WebElement monthLabel ;
    public void clickMonthLabel() throws InterruptedException {
        clickAction(monthLabel);
    }
    public void sendKeyInMonthLabel(String value){
        sendKeysAction(monthLabel,value);
    }

    @FindBy(id = "year")
    public WebElement yearLabel ;
    public void clickYearLabel() throws InterruptedException {
        clickAction(yearLabel);
    }
    public void sendKeyInYearLabel(String value){
        sendKeysAction(yearLabel,value);
    }

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton ;
    public void clickPurchaseButton() throws InterruptedException {
        clickAction(purchaseButton);
    }

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    public WebElement successPurchaseMessage;
    public boolean isSuccessPurchaseMessageVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOf(successPurchaseMessage));
            return true;
        }catch (Exception e){ return false;}

    }

    @FindBy(css=".confirm")
    public WebElement okButtonInFinal;
    public void clickOKbutton() throws InterruptedException {
        clickAction(okButtonInFinal);
    }
}
