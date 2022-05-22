package com.example.sony.student_attendance;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
public class AddBranch extends AppCompatActivity {
    EditText bname,sv;
    Spinner spinnercourse;
    String userrole;
    List<String> labels;
    DBHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);
        spinnercourse=(Spinner)findViewById(R.id.spinner);
        bname= findViewById(R.id.addbranch);
        sv=findViewById(R.id.showBranch);
        dbh=new DBHelper(this);
        labels = dbh.showcc();
        spinnercourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                userrole =(String) spinnercourse.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercourse.setAdapter(adapter_role);

    }

    public void showbr(View view)
    {      String data="t";
        String i="hello";
        try {
            data = dbh.showb();
        }catch(Exception e) {
            i=e.toString();
        }
        sv.setText(data);
    }
    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    public void addbr(View view) {
        String i = "hi";
        String j="hello";
        String cn = bname.getText().toString();
        if (cn.trim().length() == 0) {
            msg(this, "Please enter branch name");
            return;
        }
        try {

            i = dbh.saveb(userrole,cn);
        } catch (Exception e) {
            j = e.toString();
        }
        msg(this, "Record added");

    }

    }
