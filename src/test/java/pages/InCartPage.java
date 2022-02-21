package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InCartPage extends BasePage {

    @FindBy(id = "cart_title")
    private WebElement cartTitle;
    @FindBy(id = "total_price")
    private WebElement totalPrice;
    @FindBy(xpath = "//td[@id='total_product']")
    private WebElement totalPriceProducts;
    @FindBy(xpath = "//span[@id ='summary_products_quantity']")
    private WebElement counterProduct;
    @FindBy(css = ".cart_quantity_delete")
    private WebElement deleteProductButton;
    private final String endpoint = "index.php?controller=order";

    public InCartPage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return cartTitle.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private double totalPriceText() {
        return Double.parseDouble(totalPrice.getText());
    }

    private double totalPriceProductsText() {
        return Double.parseDouble(totalPriceProducts.getText().substring(1));
    }

    private String counterProductText() {
        return counterProduct.getText();
    }

    private void clickDeleteProductButton() {
        deleteProductButton.click();
    }

    private double sumProductPrice() {
        double sum = 0;
        List<WebElement> listProduct = driver.findElements(By.xpath("//td[@class = 'cart_total']/span"));
        for (WebElement product : listProduct) {
            double www = Double.parseDouble(product.getText().substring(1));
            sum += www;
        }
        return sum;
    }

    private void countProduct(int product) {
        Assertions.assertEquals(counterProductText(), product + " " + "Products");
    }

    @Step("check the data in the cart")
    public InCartPage checksDataInCart() {
        Assertions.assertEquals(totalPriceProductsText(),  sumProductPrice());
        countProduct(3);
        return this;
    }
}