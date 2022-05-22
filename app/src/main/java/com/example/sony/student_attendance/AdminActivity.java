package com.example.sony.student_attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    Button addStudent;
    Button addFaculty;
    Button viewStudent;
    Button viewFaculty;
    Button logout;
    Button attendancePerStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        addStudent =(Button)findViewById(R.id.buttonaddstudent);
        addFaculty =(Button)findViewById(R.id.buttonaddfaculty);
        viewStudent =(Button)findViewById(R.id.buttonViewstudent);
        viewFaculty =(Button)findViewById(R.id.buttonviewfaculty);
        logout =(Button)findViewById(R.id.buttonlogout);


    }
    public void addStudent(View view)
    {
        Intent intent =new Intent(AdminActivity.this,AddStudentActivity.class);
        startActivity(intent);
    }
    public void addFaculty(View view)
    {

        Intent intent =new Intent(AdminActivity.this,AddFacultyActivity.class);
        startActivity(intent);
    }
    public void addSubject(View view)
    {

        Intent intent =new Intent(AdminActivity.this,AddSubject.class);
        startActivity(intent);
    }
    public void addCourse(View view)
    {

        Intent intent =new Intent(AdminActivity.this,AddCourse.class);
        startActivity(intent);
    }
    public void addbranch(View view)
    {

        Intent intent =new Intent(AdminActivity.this,Branch.class);
        startActivity(intent);
    }
    public void viewstudent(View view)
    {

        Intent intent =new Intent(AdminActivity.this,ViewStudent1.class);
        startActivity(intent);
    }
    public void logout(View view)
    {
        Intent intent =new Intent(AdminActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
