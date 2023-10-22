package com.demo.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 * @author m_kor
 * date 10/17/2023
 */

@ManagedBean
@RequestScoped
public class MessageBean {
    private String message;
    private String name;

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: view params are NOT available here");
        System.out.println("Name: " + name);
    }

    public void before(ComponentSystemEvent event){
        if (!FacesContext.getCurrentInstance().isPostback()){
            System.out.println("PreRenderView: view parameters are available here");
            System.out.println("Name: " + name);
            name = name.toUpperCase();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
