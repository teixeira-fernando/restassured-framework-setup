package org.fernando.setup.data.support;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.fernando.setup.data.factory.UserDataFactory;
import org.fernando.setup.model.User;

import static io.restassured.RestAssured.given;

public class PreConditionsSupport extends BaseAPI {

    UserDataFactory userDataFactory = new UserDataFactory();

     public String insertUser(User user){
        String newUserId = given()
                .headers(this.headers)
                .body(userDataFactory.newUser())
                .when()
                .post(this.props.userUrl())
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .path("id");

        return newUserId;
    }
}
