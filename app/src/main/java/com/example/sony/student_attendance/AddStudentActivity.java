package com.example.sony.student_attendance;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {
EditText sname,fname,contact,sadd;
Spinner scourse,sbranch,syear;
    String ucourse="",ubranch,uyear;
    List<String> labels,labels1;
    private String[] labels2 = new String[] { "1st","2nd","3rd","4th"};

    DBHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        sname=findViewById(R.id.editTextFirstName);
        fname=findViewById(R.id.editTextLastName);
        contact=findViewById(R.id.editTextPhone);
        sadd=findViewById(R.id.editTextaddr);
        scourse=findViewById(R.id.spinnercourse);
        sbranch=findViewById(R.id.spinnerbranch);
        syear=findViewById(R.id.spinneryear);
        dbh=new DBHelper(this);
        labels = dbh.showcc();
        scourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                ucourse =(String) scourse.getSelectedItem();

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
        scourse.setAdapter(adapter_role);

        labels1 = dbh.showbb();
        sbranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                ubranch =(String) sbranch.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels1);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sbranch.setAdapter(adapter_role1);

        syear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                uyear =(String) syear.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels2);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        syear.setAdapter(adapter_role2);


    }
    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    public void addDetail(View view) {
        String i;
        String fn = sname.getText().toString();
        String ln = fname.getText().toString();
        String fp = contact.getText().toString();
        String fa = sadd.getText().toString();
        if (fn.trim().length() == 0 || ln.trim().length() == 0 ||
                fp.trim().length() == 0 ||
                fa.trim().length() == 0) {
            msg(this, "Please enter all values");
            return;
        }
        try {
            i = dbh.savest(fn, ln, fp, fa, ucourse, ubranch, uyear);
        } catch (Exception e) {
            i=e.toString();
        }
        sname.setText(i);
        msg(this, "Record added");
    }

}


