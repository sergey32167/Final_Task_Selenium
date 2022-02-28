package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[@class = 'account']/span")
    private WebElement nameAccount;
    @FindBy(className = "info-account")
    private WebElement welcomeText;
    @FindBy(className = "logout")
    private WebElement lohOutButton;
    @FindBy(className = "account")
    private WebElement inAccountButton;
    @FindBy(xpath = "//a[@title ='Home']")
    private WebElement homeButton;
    @FindBy(xpath = "//a[@title ='My wishlists']")
    private WebElement wishlistsButton;

    public MyAccountPage(){
        super(false);
    }

    public MyAccountPage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        String endpoint = "index.php?controller=my-account";
        driver.get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return welcomeText.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void clickLogOut() {
        lohOutButton.click();
    }

    private void clickHomeButton() {
        homeButton.click();
    }

    private void clickInAccountButton() {
        inAccountButton.click();
    }

    private void clickWishlistsButton() {
        wishlistsButton.click();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public String getNameAccountText() {
        return nameAccount.getText();
    }

    public InWishlist signInWishlist() {
        clickWishlistsButton();
        return new InWishlist();
    }

    public HomePage jumpToHomePage() {
        clickHomeButton();
        return new HomePage();
    }
}