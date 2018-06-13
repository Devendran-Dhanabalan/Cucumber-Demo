package selenium.Signup;

import Pages.Landing;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import support.Browser;

import java.util.List;
import java.util.Map;

public class Stepdef {
    private WebDriver driver;
    private Landing landing;
    @Before
    public void init(){
        driver = Browser.launch();
    }

    @Given("^I am on a new user registration page$")
    public void i_am_on_a_new_user_registration_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.facebook.com/");
        landing = new Landing(driver);
    }

    @When("^I enter invalid data on the page$")
    public void i_enter_invalid_data_on_the_page(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        List<List<String>> data = table.raw();
        Map<String, String> map = table.asMap(String.class, String.class);
        System.out.println(data.get(1).get(1));
        landing.setFirstNameInputForm(map.get("First Name"));
        landing.setLastNameInputForm(map.get("Last Name"));
        landing.setEmailInputForm(map.get("Email Address"));
        landing.setReEmailInputForm(map.get("Re-enter Email Address"));
        landing.setPasswordInputForm(map.get("Password"));
        String[] birthDate = map.get("Birthdate").split("/");
        landing.setMonthBirthdayForm(birthDate[0]);
        landing.setDayBirthdayForm(birthDate[1]);
        landing.setYearBirthdayForm(birthDate[2]);
        landing.setSexForm(map.get("Sex"));

    }

    @When("^I click Sign up button$")
    public void i_click_Sign_up_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        landing.clickSignUp();
    }

    @Then("^the user registration should be unsuccessful$")
    public void the_user_registration_should_be_unsuccessful() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.facebook.com/", url);
    }

    @After
    public void terminate(){
        driver.close();
    }
}
