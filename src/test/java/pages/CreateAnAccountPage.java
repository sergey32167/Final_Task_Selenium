package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateAnAccountPage extends BasePage {

    @FindBy(id = "id_gender1")
    private WebElement title;
    @FindBy(xpath = "//select[@name ='id_state']/option")
    public List<WebElement> stateName;
    @FindBy(xpath = "//input[@name ='customer_firstname']")
    private WebElement personalFirstNameInput;
    @FindBy(xpath = "//input[@name ='customer_lastname']")
    private WebElement personalLastNameInput;
    @FindBy(xpath = "//input[@name ='passwd']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name ='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name ='firstname']")
    private WebElement addressFirstNameInput;
    @FindBy(xpath = "//input[@name ='lastname']")
    private WebElement addressLastNameInput;
    @FindBy(xpath = "//input[@name ='company']")
    private WebElement companyInput;
    @FindBy(xpath = "//input[@name ='address1']")
    private WebElement addressInput;
    @FindBy(xpath = "//input[@name ='city']")
    private WebElement cityInput;
    @FindBy(xpath = "//input[@name ='postcode']")
    private WebElement postcodeInput;
    @FindBy(xpath = "//input[@name ='phone_mobile']")
    private WebElement phoneMobileInput;
    @FindBy(xpath = "//input[@name ='alias']")
    private WebElement aliasInput;
    @FindBy(xpath = "//button[@name = 'submitAccount']")
    private WebElement submitButton;
    @FindBy(id = "uniform-id_state")
    private WebElement stateButton;

    public CreateAnAccountPage() {
        super(false);
    }

    public CreateAnAccountPage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        String endpoint = "index.php?controller=authentication&back=my-account#account-creation";
        driver.get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void setPersonalFirstName(String firstName) {
        personalFirstNameInput.sendKeys(firstName);
    }

    private void setPersonalLastName(String lastName) {
        personalLastNameInput.sendKeys(lastName);
    }

    private void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    private void setAddressFirstName(String addressFirstName) {
        addressFirstNameInput.sendKeys(addressFirstName);
    }

    private void setAddressLastName(String addressLastName) {
        addressLastNameInput.sendKeys(addressLastName);
    }

    private void setCompany(String company) {
        companyInput.sendKeys(company);
    }

    private void setAddress(String address) {
        addressInput.sendKeys(address);
    }

    private void setCity(String city) {
        cityInput.sendKeys(city);
    }

    private void setPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
    }

    private void setPhone(String phone) {
        phoneMobileInput.sendKeys(phone);
    }

    private void setAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    private void clickTitle() {
        title.click();
    }

    private void clickStateName() {
        wait.until(ExpectedConditions.elementToBeClickable(stateButton)).click();
        for (WebElement element : stateName) {
            if (element.getText().trim().equals(ReadProperties.getInstance().getState())) {
                element.click();
            }
            break;
        }
    }

    private void clickSubmitButton() {
        submitButton.click();
    }

    @Step("enter data to create an account")
    public MyAccountPage fillingInDataNewAccount(String firstName, String lastName, String email, String password, String addressFirstName, String addressLastName,
                                                 String company, String address, String city, String postcode, String phone, String alias) {
        clickTitle();
        setPersonalFirstName(firstName);
        setPersonalLastName(lastName);
        setEmail(email);
        setPassword(password);
        setAddressFirstName(addressFirstName);
        setAddressLastName(addressLastName);
        setCompany(company);
        setAddress(address);
        setCity(city);
        clickStateName();
        setPostcode(postcode);
        setPhone(phone);
        setAlias(alias);
        clickSubmitButton();
        return new MyAccountPage();
    }
}