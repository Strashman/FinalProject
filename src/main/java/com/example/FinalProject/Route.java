package com.example.FinalProject;

public class Route {
    private String name;
    private String company;
    private String city;

    public Route(String name, String company, String city) {
        this.name = name;
        this.company = company;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }
}


