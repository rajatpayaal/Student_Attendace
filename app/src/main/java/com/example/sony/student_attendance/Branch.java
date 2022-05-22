package com.example.sony.student_attendance;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class Branch extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // initiate TabHost
        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab

        spec = tabHost.newTabSpec("add"); // Create a new TabSpec using tab host
        spec.setIndicator("ADD"); // set the “HOME” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, AddBranch.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        spec = tabHost.newTabSpec("update"); // Create a new TabSpec using tab host
        spec.setIndicator("UPDATE"); // set the “CONTACT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, UpdateBranch.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("delete"); // Create a new TabSpec using tab host
        spec.setIndicator("DELETE"); // set the “ABOUT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, DeleteBranch.class);
        spec.setContent(intent);
        tabHost.addTab(spec);
        //set tab which one you want to open first time 0 or 1 or 2
        tabHost.setCurrentTab(1);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });


    }


}
