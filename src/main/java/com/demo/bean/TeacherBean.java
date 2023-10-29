package com.demo.bean;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import java.io.Serializable;

/**
 * @author m_kor
 * date 10/22/2023
 *
 */
@ManagedBean
@SessionScoped
public class TeacherBean implements Serializable {

    //We use the @ManagedProperty to inject a JSF managed bean
    @ManagedProperty(value = "#{studentBean}")
    private StudentBean studentBean;

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }
}
