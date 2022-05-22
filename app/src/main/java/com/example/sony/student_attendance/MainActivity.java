package com.example.sony.student_attendance;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username,password;
    Spinner spinnerloginas;
    String userrole;
    private String[] userRoleString = new String[] { "admin", "faculty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login =(Button)findViewById(R.id.buttonlogin);
        username=(EditText)findViewById(R.id.editTextusername);
        password=(EditText)findViewById(R.id.editTextpassword);
        spinnerloginas=(Spinner)findViewById(R.id.spinnerloginas);

        spinnerloginas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                userrole =(String) spinnerloginas.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerloginas.setAdapter(adapter_role);

          }

    public void login(View view)
    {
        if(userrole.equals("admin"))
        {

            String user_name = username.getText().toString();
            String pass_word = password.getText().toString();

            if (TextUtils.isEmpty(user_name))
            {
                username.setError("Invalid User Name");
            }
            else if(TextUtils.isEmpty(pass_word))
            {
                password.setError("Enter password");
            }
            else
            {
                if(user_name.equals("admin") & pass_word.equals("admin123")){
                    Intent intent =new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else
        {
            String user_name = username.getText().toString();
            String pass_word = password.getText().toString();

            if (TextUtils.isEmpty(user_name))
            {
                username.setError("Invalid User Name");
            }
            else if(TextUtils.isEmpty(pass_word))
            {
                password.setError("Enter password");
            }
            if(user_name.equals("fac") & pass_word.equals("fac123")){
                Intent intent =new Intent(MainActivity.this,FacultyActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
            }
        }

    }


}
