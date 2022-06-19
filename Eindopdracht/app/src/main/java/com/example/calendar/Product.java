package com.example.calendar;


public class Product {
    private String _description;
    private String _details;
    public Product(String description, String details){
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
