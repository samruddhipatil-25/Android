package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        bt1 = findViewById(R.id.button);

        bt1.setOnClickListener(v -> {

            // Create new thread
            new Thread(() -> {
                try {
                    Thread.sleep(5000); // 5 seconds delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Update UI from main thread
                runOnUiThread(() ->
                        img.setImageResource(R.drawable.java)
                );
            }).start();
        });
    }
}