package org.fernando.setup.data.factory;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.fernando.setup.model.User;
import org.fernando.setup.model.UserBuilder;

public class UserDataFactory {

  private final Faker faker;

  public UserDataFactory() {
    faker = new Faker();
  }

  public User userWithEmptyFirstName(){
    User user = newUser();
    user.setFirstName(StringUtils.EMPTY);
    return user;
  }

  public User userWithEmptyLastName(){
    User user = newUser();
    user.setLastName(StringUtils.EMPTY);
    return user;
  }

  public User userWithEmptyEmail(){
    User user = newUser();
    user.setEmail(StringUtils.EMPTY);
    return user;
  }

  public User userWithEmptyAvatar(){
    User user = newUser();
    user.setAvatar(StringUtils.EMPTY);
    return user;
  }

  public User userMissingAllInformation(){
    return new UserBuilder()
            .firstName(StringUtils.EMPTY)
            .lastName(faker.name().lastName())
            .email(faker.internet().emailAddress())
            .avatar(faker.internet().image())
            .build();
  }

  public User newUser() {
    return new UserBuilder()
        .firstName(faker.name().firstName())
        .lastName(faker.name().lastName())
        .email(faker.internet().emailAddress())
        .avatar(faker.internet().image())
        .build();
  }


}
