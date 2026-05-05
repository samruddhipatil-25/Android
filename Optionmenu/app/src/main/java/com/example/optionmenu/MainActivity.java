package com.example.optionmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLayout = findViewById(R.id.a);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.android) {
            currentLayout.setBackgroundColor(Color.RED);
            return true;
        }
        else if (item.getItemId() == R.id.java) {
            currentLayout.setBackgroundColor(Color.GREEN);
            return true;
        }
        else if (item.getItemId() == R.id.kotlin) {
            currentLayout.setBackgroundColor(Color.BLUE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}