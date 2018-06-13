package selenium.Signup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, format = { "pretty",
        "json:target/cucumber.json"},
        features = "C:\\My Coding\\Cucumber\\Practice\\src\\test\\resources\\selenium.Signup",
        tags = { "~@ignore" })
public class TestSignup {
}
