package com.example.des.annualleave;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Des on 15/11/2016.
 */

public class RequestList extends AppCompatActivity {

    private ListView requestlistView;
    private Button addRequest;

    private String currentUserId;

    final String[] from1 = new String[]{ DBHandler.COLUMN_REQUEST_ID,
            DBHandler.COLUMN_REQUEST_START_DATE, DBHandler.COLUMN_REQUEST_END_DATE,
            DBHandler.COLUMN_REQUEST_STATUS, DBHandler.COLUMN_REQUEST_EMPLOYEE_ID};

    //request_view id's
    final int[] to1 = new int[] {R.id.req_id, R.id.req_start_date,
            R.id.req_end_date, R.id.req_status, R.id.req_emp_id};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle("Requests");
        //getting the current users id that is passed in
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            currentUserId = extras.getString("key");
        }
        setContentView(R.layout.request_list);

        DBManager dbManager = new DBManager(this);
        dbManager.open();

        //creating cursor and calling select in dbmanager
        Cursor cursor = dbManager.selectRequests();

        requestlistView = (ListView) findViewById(R.id.request_list_view);
        requestlistView.setEmptyView(findViewById(R.id.request_empty));
        for (int i = 0 ; i<cursor.getCount() ; i++) {
            System.out.println("yo its : " + cursor.getString(0));
            cursor.moveToNext();
        }

        //if here maybe
        //if(currentUserId.equals(cursor.getString(4))) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.request_view, cursor, from1, to1, 0);
            adapter.notifyDataSetChanged();
            requestlistView.setAdapter(adapter);
        //}

        addRequest = (Button) findViewById(R.id.add_request_button);
        addRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent addReq = new Intent(RequestList.this, CreateNewRequest.class);
                addReq.putExtra("key", currentUserId);
                startActivity(addReq);
            }
        });


    }
}
