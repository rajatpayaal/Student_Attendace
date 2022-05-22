package com.example.sony.student_attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import java.lang.String;
public class DetailsActivity extends AppCompatActivity {
    Intent intent;
    TextView text,text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        DBHelper db = new DBHelper(this);
        Intent intent = getIntent();
        String Id = intent.getStringExtra("ID");
            String str = intent.getStringExtra("cname");
            String str1 = intent.getStringExtra("bname");
            String str2 = intent.getStringExtra("year");
            ArrayList<HashMap<String, String>> userList = db.GetStudent(str, str1, str2);
            ListView lv = (ListView) findViewById(R.id.user_list);
            ListAdapter adapter = new SimpleAdapter(DetailsActivity.this, userList, R.layout.list_row, new String[]{"name", "designation", "location"}, new int[]{R.id.name, R.id.designation, R.id.location});
            lv.setAdapter(adapter);


    }
}