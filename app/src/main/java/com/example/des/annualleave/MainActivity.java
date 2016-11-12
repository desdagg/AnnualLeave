package com.example.des.annualleave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //do database check for login details
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}
