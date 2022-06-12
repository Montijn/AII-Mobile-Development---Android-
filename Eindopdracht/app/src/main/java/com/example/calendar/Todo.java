package com.example.calendar;


public class Todo {
    private String _description;
    private String _details;
    public Todo(String description, String details){
        this._description = description;
        this._details = details;

    }

    public String getDescription(){
        return this._description;
    }
    public String getDetails(){
        return this._details;
    }
}
