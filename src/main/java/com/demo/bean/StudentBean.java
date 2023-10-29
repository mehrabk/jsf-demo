package com.demo.bean;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * @author m_kor
 * date 10/22/2023
 */

@ManagedBean
@SessionScoped
public class StudentBean implements Serializable {
    public String getName(String name){
        return "Hello, " + name;
    }
}
