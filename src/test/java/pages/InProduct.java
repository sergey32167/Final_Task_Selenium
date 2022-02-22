package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InProduct extends BasePage {

    @FindBy(xpath = "//button[@class='exclusive']")
    private WebElement addToCartButton;
    @FindBy(className = "icon-home")
    private WebElement homeButton;
    @FindBy(xpath = "//a[@title = 'Close']")
    private WebElement closeButton;
    @FindBy(id = "wishlist_button")
    private WebElement addToWishlistButton;
    @FindBy(className = "account")
    private WebElement inAccountButton;
    @FindBy(css = ".continue.btn.btn-default.button.exclusive-medium")
    private WebElement continueShopping;
    private final String endpoint = "index.php?id_product=7&controller=product";

    public InProduct() {
    }

    public InProduct(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return addToCartButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void clickContinueShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
    }

    private void clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
    }

    private void clickAddToCartButton() {
        addToCartButton.click();
    }

    private void clickAddToWishlistButton() {
        addToWishlistButton.click();
    }

    private void clickInAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(inAccountButton)).click();
    }

    private void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    @Step("adding product to wishlist")
    public InProduct addToWishlist() {
        clickAddToWishlistButton();
        clickCloseButton();
        return this;
    }

    public MyAccountPage goToAccount() {
        clickInAccountButton();
        return new MyAccountPage();
    }

    @Step("adding a product to the cart")
    public HomePage addProduct() {
        clickAddToCartButton();
        clickContinueShoppingButton();
        clickHomeButton();
        return new HomePage();
    }
}