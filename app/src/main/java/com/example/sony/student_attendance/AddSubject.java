package com.example.sony.student_attendance;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;
public class AddSubject extends AppCompatActivity {
EditText sname,sv;
DBHelper dbh;
ListView lv;
SQLiteDatabase db;
String err;
ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        sname=findViewById(R.id.editsubject);
        sv=findViewById(R.id.showText);
        dbh=new DBHelper(this);

sname.setText(err);
        }
    public void msg(Context context, String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
    public void addSub(View view) {
        String i = "hi";
        String sn = sname.getText().toString();
        if (sn.trim().length() == 0) {
            msg(this, "Please enter subject name");
            return;
        }
        try {

            i = dbh.saves(sn);
        } catch (Exception e) {
            i = e.toString();
        }
        msg(this, "Record added");
        sname.setText(i);

        /*String data = dbh.shows(sn);
        sv.setText(data);*/

        // msg(this, data);
        /*try {
            String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                    "Jupiter", "Saturn", "Uranus", "Neptune"};
            ArrayList<String> planetList = new ArrayList<String>();
            planetList.addAll(Arrays.asList(planets));


            // Create ArrayAdapter using the planet list.
            listAdapter = new ArrayAdapter<String>(this, R.layout.laysimple, planetList);

            // Add more planets. If you passed a String[] instead of a List<String>
            // into the ArrayAdapter constructor, you must not add more items.
            // Otherwise an exception will occur.
            listAdapter.add("Ceres");
            lv.setAdapter(listAdapter);
        }
        catch(Exception e)
        {

            i=e.toString();
        }
        sv.setText(i);*/
    }
    public void viewsub(View view)
    {

    }

}
