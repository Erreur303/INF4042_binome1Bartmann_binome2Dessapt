package com.example.cordlia.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class DownloadActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    // Méthode appelant la méthode de téléchargement de la classe DownloadJSON
    public void DlBeers  (View view){
        DownloadJSON.startActionGetJson(this);
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
