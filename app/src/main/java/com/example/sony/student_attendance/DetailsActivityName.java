package com.example.sony.student_attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailsActivityName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        DBHelper db = new DBHelper(this);
        Intent intent = getIntent();
        String str3 = intent.getStringExtra("sname");
        ArrayList<HashMap<String, String>> userList = db.GetStudent2(str3);
        ListView lv = (ListView) findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(DetailsActivityName.this, userList, R.layout.list_row, new String[]{"name", "designation", "location"}, new int[]{R.id.name, R.id.designation, R.id.location});
        lv.setAdapter(adapter);
    }
}
