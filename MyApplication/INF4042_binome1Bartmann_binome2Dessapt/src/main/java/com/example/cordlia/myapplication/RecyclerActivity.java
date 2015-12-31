package com.example.cordlia.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        // mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        // specify an adapter (see also next example)

        mAdapter = new EltsAdapter(getBiersFromFile());

        mRecyclerView.setAdapter(mAdapter);

    }
    // Classe de l'adapter mise en sous classe car problème pour créer l'affichage du RecyvlerView
    private class EltsAdapter extends RecyclerView.Adapter<EltHolder> {

        private JSONArray elts = null;

        public EltsAdapter(JSONArray autrechose) {
            this.elts = autrechose;
        }

        @Override
        public EltHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main_recycler, parent, false);

            EltHolder mHolder = new EltHolder(v);
            return mHolder;
        }

        @Override
        public void onBindViewHolder(EltHolder holder, int position) {
            JSONObject element;
            String nom;
            try {
                element = elts.getJSONObject(position);
                nom = element.getString("name");
                holder.name.setText(nom);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void setNewElts(JSONArray jsonarray) {
            this.elts = jsonarray;
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            int number = elts.length();
            Log.d("TAG", "Le nombre d'items est :" + number);
            return number;
        }
    }

    public JSONArray getBiersFromFile(){
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        }catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        }catch (JSONException e){
            e.printStackTrace();
            return new JSONArray();
        }
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
        int id = item.getItemId();

        /*noinspection SimplifiableIfStatement
        if (id == R.id.readmeitem) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);

    }
}