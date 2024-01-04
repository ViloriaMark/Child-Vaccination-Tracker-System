package com.example.viloriamark;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private EditText childNameEditText, vaccinationDateEditText;
    private ArrayList<Vaccination> vaccinationList;
    private VaccinationAdapter vaccinationAdapter;

    public MainActivity() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        childNameEditText = findViewById(R.id.childNameEditText);
        vaccinationDateEditText = findViewById(R.id.vaccinationDateEditText);
        Button addButton = findViewById(R.id.addButton);
        ListView vaccinationListView = findViewById(R.id.vaccinationListView);

        vaccinationList = new ArrayList<>();
        vaccinationAdapter = new VaccinationAdapter(this, R.layout.vaccination_item, vaccinationList);
        vaccinationListView.setAdapter(vaccinationAdapter);

        addButton.setOnClickListener(view -> addVaccination());
    }

    private void addVaccination() {
        String childName = childNameEditText.getText().toString().trim();
        String vaccinationDate = vaccinationDateEditText.getText().toString().trim();

        if (!childName.isEmpty() && !vaccinationDate.isEmpty()) {
            Vaccination vaccination = new Vaccination(childName, vaccinationDate);
            vaccinationList.add(vaccination);
            vaccinationAdapter.notifyDataSetChanged();
            clearInputs();
        } else {
            Toast.makeText(this, "Please enter child name and vaccination date", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearInputs() {
        childNameEditText.getText().clear();
        vaccinationDateEditText.getText().clear();
    }



}

