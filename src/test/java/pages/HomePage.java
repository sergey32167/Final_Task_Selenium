package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "login")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class ='shopping_cart']/a")
    private WebElement cartButton;
    @FindBy(xpath = "//h5[@itemprop= 'name']/a[@title ='Faded Short Sleeve T-shirts']")
    private WebElement product1;
    @FindBy(xpath = "//h5[@itemprop= 'name']/a[@title ='Blouse']")
    private WebElement product2;
    @FindBy(xpath = "//h5[@itemprop= 'name']/a[@title ='Printed Dress']")
    private WebElement product3;
    @FindBy(xpath = "//h5[@itemprop= 'name']/a")
    private WebElement someProduct;

    public HomePage() {
        super(false);
    }

    public HomePage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(ReadProperties.getInstance().getURL());
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return product1.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void clickSgnIn() {
        signInButton.click();
    }

    private void clickItem1() {
        product1.click();
    }

    private void clickItem2() {
        product2.click();
    }

    private void clickItem3() {
        product3.click();
    }

    private void clickItem() {
        someProduct.click();
    }

    private void clickCartButton() {
        cartButton.click();
    }

    public AuthenticationPage clickSignInButton() {
        clickSgnIn();
        return new AuthenticationPage();
    }

    public InCartPage cartEntry() {
        clickCartButton();
        return new InCartPage();
    }

    @Step("one item selected")
    public InProduct goToItem1() {
        clickItem1();
        return new InProduct();
    }

    @Step("one item selected")
    public InProduct goToItem2() {
        clickItem2();
        return new InProduct();
    }

    @Step("one item selected")
    public InProduct goToItem3() {
        clickItem3();
        return new InProduct();
    }

    @Step("one item selected")
    public InProduct goToItem() {
        clickItem();
        return new InProduct();
    }
}