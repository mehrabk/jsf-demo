package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author m_kor
 * date 10/17/2023
 */

@ManagedBean
@RequestScoped
public class MessageBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
