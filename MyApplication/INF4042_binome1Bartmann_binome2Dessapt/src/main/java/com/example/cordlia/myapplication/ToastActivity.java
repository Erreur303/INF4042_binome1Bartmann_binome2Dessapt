package com.example.cordlia.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    // float x1,x2;
    // float y1, y2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button_toast);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(ToastActivity.this, getString(R.string.toast_affiche), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Menu de l'ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.readmeitem:
                Intent i1 = new Intent(getApplicationContext(),ReadmeActivity.class);
                startActivity(i1);
                break;
            case R.id.toastitem:
                Intent i2 = new Intent(getApplicationContext(),ToastActivity.class);
                startActivity(i2);
                break;
            case R.id.downloaditem:
                Intent i3 = new Intent(getApplicationContext(),DownloadActivity.class);
                startActivity(i3);
                break;

            default:
                break;
        }
        return true;
    }
}
