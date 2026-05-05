package com.example.inputcontrols;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    RadioGroup radioGroupGender;
    CheckBox checkBoxReading, checkBoxTraveling, checkBoxSports;
    Spinner spinnerCountry;
    Switch switchSubscribe;
    RatingBar ratingBarFeedback;
    Button buttonSubmit;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize controls
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxTraveling = findViewById(R.id.checkBoxTraveling);
        checkBoxSports = findViewById(R.id.checkBoxSports);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        switchSubscribe = findViewById(R.id.switchSubscribe);
        ratingBarFeedback = findViewById(R.id.ratingBarFeedback);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);

        // Spinner setup
        String[] countries = {"India", "USA", "UK", "Canada", "Australia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        // Button click event
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();

                // Gender
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedRadio = findViewById(selectedGenderId);
                    gender = selectedRadio.getText().toString();
                }

                // Hobbies
                String hobbies = "";
                if (checkBoxReading.isChecked()) hobbies += "Reading ";
                if (checkBoxTraveling.isChecked()) hobbies += "Traveling ";
                if (checkBoxSports.isChecked()) hobbies += "Sports ";

                // Country
                String country = spinnerCountry.getSelectedItem().toString();

                // Subscription
                String subscription = switchSubscribe.isChecked() ? "Yes" : "No";

                // Rating
                float rating = ratingBarFeedback.getRating();

                // Display result
                String result = "Name: " + name +
                        "\nGender: " + gender +
                        "\nHobbies: " + hobbies +
                        "\nCountry: " + country +
                        "\nSubscribed: " + subscription +
                        "\nRating: " + rating;
                textViewResult.setText(result);
            }
        });
    }
}