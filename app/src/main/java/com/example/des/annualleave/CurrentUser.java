package com.example.des.annualleave;

/**
 * Created by Des on 18/11/2016.
 */

public class CurrentUser {
    private String name;
    private String id;

    public CurrentUser(String n){
        name = n;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public String getId() {
        return id;
    }
}
