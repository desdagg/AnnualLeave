package com.example.des.annualleave;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Des on 11/11/2016.
 */

public class DBHandler extends SQLiteOpenHelper{

    //database variables
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AnnualLeave.db";

    public static final String TABLE_EMPLOYEES = "employees";

    public static final String COLUMN_EMPLOYEE_NAME = "_name";
    public static final String COLUMN_EMPLOYEE_EMAIL = "_emailAddress";
    public static final String COLUMN_EMPLOYEE_MANAGERID = "_managerID";
    public static final String COLUMN_EMPLOYEE_ID = "_id";
    public static final String COLUMN_LEAVE = "_leave";
    public static final String COLUMN_EMPLOYEE_PASSWORD = "_password";

    public static final String ADMIN_NAME = "admin1";
    public static final String ADMIN_EMAIL = "admin2";
    public static final String ADMIN_ID = "1001";
    public static final String ADMIN_PASSWORD = "admin3";
    public static final String ADMIN_MID = "0";
    public static final String ADMIN_LEAVE = "0";

    //database creates
    private String CREATE_EMPLOYEES_TABLE = "CREATE TABLE " + TABLE_EMPLOYEES + "(" + COLUMN_EMPLOYEE_ID + " TEXT PRIMARY KEY, "
            + COLUMN_EMPLOYEE_NAME + " TEXT NOT NULL, " +COLUMN_EMPLOYEE_PASSWORD + " TEXT NOT NULL, "
            + COLUMN_EMPLOYEE_EMAIL + " TEXT, " + COLUMN_EMPLOYEE_MANAGERID + " TEXT, " + COLUMN_LEAVE + " TEXT);";

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
        db.execSQL(CREATE_EMPLOYEES_TABLE);
        //auto insert admin
        ContentValues adminValues = new ContentValues();
        adminValues.put(COLUMN_EMPLOYEE_ID, ADMIN_ID);
        adminValues.put(COLUMN_EMPLOYEE_NAME, ADMIN_NAME);
        adminValues.put(COLUMN_EMPLOYEE_PASSWORD, ADMIN_PASSWORD);
        adminValues.put(COLUMN_EMPLOYEE_EMAIL, ADMIN_EMAIL);
        adminValues.put(COLUMN_EMPLOYEE_MANAGERID, ADMIN_MID);
        adminValues.put(COLUMN_LEAVE, ADMIN_LEAVE);
        db.insert(TABLE_EMPLOYEES, null, adminValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
        onCreate(db);
    }

    //adding an employee
    //might move this to DBManager class
    /*
    public void addEmployee(Employees employee){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMPLOYEE_NAME, employee.get_name());
        values.put(COLUMN_EMPLOYEE_EMAIL, employee.get_emailAddress());
        values.put(COLUMN_EMPLOYEE_MANAGERID, employee.get_managerID());
        values.put(COLUMN_EMPLOYEE_ID, employee.get_id());
        values.put(COLUMN_LEAVE, employee.get_leave());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EMPLOYEES, null, values);
        db.close();
    }

    //deleting an employee
    //do this later
    public void deleteEmployee(){

        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_EMPLOYEES + " WHERE " something + "=\"" + somethingIn + "\";");

    }
    */
}
