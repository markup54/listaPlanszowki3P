package com.example.planszowki3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener kliknietyElement
                = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String kategoria = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, kategoria, Toast.LENGTH_SHORT).show();
            }
        };
        ListView listViewKat = findViewById(R.id.listViewKategorie);
        listViewKat.setOnItemClickListener(kliknietyElement);

        AdapterView.OnItemSelectedListener wybranyElement = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String kategoria = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, kategoria, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(wybranyElement);

        ArrayList<String> planszowki = new ArrayList<>();
        planszowki.add("Cyklady");
        planszowki.add("Santorini");
        planszowki.add("Szachy");
        planszowki.add("Uno");
        planszowki.add("Monopoly");
        planszowki.add("Sonar");
        planszowki.add("Remik");

        ArrayAdapter<String> adapterPlanszowki = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                planszowki
        );
        ListView listViewPlanszowki = findViewById(R.id.listViewPlaszowki);
        listViewPlanszowki.setAdapter(adapterPlanszowki);

        listViewPlanszowki.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView,
                                            View view, int i, long l) {
                        planszowki.remove(i);
                        adapterPlanszowki.notifyDataSetChanged();

                    }
                }
        );
        Button button = findViewById(R.id.buttonDodaj);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText editText = findViewById(R.id.editTextPlanszowka);
                        planszowki.add(editText.getText().toString());
                        adapterPlanszowki.notifyDataSetChanged();
                    }
                }
        );


    }
}