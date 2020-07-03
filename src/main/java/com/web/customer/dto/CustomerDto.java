package com.web.customer.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {

    @NotNull(message = "Enter a Name with Capital Letter and at least 2 more characters")
    @Pattern(regexp = "[A-Z][a-z]{2,12}",message = "Enter a Name with Capital Letter and at least 2 more characters")
    private String firstName;

    @NotNull(message = "Enter a Name with Capital Letter and at least 2 more characters")
    @Pattern(regexp = "[A-Z][a-z]{2,12}",message = "Enter a Name with Capital Letter and at least 2 more characters")
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
