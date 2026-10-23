package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvAfisare;

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle bundle = result.getData().getBundleExtra("bachet_date");
                    if (bundle != null) {
                        Adidas adidas = (Adidas) bundle.getSerializable("obiect_adidas");
                        if (adidas != null) {
                            tvAfisare.setText(adidas.toString());
                            Toast.makeText(this, "Produs: " + adidas.getModel(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdauga = findViewById(R.id.btnAdauga);
        tvAfisare = findViewById(R.id.tvAfisare);

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PreluareDateAdidas.class);
            launcher.launch(intent);
        });
    }
}