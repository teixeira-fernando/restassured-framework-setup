package org.fernando.setup.baseRequest;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.fernando.setup.commons.request.HeadersDefinition;
import org.fernando.setup.config.Configuration;
import org.fernando.setup.config.ConfigurationManager;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public abstract class BaseAPI {

  protected Configuration props;
  protected Map<String, String> headers;

  protected BaseAPI() {
    props = ConfigurationManager.getConfiguration();
    headers = HeadersDefinition.getHeaders();
  }

  @BeforeAll
  public static void before() {
    RestAssured.config =
        RestAssuredConfig.newConfig().sslConfig(new SSLConfig().allowAllHostnames());

    RestAssured.useRelaxedHTTPSValidation();
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }
}
