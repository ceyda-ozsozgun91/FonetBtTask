package pageModels;

import helpers.Driver;
import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class productDetailPage extends PageHelper{


    public productDetailPage(){

        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h2[@class='name']")
    public WebElement detailTitle;

    @FindBy(css=".price-container")
    public WebElement detailPrice;

    @FindBy(css=".description .tab-pane p")
    public WebElement detailDescription;

    @FindBy(xpath = "//strong[.=\'Product description\']")
    public WebElement productDescription;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartButton;
    public void clickAddToCartButton() throws InterruptedException {

        //if(Actions.compareHomePageElementWithClickedElement(detailTitle))
            clickAction(addToCartButton);
    }

    @FindBy(id = "cartur")
    public WebElement cardMenu;
    public void clickCardMenu() throws InterruptedException {
        clickAction(cardMenu);
    }

}
