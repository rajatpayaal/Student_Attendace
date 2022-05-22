package com.example.sony.student_attendance;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewStudent1 extends AppCompatActivity {
    DBHelper dbh;
    Spinner scourse,sbranch,syear;
    String ucourse="",ubranch,uyear;
    List<String> labels,labels1;
    EditText sid,sname;
    private String[] labels2 = new String[] { "1st","2nd","3rd","4th"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        dbh = new DBHelper(this);

        scourse=findViewById(R.id.spinnercourse);
        sbranch=findViewById(R.id.spinnerbranch);
        syear=findViewById(R.id.spinneryear);
        sid=findViewById(R.id.searchId);
        sname=findViewById(R.id.searchName);
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

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
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

        ArrayAdapter<String> adapter_role1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels1);
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
    public void ShowS(View view)
    {String str=ucourse;
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra("cname", ucourse);
        intent.putExtra("bname", ubranch);
        intent.putExtra("year", uyear);

        startActivity(intent);

    }
    public void SearchById(View view)
    { String str=sid.getText().toString();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), DetailsActivityID.class);
        intent.putExtra("sid", str);
        startActivity(intent);
    }
    public void SearchByName(View view)
    { String str=sname.getText().toString();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), DetailsActivityName.class);
        intent.putExtra("sname", str);
        startActivity(intent);
    }
}
