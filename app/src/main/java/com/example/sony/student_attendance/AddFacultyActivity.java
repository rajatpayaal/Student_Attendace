package com.example.sony.student_attendance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFacultyActivity extends AppCompatActivity {
    Button rButton;
    EditText fName;
    EditText lName;
    EditText fphone;
    EditText faddress;
    EditText fusername;
    EditText fpassword;
    DBHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);
fName=findViewById(R.id.editTextFirstName);
lName=findViewById(R.id.editTextLastName);
fphone=findViewById(R.id.editTextPhone);
faddress=findViewById(R.id.editTextaddr);
fusername=findViewById(R.id.editTextUserName);
fpassword=findViewById(R.id.editTextPassword);
        dbh=new DBHelper(this);
    }
    public void msg(Context context, String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
    public void addDetail(View view)
    {String i;
        String fn=fName.getText().toString();
        String ln=lName.getText().toString();
        String fp=fphone.getText().toString();
        String fa=faddress.getText().toString();
        String fu=fusername.getText().toString();
        String fpwd=fpassword.getText().toString();
       if(fn.trim().length()==0||ln.trim().length()==0||
               fp.trim().length()==0||
                fa.trim().length()==0||
                fu.trim().length()==0||
                fpwd.trim().length()==0)
        {
            msg(this, "Please enter all values");
            return;
        }
        try {
             i = dbh.save(fn, ln, fp, fa, fu, fpwd);
        }
        catch(Exception e) {
        i=e.toString();
        }
        fName.setText(i);
        msg(this, "Record added");
        Intent intent =new Intent(AddFacultyActivity.this,AddFacultySubject.class);
        startActivity(intent);
    }
}
