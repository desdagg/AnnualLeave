package com.example.des.annualleave;

<<<<<<< HEAD
import android.app.Dialog;
=======
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
<<<<<<< HEAD
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
>>>>>>> 5055008babee058aa44497b659a32ed610132c74

/**
 * Created by Des on 15/11/2016.
 */

public class RequestList extends AppCompatActivity {

<<<<<<< HEAD
    private DBManager dbManager;
    private ListView requestlistView;
    private Button addRequest;
    private Button cancel;
    private Button delete;

    private TextView requestInfo;

    private String currentUserId;

    //string array with column names
    final String[] from1 = new String[]{
            DBHandler.COLUMN_REQUEST_START_DATE, DBHandler.COLUMN_REQUEST_END_DATE,
            DBHandler.COLUMN_REQUEST_STATUS, DBHandler.COLUMN_REQUEST_EMPLOYEE_ID, DBHandler.COLUMN_REQUEST_ID};

    //request_view id's
    final int[] to1 = new int[] {/*R.id.req_id,*/ R.id.req_start_date,
=======
    private ListView requestlistView;
    private Button addRequest;

    private String currentUserId;

    final String[] from1 = new String[]{ DBHandler.COLUMN_REQUEST_ID,
            DBHandler.COLUMN_REQUEST_START_DATE, DBHandler.COLUMN_REQUEST_END_DATE,
            DBHandler.COLUMN_REQUEST_STATUS, DBHandler.COLUMN_REQUEST_EMPLOYEE_ID};

    //request_view id's
    final int[] to1 = new int[] {R.id.req_id, R.id.req_start_date,
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
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

<<<<<<< HEAD
        dbManager = DBManager.getInstance(this);

        //create cursor for getting the employees requests from dbManager
        Cursor cursor = dbManager.getRequestsPerEmployee(currentUserId);

        requestlistView = (ListView) findViewById(R.id.request_list_view);
        requestlistView.setEmptyView(findViewById(R.id.request_empty));
        //i probably dont need this anymore
=======
        DBManager dbManager = new DBManager(this);
        dbManager.open();

        //creating cursor and calling select in dbmanager
        Cursor cursor = dbManager.selectRequests();

        requestlistView = (ListView) findViewById(R.id.request_list_view);
        requestlistView.setEmptyView(findViewById(R.id.request_empty));
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
        for (int i = 0 ; i<cursor.getCount() ; i++) {
            System.out.println("yo its : " + cursor.getString(0));
            cursor.moveToNext();
        }
<<<<<<< HEAD
        //check if a list item has been pressed and show the dialogue box
        //passing in the id of the clicked request
        requestlistView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(RequestList.this,"id " + id +"\n pos " + position,Toast.LENGTH_SHORT).show();

                String outId = Long.toString(id);
                showDialog(outId);
            }

        });

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.request_view, cursor, from1, to1, 0);
        adapter.notifyDataSetChanged();
        requestlistView.setAdapter(adapter);

=======

        //if here maybe
        //if(currentUserId.equals(cursor.getString(4))) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.request_view, cursor, from1, to1, 0);
            adapter.notifyDataSetChanged();
            requestlistView.setAdapter(adapter);
        //}
>>>>>>> 5055008babee058aa44497b659a32ed610132c74

        addRequest = (Button) findViewById(R.id.add_request_button);
        addRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent addReq = new Intent(RequestList.this, CreateNewRequest.class);
                addReq.putExtra("key", currentUserId);
                startActivity(addReq);
            }
        });
<<<<<<< HEAD
    }


    //creating a popup dialogue box
    private void showDialog(String id){

        final Dialog requestDialog = new Dialog(this);
        final String outId = id;
        requestDialog.setTitle("request response");
        requestDialog.setContentView(R.layout.request_delete_box);

        String output = "Are you sure you want to delete \n request id: " + id;

        //set the text to the id of the selected request
        requestInfo = (TextView) requestDialog.findViewById(R.id.request_info);
        requestInfo.setText(output);

        cancel = (Button) requestDialog.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //close the popup box
                requestDialog.dismiss();
            }
        });

        delete = (Button) requestDialog.findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //approve the selected request
                dbManager.deleteRequest(outId);
                Toast.makeText(RequestList.this,"Request No: " + outId + "\n has been deleted.", Toast.LENGTH_SHORT).show();
                requestDialog.dismiss();
            }
        });

        requestDialog.show();
=======


>>>>>>> 5055008babee058aa44497b659a32ed610132c74
    }
}
