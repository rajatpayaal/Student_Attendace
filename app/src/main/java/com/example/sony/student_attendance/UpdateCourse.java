package com.example.sony.student_attendance;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCourse extends AppCompatActivity {
    EditText cid, cname, sv;
    DBHelper dbh;
    String err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);
        cid = findViewById(R.id.courseid);
        cname = findViewById(R.id.coursename);
        sv = findViewById(R.id.editTextUC);
        dbh = new DBHelper(this);
    }

    public void showUC(View view) {
        String data = "t";
        String i = "hello";
        try {
            data = dbh.showc();
        } catch (Exception e) {
            i = e.toString();
        }
        sv.setText(data);
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void updateUC(View view) {
         if (cid.getText().toString().trim().length() == 0) {
            msg(this, "Enter Course Id");
        } else {
            try {
                err = dbh.updatec(cid.getText().toString(), cname.getText().toString());
                msg(this, err);
            } catch (Exception e) {
                err = e.toString();
            }
            sv.setText(err);
        }
    }
        public void searchUC(View view)
        {
            String[] s = new String[2];
            if (cid.getText().toString().trim().length() == 0) {
                msg(this, "Enter Course Id");
                return;
            } else {
                try {
                    s = dbh.searchc(cid.getText().toString());
                } catch (Exception e) {
                    s[0] = e.toString();
                }
                cname.setText(s[0]);
            }
            cname.setText(s[0]);
            sv.setText(s[0]);
        }
    }



