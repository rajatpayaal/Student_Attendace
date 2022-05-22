package com.example.sony.student_attendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SaveCourse extends AppCompatActivity {

    EditText cname, cv;
    DBHelper dbh;
    SQLiteDatabase db;
    String err;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_course);
        cname = findViewById(R.id.editcourse1);
        cv = findViewById(R.id.showCourse);
        dbh = new DBHelper(this);

        cname.setText(err);
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void addCourse(View view) {
        String i = "hi";
        String cn = cname.getText().toString();
        if (cn.trim().length() == 0) {
            msg(this, "Please enter course name");
            return;
        }
        try {

            i = dbh.savec(cn);
        } catch (Exception e) {
            i = e.toString();
        }
        msg(this, "Record added");
        cname.setText(i);


    }
    public void show(View view)
    {      String data="t";
    String i="hello";
    try {
       data = dbh.showc();
    }catch(Exception e) {
        i=e.toString();
    }
        cv.setText(data);
    }

}
