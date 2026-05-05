package com.example.practical11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textview2;
    Button button, button2;

    String filename = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textview2 = findViewById(R.id.textview2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        // Save Button using Lambda
        button.setOnClickListener(v -> {
            String data = editText.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                textview2.setText(getString(R.string.data_saved));

            } catch (Exception e) {
                Log.e("FILE_ERROR", "Error saving file", e);
            }
        });

        // Load Button using Lambda
        button2.setOnClickListener(v -> {

            try {
                FileInputStream fis = openFileInput(filename);
                StringBuilder buffer = new StringBuilder();

                int c;
                while ((c = fis.read()) != -1) {
                    buffer.append((char) c);
                }

                fis.close();
                textview2.setText(buffer.toString());

            } catch (Exception e) {
                Log.e("FILE_ERROR", "Error reading file", e);
            }
        });
    }
}
