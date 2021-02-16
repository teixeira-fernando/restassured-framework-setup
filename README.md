# Rest Assured Basic Setup and Architecture

This repository contains the configuration and architecture to create API automated tests using Rest Assured.

![Rest Assured Logo](imgs/rest-assured-icon.png)

<b>The test examples created here were based on the following APIs:</b> [Reqres.in](https://reqres.in/)

# Required software
* Java JDK 11+
* Maven
* [Lombok](https://www.baeldung.com/lombok-ide)

## Environments
By default, the tests are configured to use the properties values from the QA environment, but it is possible to change that using the property `environment`. Check it out some possibilities:

| run | command |
|-----|---------|
| local | `mvn test -Denvironment=local` |
| develop | `mvn test -Denvironment=dev` |
| qa | `mvn test -Denvironment=qa` |

## Groups
The test suites can be executed using an IDE or by command line.
If you execute `mvn test`, tall the tests will be executed by default

To run different groups/test suites, you can use the property `-D`, including the group name. Take a look on some examples:

| run | command |
|-----|---------|
| login tests | `mvn -Dgroups="login" test` |
| user tests | `mvn -Dgroups="user" test` |
| all tests | `mvn test` |

## Groups + Reports
This project uses Allure Repor# Libraries
* [Owner](http://owner.aeonbits.org/) para gestão de property files
* [java-faker](https://github.com/DiUS/java-faker) geração de dados fake
* [RestAssured](http://rest-assured.io/) framework para testes de API Rest
t to automatically generate the test report. You can use the command line to generate it in two ways:

* `mvn allure:serve`: will open the HTML report into the browser
* `mvn allure:report`: will generate the HTML port at target/site/allure-maven-plugin folder

You can also use the profiles to generate reports from a specific test suite:

| run | command |
|-----|---------|
| login report | `mvn test allure:report -Dgroups="login"` |
| user report | `mvn test allure:report -Dgroups="user"` |
| all tests report | `mvn test allure:report` |

The HTML report is generated in the following path: `target > site > allure-maven-plugin > index.html`.

Notice that it is possible to select an environment, a group and generate a report with a unique command:

`mvn test allure:report -Denvironment=dev -Dgroups="user"`

# About the Project Structure

### src/main/java

#### test
Base Test that sets the initial aspects to make the requests using RestAssured.
It also has the configuration to deal with `BigDecimal` returns and SSL configuration.

#### client
Classes that do some actions in their endpoints. It's used my the `FullSimulationE2ETest` to demonstrate and e2e
scenario.

#### commons
It contains a class where will format the URL expected when we create a new resource in the `simulation` endpoint.
You can add any class that can be used in the project.

#### config
The class `Configuration` is the connections between the property file `api.properties` located in `src/test/resources/`.

The `@Config.Sources` load the properties file and match the attributes with the `@Key`, so you automatically have the value.
You can see two sources.
The first one will get the property values from the system (as environment variables or from the command line) in the case you want to change it, for example, in a pipeline.
The second will load the `api.properties` file from the classpath.
```java
@Config.Sources({
    "system:properties",
    "classpath:api.properties"})
```

The environment variable is read on the `ConfiguratorManager`.
This class reduces the amount of code necessary to get any information on the properties file.

This strategy uses [Owner](http://owner.aeonbits.org/) library

#### data

##### factory
Test Data Factory classes using [java-faker](https://github.com/DiUS/java-faker) to generate fake data and [Lombok] to
create the objects using the Builder pattern.

##### provider
JUnit 5 Arguments to reduce the amount of code and maintenance for the functional tests on `SimulationsFunctionalTest`

##### suite
It contains a class having the data related to the test groups.

#### model
Model and Builder class to
[mapping objects thought serialization and deserialization](https://github.com/rest-assured/rest-assured/wiki/Usage#object-mapping)
in use with Rest-Assured.

#### specs
Request and Response specifications used by the clients and e2e tests.
The class `InitialStepsSpec` set the basePath, baseURI, and port for the custom specs.
The classes `RestrictionsSpecs` and `SimulationsSpecs` contains the implementation of request and response specifications.

### src/test/resources
It has a `schemas` folder with the JSON Schemas to enable Contract Testing using Rest-Assured. Also, the properties file to easily configure the API URI.

## Libraries
* [RestAssured](http://rest-assured.io/) library to test REST APIs
* [JUnit 5](https://junit.org/junit5/) to support the test creation
* [Owner](http://owner.aeonbits.org/) to manage the property files
* [java-faker](https://github.com/DiUS/java-faker) to generate fake data
* [Log4J2](https://logging.apache.org/log4j/2.x/) as the logging strategy
* [Allure Report](https://docs.qameta.io/allure/) as the testing report strategy

### Credits to [Elias Nogueira](https://github.com/eliasnogueira) for influencing me with many ideas applied to this project