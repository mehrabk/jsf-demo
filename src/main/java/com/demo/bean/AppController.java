package com.demo.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * @author m_kor
 * date 10/21/2023
 */
@ManagedBean
@RequestScoped
public class AppController {
    private String title;

    @PostConstruct
    public void init(){
        // Access JSF Context Parameters from Managed Bean
        title = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("com.demo.title");
    }

    public String getTitle() {
        return title;
    }
}
