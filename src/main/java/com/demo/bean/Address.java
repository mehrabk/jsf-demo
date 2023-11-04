package com.demo.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author m_kor
 * date 10/30/2023
 * @Named
 * @RequestScoped
 */

@Named
@RequestScoped
public class Address {
    private String firstName;
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
}
