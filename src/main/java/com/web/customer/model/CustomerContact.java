package com.web.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerContact {

    @Id
    private int id;

    private String address;

    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
