package com.web.customer.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDetailsDto {
    @NotNull(message = "Enter a Name with Capital Letter and at least 2 more characters")
    @Pattern(regexp = "[A-Z][a-z]{2,12}",message = "Enter a Name with Capital Letter and at least 2 more characters")
    private String firstName;

    @NotNull(message = "Enter a Name with Capital Letter and at least 2 more characters")
    @Pattern(regexp = "[A-Z][a-z]{2,12}",message = "Enter a Name with Capital Letter and at least 2 more characters")
    private String lastName;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @NotNull(message = "Enter a proper address with length at least 10 character")
    @Pattern(regexp = "[0-9a-zA-Z]{10,50}",message = "Enter a proper address with length at least 10 character")
    private String address;

    @NotNull(message = "Enter a proper number with length of 10 character")
    @Pattern(regexp = "[0-9]{10}",message = "Enter a proper number with length of 10 character")
    private String number;

}
