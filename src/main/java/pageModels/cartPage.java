package pageModels;

import helpers.Driver;
import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class cartPage extends PageHelper{

    public cartPage(){
        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

}
