package com.example.sony.student_attendance;

import android.content.Context;
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

public class UpdateBranch extends AppCompatActivity {
    EditText bid, bname, sv;
    Spinner spinnercourse;
    String cname,err;
    List<String> labels;
    DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_branch);
        spinnercourse = (Spinner) findViewById(R.id.spinner);
        bname = findViewById(R.id.addbranch);
        bid=findViewById(R.id.branchid);
        sv = findViewById(R.id.showBranch);
        dbh = new DBHelper(this);
        labels = dbh.showcc();
        spinnercourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                cname = (String) spinnercourse.getSelectedItem();

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
    public void showbru(View view)
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
    public void searchUB(View view)
    {
        String[] s = new String[2];
        if (bid.getText().toString().trim().length() == 0) {
            msg(this, "Enter Branch Id");
            return;
        } else {
            try {
                s = dbh.searchb(bid.getText().toString());
            } catch (Exception e) {
                s[0] = e.toString();
            }
            bname.setText(s[0]);
        }
        bname.setText(s[0]);
        sv.setText(s[0]);
    }
    public void updateUB(View view) {
        if (bid.getText().toString().trim().length() == 0) {
            msg(this, "Enter Course Id");
        } else {
            try {
                err = dbh.updateb(bid.getText().toString(), bname.getText().toString(),cname);
                msg(this, err);
            } catch (Exception e) {
                err = e.toString();
            }
            sv.setText(err);
        }
    }
}
