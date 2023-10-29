package com.demo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;

/**
 * @author m_kor
 * date 10/29/2023
 * This tutorial we’ll talk about JSF Flash Scope which is introduced in JSF 2.0 and is utilised when you need to pass parameters between views without the need to store them in the session.
 * Variables stored in the flash scope will be available over a redirection and will be eliminated afterwards.
 * It mostely is used with the POST-redirect-GET pattern.
 * Variables stored in the JSF flash scope survive only one redirect and then are deleted.
 * We can read and write values into the JSF Flash Scope. The method setKeepMessages() stores the messages in the JSF flash scope so they can survive the POST-redirect-GET pattern, so they are available in the next page.
 */

@ManagedBean
@RequestScoped
public class FlashScopeBean {
    private String firstName;
    private String lastName;

    public String goToConfirmView() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("firstName", firstName);
        flash.put("lastName", lastName);
        return "flash-scope-confirm?faces-redirect=true";
    }

    public String goToInputFormView() {
        return "flash-scope?faces-redirect=true";
    }

    public String insertValue() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        flash.setKeepMessages(true);
        pullValuesFromFlash(null);

        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Value inserted"));
        return "flash-scope-done?faces-redirect=true";
    }

    // We obtain the values from the flash scope in the preRenderView event to add the values to the managed bean.
    // Note: that we are not keeping the values in the flash scope after the user clicks on back to input link.
    public void pullValuesFromFlash(ComponentSystemEvent e) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        firstName = (String)flash.get("firstName");
        lastName = (String)flash.get("lastName");
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
}
