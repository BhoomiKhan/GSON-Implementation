package com.pawras.gsonimplementation;

import com.google.gson.annotations.SerializedName;

public class Post {

    //no need to add annotation if your data fields are matching with the fields in JsonObject
    private String customer_name;

    @SerializedName("required_person")    //we are telling here to the Gson library that the value of field in json-Object with name "required_person" should store in the below data field (person)
    private String person;

    @SerializedName("address")
    private String addresss;

    @SerializedName("number")
    private String phone_number;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getRequired_person() {
        return person;
    }

    public void setRequired_person(String required_person) {
        this.person = required_person;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return addresss;
    }

    public void setAddress(String address) {
        this.addresss = address;
    }

    public Post() {

    }
}