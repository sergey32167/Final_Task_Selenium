package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "login")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class ='shopping_cart']/a")
    private WebElement cartButton;
    @FindBy(xpath = "//h5[@itemprop= 'name']/a")
    public List<WebElement> someProduct;

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
            return cartButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void clickSgnIn() {
        signInButton.click();
    }

    private void clickItem1() {
        for (WebElement element : someProduct){
            if (element.getText().trim().equals(ReadProperties.getInstance().getItem1())){
                element.click();
            }
            break;
        }
    }

    private void clickItem2() {
        for (WebElement element : someProduct){
            if (element.getText().trim().equals(ReadProperties.getInstance().getItem2())){
                element.click();
            }
            break;
        }
    }

    private void clickItem3() {
        for (WebElement element : someProduct){
            if (element.getText().trim().equals(ReadProperties.getInstance().getItem3())){
                element.click();
            }
            break;
        }
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
}