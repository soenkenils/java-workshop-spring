package com.snommensen.user;

import com.google.common.base.Objects;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    User() {
    }

    public static User create(String firstName, String lastName, String emailAddress) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);

        return user;
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("emailAddress", emailAddress)
                .toString();
    }
}
