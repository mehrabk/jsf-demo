package com.demo.bean;

import com.demo.bean.repository.UserRepository;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

/**
 * @author m_kor
 * date 10/18/2023
 */
@ManagedBean
@RequestScoped
public class UserBean {
    private int id;
    private String firstName;
    private String lastName;
    private Long age;
    private Double productPrice;
    private String email;
    @Size(min = 3, message = "fatherName should at least be 3 characters long")
    private String fatherName;
    private User currentUser;

    public String toUpper(){
        firstName = firstName.toUpperCase();
        lastName = lastName.toUpperCase();
        return "view-parameter-post-redirect-result?faces-redirect=true&includeViewParams=true";
    }

    /**
     * pre loads the user from a repository
     * @return current page
     */
    public String loadUserById(){
        currentUser = UserRepository.findUser(id);
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ProfileBean getManagedBeanByEvaluateExpressionGet(){
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        return application.evaluateExpressionGet(context, "#{profileBean}", ProfileBean.class);
    }

    public ProfileBean getManagedBeanByValueExpression(){
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ELContext elContext = context.getELContext();
        return  (ProfileBean) application.getExpressionFactory()
                .createValueExpression(elContext, "#{profileBean}", ProfileBean.class).getValue(elContext);
    }

    public ProfileBean getManagedBeanByElResolver(){
        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elContext = context.getELContext();
        return (ProfileBean) elContext.getELResolver().getValue(elContext, null, "profileBean");
    }
}