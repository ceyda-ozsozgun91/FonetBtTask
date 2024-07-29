package helpers;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageModels.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {
    public WebDriver driver=Driver.getDriver();
    public static WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20L));
    public homePage _homePage;
    public cartPage _cartPage;
    public placeOrderPage _placeOrderPage;
    public productDetailPage _productDetailPage;
    public placeOrderFormPage _placeOrderFormPage;
    public static Product _product;

    public Actions(){
    }

    public void initializeDriver(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html");
        //driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        _cartPage=new cartPage();
        _homePage=new homePage();
        _placeOrderPage=new placeOrderPage();
        _productDetailPage=new productDetailPage();
        _placeOrderFormPage= new placeOrderFormPage();
        _product = new Product();
    }

    public void closeDriver(){
        Driver.closeDriver();
    }

    public By by_MenuNameOf(String name){return By.xpath("//li[contains(.,'"+ name +"')]");}
    public WebElement menuNameOf(String name){return driver.findElement(by_MenuNameOf(name));}
    public void ClickMenuItemNameOf(String name) throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(menuNameOf(name)));
        _homePage.clickAction(menuNameOf(name));
    }

    public void clickOkForPurchase() throws InterruptedException {
        Thread.sleep(500);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       // assertThat(alert.getText(), is("Product added"));
       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.alert = function(){};");
        alert.accept();
    }

    public void fillInPlaceOwnerForm(String name,String country,String city,String creditCard,String month,String year){
        if (_placeOrderFormPage.isFormPageVisible())
        {
            _placeOrderFormPage.sendKeyInNameLabel(name);
            _placeOrderFormPage.sendKeyInCountryLabel(country);
            _placeOrderFormPage.sendKeyInCityLabel(city);
            _placeOrderFormPage.sendKeyInCardLabel(creditCard);
            _placeOrderFormPage.sendKeyInMonthLabel(month);
            _placeOrderFormPage.sendKeyInYearLabel(year);
        }
    }

    public static void setProductFromHomePageElement(WebElement element)
    {
        _product.productName=element.getText();
        WebElement cardBlock = element.findElement(By.xpath("ancestor::div[@class='card-block']"));
        // productDescription elementini bul ve textini al
        WebElement productDescriptionElement = cardBlock.findElement(By.xpath(".//p"));
        _product.productDetails = productDescriptionElement.getText();

        // productPrice elementini bul ve textini al
        WebElement productPriceElement = cardBlock.findElement(By.xpath(".//h5"));
        _product.productPrice = productPriceElement.getText();

    }

    public static boolean compareHomePageElementWithClickedElement(WebElement title){
        return _product.productName.equals(title.getText());
    }


    public List<WebElement> productElements = driver.findElements(By.xpath("//div[@id='tbodyid']//div[@class='card h-100']//div[@class='card-block']//h4//a"));


    public void writeProductsToTxt(List<WebElement> productElements)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(productElements));
        try (FileWriter writer = new FileWriter("output.txt")) {
            // Her bir ürün elementi için bilgiler yazdır
            for (WebElement productElement : productElements) {
                // Ürün adını al
                String productName = productElement.getText();

                // productElement'in parent'ı olan card-block div'ini bul
                WebElement cardBlock = productElement.findElement(By.xpath("ancestor::div[@class='card-block']"));

                // productDescription elementini bul ve textini al
                WebElement productDescriptionElement = cardBlock.findElement(By.xpath(".//p"));
                String productDescription = productDescriptionElement.getText();

                // productPrice elementini bul ve textini al
                WebElement productPriceElement = cardBlock.findElement(By.xpath(".//h5"));
                String productPrice = productPriceElement.getText();

                // Ürün bilgilerini dosyaya yaz
                writer.write("Product Name: " + productName + "\n");
                writer.write("Product Description: " + productDescription + "\n");
                writer.write("Product Price: " + productPrice + "\n");
                writer.write("--------------------------------------------\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeProductsToConsole(List<WebElement> productElements) throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement productElement : productElements) {
            // Ürün adını al
            String productName = productElement.getText();

            // productElement'in parent'ı olan card-block div'ini bul
            WebElement cardBlock = productElement.findElement(By.xpath("ancestor::div[@class='card-block']"));

            // productDescription elementini bul ve textini al
            WebElement productDescriptionElement = cardBlock.findElement(By.xpath(".//p"));
            String productDescription = productDescriptionElement.getText();

            // productPrice elementini bul ve textini al
            WebElement productPriceElement = cardBlock.findElement(By.xpath(".//h5"));
            String productPrice = productPriceElement.getText();

            // Ürün bilgilerini konsola yazdır
            System.out.println("Product Name: " + productName);
            System.out.println("Product Description: " + productDescription);
            System.out.println("Product Price: " + productPrice);
            System.out.println("--------------------------------------------");
        }


    }

    public boolean purchaseAssertion(String name, String creditCard){
        return driver.findElement(By.xpath("//br[2]")).getText().equals("Card Number: "+creditCard+"") &&
                driver.findElement(By.xpath("//br[3]")).getText().equals("Name: "+name+"");
    }




}
