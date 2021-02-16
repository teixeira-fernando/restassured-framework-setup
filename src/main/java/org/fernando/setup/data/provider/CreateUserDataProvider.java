package org.fernando.setup.data.provider;

import org.fernando.setup.data.factory.UserDataFactory;
import org.fernando.setup.model.User;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CreateUserDataProvider {

    private CreateUserDataProvider(){

    }

    public static Stream<Arguments> failedValidations() {
        UserDataFactory userDataFactory = new UserDataFactory();

        User userWithoutFirstname = userDataFactory.userWithEmptyFirstName();
        User userWithoutLastName = userDataFactory.userWithEmptyLastName();
        User userWithoutEmail = userDataFactory.userWithEmptyEmail();
        User userWithoutAvatar = userDataFactory.userWithEmptyAvatar();

        return Stream.of(
                arguments(userWithoutFirstname, "errors.amount", "Amount must be equal or greater than $ 1.000"),
                arguments(userWithoutLastName, "errors.amount", "Amount must be equal or less than than $ 40.000"),
                arguments(userWithoutEmail, "errors.installments", "Installments must be equal or greater than 2"),
                arguments(userWithoutAvatar, "errors.installments", "Installments must be equal or less than 48")
        );
    }
}
