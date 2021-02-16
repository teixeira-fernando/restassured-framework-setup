package org.fernando.setup.model;

public class UserBuilder {

    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

    public UserBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserBuilder email(String email){
        this.email = email;
        return this;
    }

    public UserBuilder avatar(String avatar){
        this.avatar = avatar;
        return this;
    }

    public User build() {
        return new User(firstName, lastName, email, avatar);
    }
}
