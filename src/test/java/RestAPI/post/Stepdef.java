package RestAPI.post;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.client.WebTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @When("^User send a \"([^\"]*)\" request \"([^\"]*)\" with data$")
    public void user_send_a_request_with_data(String HTTPRequest, String url, DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        if(HTTPRequest.equals("POST")){
            response = sendPost(url, dataTable);
        }
    }

    @Then("^The response code should be \"([^\"]*)\"$")
    public void the_response_code_should_be(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int codeStatus = response.getStatusLine().getStatusCode();
        assertThat(200, is(codeStatus));
    }

    @Then("^The response \"([^\"]*)\" should content data:$")
    public void the_response_should_content_data(String key, DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        String JsonString = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(JsonString);

        HashMap<String,String> mapResponse = (HashMap<String, String>) json.get(key);
        dataTable.asMap(String.class,String.class).forEach(
                (k,v) -> assertThat(mapResponse.get(k),is(v))
        );
    }
    private HttpResponse sendPost(String url, DataTable dataTable) throws Exception {


        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(baseURL + url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        dataTable.asMap(String.class,String.class).forEach((k,v)-> urlParameters.add(new BasicNameValuePair(k,v)));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);

        return response;

    }
}
