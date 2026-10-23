package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreluareDateAdidas extends AppCompatActivity {

    private EditText etModel, etPret;
    private Spinner spinnerCuloare, spinnerCategorie, spinnerMaterial;
    private RadioGroup rgMarime;
    private CheckBox cbInStoc;
    private Switch switchEditie;
    private RatingBar ratingBarConfort;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preluare_date_adidas);

        etModel = findViewById(R.id.etModel);
        etPret = findViewById(R.id.etPret);
        spinnerCuloare = findViewById(R.id.spinnerCuloare);
        spinnerCategorie = findViewById(R.id.spinnerCategorie);
        spinnerMaterial = findViewById(R.id.spinnerMaterial);
        rgMarime = findViewById(R.id.rgMarime);
        cbInStoc = findViewById(R.id.cbInStoc);
        switchEditie = findViewById(R.id.switchEditie);
        ratingBarConfort = findViewById(R.id.ratingBarConfort);
        btnSalveaza = findViewById(R.id.btnSalveaza);

        String[] culori = {"Alb", "Negru", "Roșu", "Albastru"};
        ArrayAdapter<String> adapterCuloare = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, culori);
        spinnerCuloare.setAdapter(adapterCuloare);

        String[] categorii = {"Sport", "Casual", "Running"};
        ArrayAdapter<String> adapterCategorie = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorii);
        spinnerCategorie.setAdapter(adapterCategorie);

        String[] materiale = {"Piele", "Textil", "Sintetic"};
        ArrayAdapter<String> adapterMaterial = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, materiale);
        spinnerMaterial.setAdapter(adapterMaterial);

        btnSalveaza.setOnClickListener(v -> {
            String modelStr = etModel.getText().toString().trim();
            String pretStr = etPret.getText().toString().trim();

            if (modelStr.isEmpty() || pretStr.isEmpty()) {
                Toast.makeText(this, "Completați modelul și prețul!", Toast.LENGTH_SHORT).show();
                return;
            }

            String model = modelStr;
            double pret = Double.parseDouble(pretStr);
            String culoare = spinnerCuloare.getSelectedItem().toString();
            String categorie = spinnerCategorie.getSelectedItem().toString();
            String material = spinnerMaterial.getSelectedItem().toString();

            int selectedId = rgMarime.getCheckedRadioButtonId();
            int marime = 42;
            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                marime = Integer.parseInt(rb.getText().toString());
            }

            boolean inStoc = cbInStoc.isChecked();
            boolean editieLimitata = switchEditie.isChecked();
            int gradConfort = (int) ratingBarConfort.getRating();

            Adidas adidas = new Adidas(model, marime, culoare, pret, categorie, material, inStoc, editieLimitata, gradConfort);

            Bundle bundle = new Bundle();
            bundle.putSerializable("obiect_adidas", adidas);

            Intent intentReturn = new Intent();
            intentReturn.putExtra("bachet_date", bundle);
            setResult(RESULT_OK, intentReturn);
            finish();
        });
    }
}