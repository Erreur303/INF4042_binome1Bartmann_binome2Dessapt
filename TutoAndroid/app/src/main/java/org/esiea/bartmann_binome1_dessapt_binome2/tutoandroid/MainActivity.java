package org.esiea.bartmann_binome1_dessapt_binome2.tutoandroid;

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

public class MainActivity extends AppCompatActivity {

    float x1,x2;
    float y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // fab.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                 .setAction("Action", null).show();
        //     }
        // });
    }

    // MotionEvent (Swipe)
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN:{
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            case MotionEvent.ACTION_UP:{
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                //if left to right sweep event on screen
                if (x1 < x2){
                    Intent i = new Intent(getApplicationContext(),TextActivity.class);
                    startActivity(i);
                }

                // if right to left sweep event on screen
                if (x1 > x2){
                    Intent i = new Intent(getApplicationContext(),TextActivity.class);
                    startActivity(i);
                }

                // if UP to Down sweep event on screen
                if (y1 < y2){
                    Intent i = new Intent(getApplicationContext(),TextActivity.class);
                    startActivity(i);
                }

                //if Down to UP sweep event on screen
                if (y1 > y2){
                    Intent i = new Intent(getApplicationContext(),TextActivity.class);
                    startActivity(i);
                }
                break;
            }
        }
        return false;
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
