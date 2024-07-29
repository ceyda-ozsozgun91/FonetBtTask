package stepDefinition;

import helpers.Actions;
import org.junit.Assert;
import io.cucumber.java.en.*;



public class StepDefinitions {
    private Actions _action= new Actions();



    @Given("I am on the demo site")
    public void i_am_on_the_demo_site() {
        _action.initializeDriver();
    }

    @When("I click on phone product card")
    public void i_click_on_phone_product_card() throws InterruptedException {
      _action._homePage.clickAndCopyPhoneProduct();

       // _action.clickAction(_homePage.phoneProduct);
    }

    @When("I click on the Place Order button")
    public void i_click_on_the_place_order_button() throws InterruptedException {
       // if(_homePage.compareSelectedProductWithProductDetail(_productDetailPage.detailTitle.getText(), _productDetailPage.detailPrice.getText().split("\\s+")[0], _productDetailPage.detailDescription.getText()))
        // _productDetailPage.productDetailButtons(buttonName).click();
      _action._placeOrderPage.clickPlaceOrderButton();
    }

    @When("I click on the Purchase button")
    public void i_click_on_the_purchase_button() throws InterruptedException {
        //if(_homePage.compareSelectedProductWithProductDetail(_productDetailPage.detailTitle.getText(), _productDetailPage.detailPrice.getText().split("\\s+")[0], _productDetailPage.detailDescription.getText()))
        // _productDetailPage.productDetailButtons(buttonName).click();
      _action._placeOrderFormPage.clickPurchaseButton();
    }

    @When("I click the OK button on the warning screen")
    public void i_click_the_button_on_the_warning_screen() throws InterruptedException {
       _action.clickOkForPurchase();

    }

    @When("I click on the {string} menu")
    public void i_click_on_the_menu(String menuName) throws InterruptedException {
       _action.ClickMenuItemNameOf(menuName);
    }

    @When("I click on the Cart menu")
    public void i_click_on_the_card_menu() throws InterruptedException {
    _action.driver.get("https://demoblaze.com/cart.html");
    //_action._productDetailPage.clickCardMenu();
  }

    @When("I fill in the form information")
    public void i_fill_in_the_form_information() {
      _action.fillInPlaceOwnerForm("jane.doe","Turkiye","Ankara","16550","03","2024");

        }

    @Then("The message that Thank you for your purchase should be displayed")
    public void the_message_should_be_displayed() {

      Assert.assertTrue(_action._placeOrderFormPage.isSuccessPurchaseMessageVisible());
    }

    @Then("The information provided should be accurate with the relevant product information")
    public void the_information_provided_should_be_accurate_with_the_relevant_product_information() throws InterruptedException {
      Assert.assertTrue(_action.purchaseAssertion("jane.doe","16550"));
      _action._placeOrderFormPage.clickOKbutton();
      _action.closeDriver();
    }

    @When("I click on Phone category")
    public void i_click_on_phone_category() throws InterruptedException {
        _action._homePage.clickPhones();

    }

    @When("I click on Laptops category")
    public void i_click_on_laptops_category() throws InterruptedException {
    _action._homePage.clickLaptops();

  }

    @When("I click on Monitors category")
    public void i_click_on_monitors_category() throws InterruptedException {
    _action._homePage.clickMonitors();

  }

    @Then("The category products should be listed and write them")
    public void the_category_products_should_be_listed_and_write_them() throws InterruptedException {
        _action.writeProductsToConsole(_action.productElements);
        _action.closeDriver();
    }

    @Then("The product title and price should match on the detail page")
    public void the_product_title_and_price_should_match_on_the_detail_page() {
        // Implement logic to check if product title and price match on detail page
    }

    @And("I click on the Add to cart button in product detail page")
    public void ıClickOnTheButtonInProductDetailPage() throws InterruptedException {
        _action._productDetailPage.clickAddToCartButton();
    }

}

