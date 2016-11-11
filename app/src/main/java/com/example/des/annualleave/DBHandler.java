package com.example.des.annualleave;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Des on 11/11/2016.
 */

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AnnualLeave.db";

    public static final String TABLE_EMPLOYEES = "employees";

    public static final String COLUMN_EMPLOYEE_NAME = "_name";
    public static final String COLUMN_EMPLOYEE_EMAIL = "_emailAddress";
    public static final String COLUMN_EMPLOYEE_MANAGERID = "_managerID";
    public static final String COLUMN_EMPLOYEE_ID = "_id";
    public static final String COLUMN_LEAVE = "_leave";

    String CREATE_EMPLOYEES_TABLE = "CREATE TABLE" + TABLE_EMPLOYEES + "(" + COLUMN_EMPLOYEE_ID + " INTEGER PRIMARY KEY, " + COLUMN_EMPLOYEE_NAME + " TEXT NOT NULL, "
            + COLUMN_EMPLOYEE_EMAIL + " TEXT, " + COLUMN_EMPLOYEE_MANAGERID + " INTEGER, " + COLUMN_LEAVE + " INTEGER);";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_EMPLOYEES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_EMPLOYEES);
        onCreate(db);
    }

    //adding an employee
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

}
