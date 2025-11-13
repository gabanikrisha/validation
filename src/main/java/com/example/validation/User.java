package com.example.validation;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class User
{
    private int id;
    @Size(min=5,message="Name should have at least 5 characters")
    private String name ;
    @Past(message="Date of birth should be in the past")
    private Date dob;

    protected User()
    {

    }

    public User(Integer id, String name,Date dob)
    {
        this.id=id;
        this.name=name;
        this.dob=dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
