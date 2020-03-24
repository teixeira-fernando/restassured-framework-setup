package TestSuite1;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import utils.Utils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTest extends Utils {

    private final String TESTDATAFILEPATH = "TestData/LoginSuccessful.json";
    private final String ENDPOINT = "/api/login";
    private JSONObject costsData = null;

    @Before
    public void setUp(){
        costsData = this.getJSONData(TESTDATAFILEPATH);
    }

    /** Test Login successful **/
    @Test
    public void testLoginSuccessful(){
        given()
                .contentType(ContentType.JSON)
                .body(costsData.toString())
                .when()
                .post(host + ENDPOINT)
                .then()
                .statusCode(201);
    }

}
