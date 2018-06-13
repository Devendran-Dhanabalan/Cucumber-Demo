package RestAPI.get;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Is;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;

import javax.ws.rs.client.WebTarget;

import static org.apache.http.HttpHeaders.USER_AGENT;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Stepdef {

    private WebTarget webTarget;
    String baseURL;
    HttpResponse response;

    @Given("^User want to test web service of Base URL \"([^\"]*)\"$")
    public void user_want_to_test_web_service_of_Base_URL(String baseURL) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.baseURL = baseURL;
    }

    @When("^User send a \"([^\"]*)\" request \"([^\"]*)\"$")
    public void user_send_a_request(String HTTPRequest, String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(HTTPRequest.equals("GET")){
            response = sendGet(url);
        }
    }

    @Then("^The response code should be \"([^\"]*)\"$")
    public void the_response_code_should_be(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int codeStatus = response.getStatusLine().getStatusCode();
        assertThat(200, is(codeStatus));
    }

    private HttpResponse sendGet(String route) throws Exception {

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(baseURL + route);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);
        return response;
    }
}
