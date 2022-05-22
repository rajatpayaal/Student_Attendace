package com.example.sony.student_attendance;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteCourse extends AppCompatActivity {
    EditText cid, cname, sv;
    DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_course);
        cid = findViewById(R.id.courseid);
        cname = findViewById(R.id.coursename);
        sv = findViewById(R.id.showTextD);
        dbh= new DBHelper(this);
    }

    public void showDC(View view) {
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

    public void search(View view)
    {
        String[] s = new String[2];
        if (cid.getText().toString().trim().length() == 0) {
            msg(this, "Enter Course Id");
            return;
        } else {
            try {
                s = dbh.searchc(cid.getText().toString());
            }
            catch(Exception e) {
            s[0]=e.toString();
            }
            cname.setText(s[0]);
        }
        sv.setText(s[0]);
    }
    public void delete(View view)
    {String err;
        if(cid.getText().toString().trim().length()==0)
        {
            msg(this, " Please enter Course Id ");
            return;
        }
        else
        {err=dbh.deletec(cid.getText().toString());
            msg(this,err);
        }
cid.setText("");
        cname.setText("");
    }
}
