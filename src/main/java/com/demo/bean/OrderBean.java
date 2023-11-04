package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author m_kor
 * date 11/4/2023
 */
@ManagedBean
@RequestScoped
public class OrderBean {

    private String name = "I'm an hidden name";
    private String description = "I'm an hidden description";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}