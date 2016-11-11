package com.example.des.annualleave;

/**
 * Created by Des on 11/11/2016.
 */

public class Employees {

    private String _name;
    private String _emailAddress;
    private int _managerID;
    private int _id;
    private int _leave;

    public Employees(String name, String emailAddress, int managerID, int id, int leave){
        this._name = name;
        this._emailAddress = emailAddress;
        this._managerID = managerID;
        this._id = id;
        this._leave = leave;
    }

    public Employees(){
        //empty constructor
    }

    //getters
    public int get_leave() {
        return _leave;
    }

    public String get_name() {
        return _name;
    }

    public String get_emailAddress() {
        return _emailAddress;
    }

    public int get_managerID() {
        return _managerID;
    }

    public int get_id() {
        return _id;
    }

    //setters
    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_emailAddress(String _emailAddress) {
        this._emailAddress = _emailAddress;
    }

    public void set_managerID(int _managerID) {
        this._managerID = _managerID;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_leave(int _leave) {
        this._leave = _leave;
    }
}

