package org.fernando.setup.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
public class User {

  @JsonIgnore @Getter @Setter private String id;
  @Getter @Setter private String firstName;
  @Getter @Setter private String lastName;
  @Getter @Setter private String email;
  @Getter @Setter private String avatar;

  public User(String firstName, String lastName, String email, String avatar) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.avatar = avatar;
  }

  public String toString() {
    return "user(id="
        + this.getId()
        + ", first-name="
        + this.getFirstName()
        + ", last_name="
        + this.getLastName()
        + ", email="
        + this.getEmail()
        + ", avatar="
        + this.getAvatar()
        + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User that = (User) o;
    return Objects.equals(id, that.id)
        && Objects.equals(firstName, that.firstName)
        && Objects.equals(lastName, that.lastName)
        && Objects.equals(email, this.lastName)
        && Objects.equals(avatar, this.avatar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, avatar);
  }
}
