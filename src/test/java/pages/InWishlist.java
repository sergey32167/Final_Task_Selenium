package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InWishlist extends BasePage {

    @FindBy(id = "submitWishlist")
    private WebElement saveButton;
    @FindBy(id = "name")
    private WebElement nameListInput;
    @FindBy(xpath = "//table[@class = 'table table-bordered']")
    private WebElement wishlistTable;
    @FindBy(xpath = "//tbody/tr/td/a")
    private WebElement wishlistName;
    @FindBy(xpath = "//ul[@class = 'block_content products-block']/li/a")
    private WebElement product;
    @FindBy(css = ".row.wlp_bought_list")
    private WebElement productInWishlist;
    @FindBy(className = "icon")
    private WebElement deleteWishlistButton;
    private final String endpoint = "index.php?fc=module&module=blockwishlist&controller=mywishlist";

    public InWishlist() {
    }

    public InWishlist(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return saveButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void clickSaveButton() {
        saveButton.click();
    }

    private void clickProduct() {
        product.click();
    }

    private void wishlistTable() {
        wait.until(ExpectedConditions.invisibilityOf(wishlistTable));
    }

    private void productInWishlist() {
        wait.until(ExpectedConditions.visibilityOf(productInWishlist));
    }

    private void wishlistName() {
        wait.until(ExpectedConditions.visibilityOf(wishlistName));
    }

    private void clickWishlistName() {
        wishlistName.click();
    }

    private String getWishlistNameText() {
        return wishlistName.getText();
    }

    private void setNameListInput(String nameList) {
        nameListInput.sendKeys(nameList);
    }

    private void clickDeleteWishlistButton() {
        deleteWishlistButton.click();
    }

    @Step("creating my wishlist")
    public InProduct createMyWishlist(String nameList) {
        setNameListInput(nameList);
        clickSaveButton();
        wishlistName();
        clickProduct();
        return new InProduct();
    }

    @Step("creating a random wishlist")
    public InProduct createRandomWishlist() {
        wishlistTable();
        clickProduct();
        return new InProduct();
    }

    @Step("checking the availability of the corresponding wishlist")
    public InWishlist contentMyWishlist() {
        getWishlistNameText().equals("clothes");
        clickWishlistName();
        productInWishlist();
        return this;
    }

    @Step("checking the availability of the corresponding wishlist")
    public InWishlist contentRandomWishlist() {
        getWishlistNameText().trim().equals("My wishlist");
        clickWishlistName();
        productInWishlist();
        return this;
    }

    @Step("clearing the wishlist")
    public InWishlist cleanWishlistTable() {
        clickDeleteWishlistButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
}