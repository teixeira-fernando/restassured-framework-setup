package org.fernando.setup.user.update;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.fernando.setup.data.factory.UserDataFactory;
import org.fernando.setup.data.support.PreConditionsSupport;
import org.fernando.setup.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.fernando.setup.data.suite.TestTags.USER;

@Slf4j
@Tag(USER)
public class UpdateUserTest extends BaseAPI {

    UserDataFactory userDataFactory = new UserDataFactory();

    @Test
    @DisplayName("Update user successfully - expected code 200")
    void updateUserSuccessfully(){

        User user = userDataFactory.newUser();
        new PreConditionsSupport().insertUser(user);

        String oldName = user.getFirstName();
        user.setFirstName("New name");


        given()
                .headers(this.headers)
                .body(user)
                .when()
                .patch(this.props.userUrl())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/UpdateUserSchema.json"))
                .body("firstName", not(oldName));
    }
}
