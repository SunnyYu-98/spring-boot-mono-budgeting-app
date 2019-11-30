package com.cashu.budgetapp.model;

import java.io.Serializable;

public class AccountCreationForm implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String birthDate;
    private String budgetType;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBudgetType() {
        return budgetType;
    }
}
