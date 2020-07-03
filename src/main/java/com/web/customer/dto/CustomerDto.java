package com.web.customer.dto;

import javax.validation.constraints.Pattern;

public class CustomerDto {
    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]{2,12}")
    private String lastName;

    public CustomerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
