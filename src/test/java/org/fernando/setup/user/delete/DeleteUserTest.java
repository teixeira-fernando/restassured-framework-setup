package org.fernando.setup.user.delete;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.fernando.setup.baseRequest.BaseAPI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.fernando.setup.data.suite.TestTags.USER;

@Slf4j
@Tag(USER)
public class DeleteUserTest extends BaseAPI {

    @Test
    @DisplayName("Delete user successfully - expected code 200")
    void deleteUserSuccessfully(){

        given()
                .headers(this.headers)
                .when()
                .delete(this.props.userUrl() + "/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
