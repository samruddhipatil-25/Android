package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button button;

    // File Handling Buttons
    Button btnSave, btnRead;

    TextView textView;
    EditText editText;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.button1);
        datePicker = findViewById(R.id.datePicker);

        editText = findViewById(R.id.editText1);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);

        // DatePicker Code
        button.setOnClickListener(v -> {

            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();

            textView.setText("Selected Date : " + day + "/" + month + "/" + year);
        });

        // Save File
        btnSave.setOnClickListener(v -> {
            String data = editText.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(MainActivity.this, "File Saved Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Read File
        btnRead.setOnClickListener(v -> {

            try {
                FileInputStream fis = openFileInput(fileName);
                int c;
                String temp = "";

                while ((c = fis.read()) != -1) {
                    temp = temp + Character.toString((char) c);
                }

                textView.setText("File Data : " + temp);
                fis.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}