package org.fernando.setup.user.create;

import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.fernando.setup.data.factory.UserDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.fernando.setup.data.suite.TestTags.USER;

@Tag(USER)
class CreateUserTest extends BaseAPI {

    UserDataFactory userDataFactory = new UserDataFactory();

    @Test
    @DisplayName("Create user successfully - expected code 201")
    void createUserSuccessfully(){

        given()
                .headers(this.headers)
                .body(userDataFactory.newUser())
                .when()
                .post(this.props.userUrl())
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
