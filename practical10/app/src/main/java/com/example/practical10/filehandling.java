package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class filehandling extends AppCompatActivity {

    EditText editText1;
    Button btnSave, btnRead;
    TextView textViewResult;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filehandling);

        editText1 = findViewById(R.id.editText1);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        textViewResult = findViewById(R.id.textViewResult);

        // Save file
        btnSave.setOnClickListener(v -> {

            String data = editText1.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(filehandling.this, "File Saved Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        // Read file
        btnRead.setOnClickListener(v -> {

            try {
                FileInputStream fis = openFileInput(fileName);
                int c;
                String temp = "";

                while ((c = fis.read()) != -1) {
                    temp = temp + Character.toString((char) c);
                }

                textViewResult.setText("File Data : " + temp);
                fis.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}