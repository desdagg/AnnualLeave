package com.example.des.annualleave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Des on 12/11/2016.
 */

public class Menu extends AppCompatActivity{

    //menu buttons
<<<<<<< HEAD
    Button requestList;

    protected String currentUserId;
=======
    Button createEmployee;
    Button employeeList;
    Button requestList;
    Button test;

    private String currentUserId;
>>>>>>> 5055008babee058aa44497b659a32ed610132c74

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu");
        //getting the current users id that is passed in
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            currentUserId = extras.getString("key");
        }
<<<<<<< HEAD
=======

        setContentView(R.layout.menu_selection);

        //Create employees
        createEmployee = (Button) findViewById(R.id.createEmployee_button);
        createEmployee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do database check for login details
                Intent create = new Intent(Menu.this, CreateEmployee.class);
                startActivity(create);
            }
        });

        //View the list of employees
        employeeList = (Button) findViewById(R.id.employeeList_button);
        employeeList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent empList = new Intent(Menu.this, EmployeeList.class);
                startActivity(empList);
            }
        });

        //view the list of requests
        requestList = (Button) findViewById(R.id.leaveRequests_button);
        requestList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent reqList = new Intent(Menu.this, RequestList.class);
                reqList.putExtra("key", currentUserId);
                startActivity(reqList);
            }
        });

        //just a test button
        test = (Button) findViewById(R.id.test_button);
        test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu.this, "Your id is: " + currentUserId, Toast.LENGTH_SHORT).show();
            }
        });


>>>>>>> 5055008babee058aa44497b659a32ed610132c74
    }
}
