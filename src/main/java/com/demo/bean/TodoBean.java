package com.demo.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author m_kor
 * date 10/18/2023
 */
@ManagedBean
@SessionScoped
public class TodoBean implements Serializable {

    private List<Todo> todoList;
    private String description;

    // this will execute the init() method when the bean is created.
    @PostConstruct
    public void init() {
        todoList = new ArrayList<Todo>();
        todoList.add(new Todo("Win the lottery"));
        todoList.add(new Todo("Travel the world"));
        todoList.add(new Todo("Eat amazing food"));
    }

    // #### getters and setters ####
    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // #### Actions manipulating the list ####
    public void add(){
        todoList.add(new Todo(description));
    }

    public void save(Todo todo){
        todoList.set(todoList.indexOf(todo), todo);
        cancelEdit(todo);
    }

    public void edit(Todo todo){
        for (Todo existing : getTodoList()){
            existing.setEditable(false);
        }
        todo.setEditable(true);
    }

    public void cancelEdit(Todo todo){
        todo.setEditable(false);
    }

    public void remove(Todo todo){
        todoList.remove(todo);
    }

}