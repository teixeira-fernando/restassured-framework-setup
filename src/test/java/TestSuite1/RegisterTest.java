package TestSuite1;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import utils.Utils;

import static io.restassured.RestAssured.given;

public class RegisterTest extends Utils {

    private final String TESTDATAFILEPATH = "TestData/Register.json";
    private final String ENDPOINT = "/api/register";
    private JSONObject costsData = null;

    @Before
    public void setUp(){
        costsData = this.getJSONData(TESTDATAFILEPATH);
    }

    /** Test Register successful **/
    @Test
    public void testRegisterSuccessful(){
        given()
                .contentType(ContentType.JSON)
                .body(costsData.getJSONObject("Successful_Register").toString())
                .when()
                .post(host + ENDPOINT)
                .then()
                .statusCode(201);
    }

}
