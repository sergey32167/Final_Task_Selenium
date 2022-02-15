package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CreateAnAccountPage extends BasePage {

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

    public CreateAnAccountPage(boolean openPageByURL) {
        super(openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }

    @Override
    protected boolean isPageOpened() {
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void setPersonalFirstName() {
        personalFirstNameInput.sendKeys(ReadProperties.getInstance().getFirstName());
    }

    private void setPersonalLastName() {
        personalLastNameInput.sendKeys(ReadProperties.getInstance().getLastName());
    }

    private void setPassword() {
        passwordInput.sendKeys(ReadProperties.getInstance().getPassword());
    }

    private void setEmail() {
        passwordInput.sendKeys(ReadProperties.getInstance().getEmail());
    }

    private void clickEmail() {
        emailInput.click();
    }

    private void setAddressFirstName() {
        addressFirstNameInput.sendKeys(ReadProperties.getInstance().getFirstName());
    }

    private void setAddressLastName() {
        addressLastNameInput.sendKeys(ReadProperties.getInstance().getLastName());
    }

    private void setCompany() {
        companyInput.sendKeys(ReadProperties.getInstance().getCompany());
    }

    private void setAddress() {
        addressInput.sendKeys(ReadProperties.getInstance().getAddress());
    }

    private void setCity() {
        cityInput.sendKeys(ReadProperties.getInstance().getCity());
    }

    private void setPostcode() {
        postcodeInput.sendKeys(ReadProperties.getInstance().getZip());
    }

    private void setPhone() {
        phoneMobileInput.sendKeys(ReadProperties.getInstance().getPhone());
    }

    private void clearAlias() {
        aliasInput.clear();
    }

    private void setAlias() {
        aliasInput.sendKeys(ReadProperties.getInstance().getAlias());
    }

    private void submitButton() {
        submitButton.click();
    }

    private void stateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(stateButton)).click();
    }

    private void selectByIndexTitle(int index) {
        List<WebElement> listTitle = driver.findElements(By.xpath("//input[@type ='radio']"));
        for (WebElement element : listTitle) {
            if (Integer.parseInt(element.getAttribute("value")) == index) {
                element.click();
            }
        }
    }

    private void selectStateByName(String state) {
        stateButton();
        List<WebElement> listState = new ArrayList<>();
        for (WebElement element : driver.findElements(By.xpath("//select[@name ='id_state']/option"))) {
            listState.add(element);
        }
        for (WebElement element : listState) {
            String textValue = element.getText();
            if (textValue.equalsIgnoreCase(state)) {
                element.click();
                break;
            }
        }
    }

    @Step("enter data to create an account")
    public MyAccountPage dataFilling() {
        selectByIndexTitle(1);
        setPersonalFirstName();
        setPersonalLastName();
        setPassword();
        clickEmail();
        setAddressFirstName();
        setAddressLastName();
        setCompany();
        setAddress();
        setCity();
        selectStateByName("Hawaii");
        setPostcode();
        setPhone();
        clearAlias();
        setAlias();
        submitButton();
        return new MyAccountPage(false);
    }
}
