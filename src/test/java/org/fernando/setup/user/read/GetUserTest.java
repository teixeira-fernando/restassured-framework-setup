package org.fernando.setup.user.read;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.fernando.setup.data.support.PreConditionsSupport;
import org.fernando.setup.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.fernando.setup.data.suite.TestTags.USER;
import static org.hamcrest.CoreMatchers.not;

@Slf4j
@Tag(USER)
public class GetUserTest extends BaseAPI {

    @Test
    @DisplayName("Get user successfully - expected code 200")
    void getUserSuccessfully(){

        given()
                .headers(this.headers)
                .when()
                .get(this.props.userUrl() + "/1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/GetUserSchema.json"));
    }
}
