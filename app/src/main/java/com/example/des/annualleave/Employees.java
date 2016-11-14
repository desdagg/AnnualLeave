package com.example.des.annualleave;

/**
 * Created by Des on 11/11/2016.
 */

public class Employees {

    private String _name;
    private String _emailAddress;
    private String _managerID;
    private String _id;
    private String _leave;
    private String _password;

    public Employees(String name, String emailAddress, String managerID, String id, String leave, String password){
        this._name = name;
        this._emailAddress = emailAddress;
        this._managerID = managerID;
        this._id = id;
        this._leave = leave;
        this._password = password;
    }

    public Employees(){
        //empty constructor
    }

    //getters
    public String get_leave() {
        return _leave;
    }

    public String get_name() {
        return _name;
    }

    public String get_emailAddress() {
        return _emailAddress;
    }

    public String get_managerID() {
        return _managerID;
    }

    public String get_id() {
        return _id;
    }

    public String get_password() {
        return _password;
    }

    //setters
    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_emailAddress(String _emailAddress) {
        this._emailAddress = _emailAddress;
    }

    public void set_managerID(String _managerID) {
        this._managerID = _managerID;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_leave(String _leave) {
        this._leave = _leave;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}

