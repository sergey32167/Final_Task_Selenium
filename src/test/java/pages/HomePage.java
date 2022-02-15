package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".login")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class ='shopping_cart']/a")
    private WebElement cartButton;
    @FindBy(xpath = "//ul[@id ='homefeatured']/li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line']")
    private WebElement product1;
    @FindBy(xpath = "//ul[@id ='homefeatured']/li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']")
    private WebElement product2;
    @FindBy(xpath = "//ul[@id ='homefeatured']/li[@class = 'ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-tablet-line first-item-of-mobile-line']")
    private WebElement product3;
    @FindBys({@FindBy(xpath = "//ul[@id = 'homefeatured']/li")})

    private List<WebElement> listProduct;

    public HomePage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get("http://automationpractice.com/");
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return product1.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void signInButton() {
        signInButton.click();
    }

    private void cartButton() {
        cartButton.click();
    }

    private void selectProductByIndex(int index) {
        List<WebElement> listTitle = driver.findElements(By.xpath("//ul[@id = 'homefeatured']/li"));
        listTitle.get(index).click();
    }

    public AuthenticationPage clickSignInButton() {
        signInButton();
        return new AuthenticationPage(false);
    }

    public InCartPage cartEntry() {
        cartButton();
        return new InCartPage(false);
    }

    public InProduct goToProductByIndex(int index) {
        selectProductByIndex(index);
        return new InProduct(false);
    }

    @Step("select item by name")
    public InProduct goToProductByName(String name) {
        selectProductByName(name);
        return new InProduct(false);
    }

    private void selectProductByName(String name) {
        List<WebElement> listProduct = new ArrayList<>();
        for (WebElement element : driver.findElements(By.xpath("//h5[@itemprop= 'name']/a"))) {
            listProduct.add(element);
        }
        for (WebElement element : listProduct) {
            String textValue = element.getText().trim();
            if (textValue.equalsIgnoreCase(name)) {
                element.click();
                break;
            }
        }
    }

}
