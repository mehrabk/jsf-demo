package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * @author m_kor
 * date 11/4/2023
 */
@ManagedBean
@SessionScoped
public class ProfileBean implements Serializable {

    private String name = "I'm a profile";

    public String getName() {
        return name;
    }
}