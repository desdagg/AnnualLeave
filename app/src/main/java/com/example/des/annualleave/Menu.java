package com.example.des.annualleave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Des on 12/11/2016.
 */

public class Menu extends AppCompatActivity{

    Button createEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_selection);

        createEmployee = (Button) findViewById(R.id.createEmployee_button);
        createEmployee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do database check for login details
                Intent intent = new Intent(Menu.this, CreateEmployee.class);
                startActivity(intent);
            }
        });
    }
}
