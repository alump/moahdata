package com.example.data;

public class DataObject {
    private Integer index;
    private String name;
    private String city;
    private String phone;

    public Integer getIndex() {
        return index;
    }

    public DataObject setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public String getName() {
        return name;
    }

    public DataObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public DataObject setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public DataObject setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
