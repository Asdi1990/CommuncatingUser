package com.tadevelopers.cu.communcatinguser;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        findViewById(R.id.btnShowSnackbar).setOnClickListener(this);
        findViewById(R.id.btnShowActionSnackbar).setOnClickListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowSnackbar:
                showSnackbar(v);
                break;
            case R.id.btnShowActionSnackbar:
                showActionSnackbar(v);
                break;
        }
    }

    private void showSnackbar(View v) {
        // TODO: Create and show the snackbar
        Snackbar snackbar = Snackbar.make(v , "This is a snackbar",Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    private void showActionSnackbar(View v) {
        // TODO: Create a snackbar that has an action item
        Snackbar snackbar = Snackbar.make(v , "This is a snackbar",Snackbar.LENGTH_LONG);
        snackbar.setAction("My Action",new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Snack Bar Action Tap!",Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.setActionTextColor(Color.BLUE);
        snackbar.show();

    }


}
