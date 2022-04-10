package org.fernando.setup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
@NoArgsConstructor
public class LoginCredentials {

    @Getter @Setter private String email;
    @Getter @Setter private String password;

    public LoginCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "LoginCredentials(email="
                + this.getEmail()
                + ", password="
                + this.getPassword()
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
        LoginCredentials that = (LoginCredentials) o;
        return Objects.equals(email, that.email)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
