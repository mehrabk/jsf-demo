package com.demo.bean;

/**
 * @author m_kor
 * date 10/18/2023
 */
public class Todo {

    private String description;
    private transient boolean editable;

    public Todo(String description) {
        this.description = description;
        this.editable = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}