package com.example.ilie_diana_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String raspuns = data.getStringExtra("raspuns_mesaj");
                    int suma = data.getIntExtra("suma", 0);
                    // Afișează Toast cu rezultatul primit înapoi (Punctul 11)
                    Toast.makeText(this, raspuns + " | Suma este: " + suma, Toast.LENGTH_LONG).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = findViewById(R.id.btnOpenThird);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

            Bundle bundle = new Bundle();
            bundle.putString("mesaj", "Salut din Activitatea 2!");
            bundle.putInt("numar1", 15);
            bundle.putInt("numar2", 25);
            intent.putExtras(bundle);

            launcher.launch(intent);
        });
    }
}