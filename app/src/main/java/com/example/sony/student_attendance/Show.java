package com.example.sony.student_attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
public class Show extends AppCompatActivity {
EditText et;
TextView text,text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        text = (TextView)findViewById(R.id.text);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        DBHelper db = new DBHelper(this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("cname");
        text.setText(str);
        String str1 = intent.getStringExtra("bname");
        text1.setText(str1);
        String str2 = intent.getStringExtra("year");
        text2.setText(str2);
       }
}
