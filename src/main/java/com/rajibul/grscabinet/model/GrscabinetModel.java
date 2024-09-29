package com.rajibul.grscabinet.model;

public class GrscabinetModel {
    private int id;


    private String subject, details, name, phone;


    public GrscabinetModel(int id, String subject, String details, String name, String phone)
    {
        this.id = id;
        this.subject = subject;
        this.details = details;
        this.name = name;
        this.phone = phone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




}
