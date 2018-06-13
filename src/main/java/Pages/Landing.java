package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class Landing {
    private WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailLogin;

    @FindBy(css = "#pass")
    private WebElement passwordLogin;

    @FindBy(css = "#loginbutton")
    private WebElement loginBtn;

    @FindBy(name = "firstname")
    private WebElement firstNameInputForm;

    @FindBy(name = "lastname")
    private WebElement lastNameInputForm;

    @FindBy(name = "reg_email__")
    private WebElement emailInputForm;

    @FindBy(name = "reg_email_confirmation__")
    private WebElement reEmailInputForm;

    @FindBy(name = "reg_passwd__")
    private WebElement passwordInputForm;

    @FindBy(name = "birthday_month")
    private WebElement monthBirthdayForm;

    @FindBy(name = "birthday_day")
    private WebElement dayBirthdayForm;

    @FindBy(name = "birthday_year")
    private WebElement yearBirthdayForm;

    @FindBy(xpath = "//input[@name='sex'][@value='1']")
    private WebElement femaleBtnForm;

    @FindBy(xpath = "//input[@name='sex'][@value='2']")
    private WebElement maleBtnForm;

    @FindBy(name = "websubmit")
    private WebElement signUpBtnForm;

    public void setFirstNameInputForm(String firstName) {
        firstNameInputForm.sendKeys(firstName);
    }

    public void setLastNameInputForm(String lastName){
        lastNameInputForm.sendKeys(lastName);
    }

    public void setEmailInputForm(String email) {
        emailInputForm.sendKeys(email);
    }

    public void setReEmailInputForm(String email){
        reEmailInputForm.sendKeys(email);
    }
    public void setPasswordInputForm(String password){
        passwordInputForm.sendKeys(password);
    }

    public void setMonthBirthdayForm(String month){
        Select select = new Select(monthBirthdayForm);
        select.selectByValue(month);
    }

    public void setDayBirthdayForm(String day){
        Select select = new Select(dayBirthdayForm);
        select.selectByValue(day);
    }

    public void setYearBirthdayForm(String year){
        Select select = new Select(yearBirthdayForm);
        select.selectByValue(year);
    }

    public void setSexForm(String choice){
        if(choice.equals("Female")){
            femaleBtnForm.click();
        }
        else {
            maleBtnForm.click();
        }
    }

    public void clickSignUp(){
        signUpBtnForm.click();
    }

    public void setEmailLogin(String username){
        emailLogin.sendKeys(username);
    }

    public void setPasswordLogin(String password) {
        passwordLogin.sendKeys(password);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public Landing(WebDriver driver){
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }
}
