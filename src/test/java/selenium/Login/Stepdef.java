package selenium.Login;

import Pages.Landing;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Browser;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Stepdef {
    WebDriver driver;
    Landing landingPage;
    @Before
    public void init(){
        driver = Browser.launch();
    }
    @Given("^I am on Facebook login page$")
    public void goToFacebook() {
        driver.get("https://www.facebook.com/");
        landingPage = new Landing(driver);
    }
    @Given("^User enter Username as \"([^\"]*)\"$")
    public void user_enter_Username_as(String username) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.setEmailLogin(username);
    }

    @Given("^User enter Password as \"([^\"]*)\"$")
    public void user_enter_Password_as(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.setPasswordLogin(password);
    }

    @When("^User click Login Button$")
    public void user_click_Login_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickLogin();
    }

    @Then("^Login should be unsuccessful$")
    public void login_should_be_unsuccessful() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        assertThat("Log into Facebook | Facebook", is(title));
    }

    @After
    public void teminate(){
        driver.close();
    }
}
