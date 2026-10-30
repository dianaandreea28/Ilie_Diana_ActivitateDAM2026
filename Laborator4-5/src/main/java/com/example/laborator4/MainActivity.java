package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Adidas> listaA = new ArrayList<>();

    private final ActivityResultLauncher<Intent> launcherAdaugare = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle bundle = result.getData().getBundleExtra("pachet_date");
                    if (bundle != null) {
                        Adidas adidas = (Adidas) bundle.getSerializable("obiect_adidas");
                        if (adidas != null) {
                            listaA.add(adidas);
                            Toast.makeText(this, "Produs adăugat: " + adidas.getModel(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
    );

    private final ActivityResultLauncher<Intent> launcherAfisare = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    ArrayList<Adidas> listaActualizata = (ArrayList<Adidas>) result.getData().getSerializableExtra("lista_actualizata");
                    if (listaActualizata != null) {
                        listaA = listaActualizata;
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdauga = findViewById(R.id.btnAdauga);
        Button btnAfiseaza = findViewById(R.id.btnAfiseaza);

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PreluareDateAdidas.class);
            launcherAdaugare.launch(intent);
        });

        btnAfiseaza.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AfisareAdidas.class);
            intent.putExtra("lista_adidas", listaA);
            launcherAfisare.launch(intent);
        });
    }
}