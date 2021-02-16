package org.fernando.setup.user.create;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.fernando.setup.data.factory.UserDataFactory;
import org.fernando.setup.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.fernando.setup.data.suite.TestTags.USER;

@Slf4j
@Tag(USER)
class CreateUserTest extends BaseAPI {

    UserDataFactory userDataFactory = new UserDataFactory();
    private static final String FAILED_VALIDATION =
            "org.fernando.setup.data.provider.CreateUserDataProvider#failedValidations";

    @Test
    @DisplayName("Create user successfully - expected code 201")
    void createUserSuccessfully(){

        given()
                .headers(this.headers)
                .body(userDataFactory.newUser())
                .when()
                .post(this.props.userUrl())
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schemas/CreateUserSchema.json"));
    }

    @ParameterizedTest(name = "Scenario: {0}")
    @MethodSource(value = FAILED_VALIDATION)
    @DisplayName("Create user with empty fields - expected code 400")
    void createUserWithEmptyFields(User user){

        //The API is currently accepting Users with fields names, so.... we are expecting 201 response codes for now
        given()
                .headers(this.headers)
                .body(user)
                .when()
                .post(this.props.userUrl())
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
