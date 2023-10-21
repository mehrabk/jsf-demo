package com.demo.bean;

import javax.faces.bean.ManagedBean;
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

    public String parametersAction(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        param1 = params.get("param1Name");
        param2 = params.get("param2Name");
        return "request-parameters-result";
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

}
