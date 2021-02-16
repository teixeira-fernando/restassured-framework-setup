package org.fernando.setup.login;

import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.fernando.setup.data.factory.UserDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.fernando.setup.data.suite.TestTags.LOGIN;
import static org.hamcrest.Matchers.notNullValue;

@Tag(LOGIN)
public class LoginTest extends BaseAPI {

    UserDataFactory userDataFactory = new UserDataFactory();

    @Test
    @DisplayName("Login successfully with valid credentials - expected code 200")
    void createUserSuccessfully(){

        given()
                .headers(this.headers)
                .body(userDataFactory.existingUser())
                .when()
                .post(this.props.loginUrl())
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
