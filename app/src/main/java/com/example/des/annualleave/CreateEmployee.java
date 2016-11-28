package com.example.des.annualleave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
<<<<<<< HEAD
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
=======
import android.widget.Button;
import android.widget.EditText;
>>>>>>> 5055008babee058aa44497b659a32ed610132c74

/**
 * Created by Des on 11/11/2016.
 */

public class CreateEmployee extends AppCompatActivity implements View.OnClickListener{

    private EditText employeeName;
    private EditText employeeEmail;
    private EditText managerID;
    private EditText employeeID;
    private EditText leaveAlotted;
    private EditText employeePassword;
<<<<<<< HEAD
    private Spinner roleSpin;
=======
    private EditText role;
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
    private Button addEmployee;

    private DBManager dbManager;

    @Override
<<<<<<< HEAD
=======
    //to do:
    //pass new values into dbhandler
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Employee");
        setContentView(R.layout.edit_employee);

        //connecting the text fields from xml
        employeeName = (EditText) findViewById(R.id.employee_Name);
        employeeEmail = (EditText) findViewById(R.id.employee_Email);
        managerID = (EditText) findViewById(R.id.employee_ManagerID);
        employeeID = (EditText) findViewById(R.id.employee_ID);
        leaveAlotted = (EditText) findViewById(R.id.leave_Days);
        employeePassword = (EditText) findViewById(R.id.employee_password);
<<<<<<< HEAD
        roleSpin = (Spinner) findViewById(R.id.spin);

        //connect the button
        addEmployee = (Button) findViewById(R.id.addEmployee_Button);

        roleSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //create and open the database
        dbManager = DBManager.getInstance(this);
        //dbManager.open();
=======
        role = (EditText) findViewById(R.id.employee_role);
        //connect the button
        addEmployee = (Button) findViewById(R.id.addEmployee_Button);

        //create and open the database
        dbManager = new DBManager(this);
        dbManager.open();
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
        addEmployee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        //switch statement for passing in the values
        switch(v.getId()){
            case R.id.addEmployee_Button:
                final String name = employeeName.getText().toString();
                final String email = employeeEmail.getText().toString();
                final String mId = managerID.getText().toString();
                final String eId = employeeID.getText().toString();
                final String leave = leaveAlotted.getText().toString();
                final String password = employeePassword.getText().toString();
<<<<<<< HEAD
                final String eRole = roleSpin.getSelectedItem().toString();

                //pass all the new values to the dbManager
                dbManager.addEmployee(name,email,mId,eId,leave,password,eRole);

=======
                final String eRole = role.getText().toString();

                dbManager.insert(name,email,mId,eId,leave,password,eRole);
                //go back to menu when inserted    -- will change to list probably
               // Intent menu = new Intent(CreateEmployee.this, Menu.class);
                //startActivity(menu);
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
                finish();
                break;
        }
    }
}
