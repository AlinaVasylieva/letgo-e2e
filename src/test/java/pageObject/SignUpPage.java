package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * SignUpPage class elements and methods for them for Sign up webpage process
 */
public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
        }

    //Locators
    @FindBy(className = "sc-dnqmqq kNlnfC sc-bxivhb ifLSwk")
    @CacheLookup
    private WebElement logInBtn;

    @FindBy(css = "div.Auth__content___1HRvd > form > fieldset > button")
    @CacheLookup
    private WebElement registerBtn;

    @FindBy (name = "email")
    @CacheLookup
    private WebElement emailField;

    @FindBy (name = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy (name = "name")
    @CacheLookup
    private WebElement nameField;

    //Methods
    public void clickLogInBtn(){
        logInBtn.click();
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

    public void specifyEmail (String emailText){
        emailField.sendKeys(emailText);
    }

    public void specifyPass (String passText){
        passwordField.sendKeys(passText);
    }

    public void specifyName (String nameText){
        nameField.sendKeys(nameText);
    }






}
