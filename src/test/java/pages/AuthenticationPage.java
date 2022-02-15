package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//input[@name = 'email_create']")
    private WebElement createAnAccountEmailAddressInput;
    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;
    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement alreadyRegisteredEmailAddressInput;
    @FindBy(xpath = "//input[@name = 'passwd']")
    private WebElement alreadyRegisteredPasswordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;
    @FindBy(css = ".alert.alert-danger")
    private WebElement errorText;

    public AuthenticationPage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return signInButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void setCreateEmailAddress(){
        createAnAccountEmailAddressInput.sendKeys(ReadProperties.getInstance().getEmail());
    }

    private void clickCreateButton(){
        createAnAccountButton.click();
    }

    private void setAlreadyEmailAddress(){
        alreadyRegisteredEmailAddressInput.sendKeys(ReadProperties.getInstance().getEmail());
    }

    private void setAlreadyPassword(){
        alreadyRegisteredPasswordInput.sendKeys(ReadProperties.getInstance().getPassword());
    }

    private void clickSignInButton(){
        signInButton.click();
    }

    private String getErrorText(){
        return errorText.getText();
    }

    @Step("login to create an account")
    public CreateAnAccountPage createAccount(){
        setCreateEmailAddress();
        clickCreateButton();
        return new CreateAnAccountPage(false);
    }

    @Step("login to create an account")
    public CreateAnAccountPage createAccount2(){
        setCreateEmailAddress();
        clickCreateButton();
        return new CreateAnAccountPage(false);
    }

    @Step("account login")
    public MyAccountPage signIn(){
        setAlreadyEmailAddress();
        setAlreadyPassword();
        clickSignInButton();
        return new MyAccountPage(false);
    }
}
