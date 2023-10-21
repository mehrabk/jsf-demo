package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * @author m_kor
 * date 10/21/2023
 */
@ManagedBean
@RequestScoped
public class RequestController {

    private String param1;
    private String param2;

    @ManagedProperty(value = "#{param.paramMP1Name}")
    private String param1MP;
    @ManagedProperty(value = "#{param.paramMP2Name}")
    private String param2MP;

    public String parametersAction(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        param1 = params.get("param1Name");
        param2 = params.get("param2Name");
        return "request-parameters-result";
    }

    public String parametersManagedPropertyAction(){
        return "request-parameters-result";
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }


    public String getParam1MP() {
        return param1MP;
    }

    public void setParam1MP(String param1MP) {
        this.param1MP = param1MP;
    }

    public String getParam2MP() {
        return param2MP;
    }

    public void setParam2MP(String param2MP) {
        this.param2MP = param2MP;
    }
}
