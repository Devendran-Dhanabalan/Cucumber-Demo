package RestAPI.post;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, format = { "pretty",
        "json:target/cucumber.json"},
        features = "C:\\My Coding\\Cucumber\\Practice\\src\\test\\resources\\RestAPI.post",
        tags = { "~@ignore" })
public class TestPost {

}
