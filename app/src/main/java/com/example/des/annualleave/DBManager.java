package com.example.des.annualleave;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

/**
 * Created by Des on 12/11/2016.
 */

public class DBManager {

    private DBHandler dbHandler;
    private SQLiteDatabase myDatabase;
    private Context context;

    //constructor
    public DBManager(Context c){
        context = c;
    }

    //open the database
    public DBManager open(){
        //try catch for opening the database
        try{
            dbHandler = new DBHandler(context);
            myDatabase = dbHandler.getWritableDatabase();
        }catch (SQLiteCantOpenDatabaseException e){
            Log.e("DB exception: ", "unable to open the database",e);
        }
        return this;
    }

    //select values from the database
    public Cursor select(){
        String[] employees = new String[] {DBHandler.COLUMN_EMPLOYEE_ID,
                DBHandler.COLUMN_EMPLOYEE_NAME, DBHandler.COLUMN_EMPLOYEE_EMAIL,
                DBHandler.COLUMN_EMPLOYEE_MANAGERID, DBHandler.COLUMN_LEAVE,
                DBHandler.COLUMN_EMPLOYEE_PASSWORD};
        Cursor cursor = null;

        try{
            cursor = myDatabase.query(DBHandler.TABLE_EMPLOYEES, employees,null,null,null,null,null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
        }catch (SQLiteException e){
            Log.e("DB exception: ", "",e);
        }
        return cursor;
    }

    //insert values into the database
    public void insert(String name, String email, String mID, String eID, String leave, String password){
        ContentValues values = new ContentValues();
        values.put(DBHandler.COLUMN_EMPLOYEE_NAME, name);
        values.put(DBHandler.COLUMN_EMPLOYEE_EMAIL, email);
        values.put(DBHandler.COLUMN_EMPLOYEE_MANAGERID, mID);
        values.put(DBHandler.COLUMN_EMPLOYEE_ID, eID);
        values.put(DBHandler.COLUMN_LEAVE, leave);
        values.put(DBHandler.COLUMN_EMPLOYEE_PASSWORD, password);

        //try catch for inserts
        try{
            myDatabase.insert(DBHandler.TABLE_EMPLOYEES, null, values);
            dbHandler.close();
        }catch(SQLiteException e){
            Log.e("DB exception: ","",e);
        }
    }


    //close the database
    public void close() {
        try{
            dbHandler.close();
        }catch (SQLiteException e){
            Log.e("DB exception: ","",e);
        }
    }
}
