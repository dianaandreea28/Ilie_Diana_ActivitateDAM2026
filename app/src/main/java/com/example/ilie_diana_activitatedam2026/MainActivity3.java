package com.example.ilie_diana_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Preia informațiile și le afișează (Punctul 9)
        Bundle extras = getIntent().getExtras();
        int n1 = 0, n2 = 0;
        if (extras != null) {
            String mesajPrimit = extras.getString("mesaj");
            n1 = extras.getInt("numar1", 0);
            n2 = extras.getInt("numar2", 0);
            Toast.makeText(this, "Am primit: " + mesajPrimit + " Valorile: " + n1 + " și " + n2, Toast.LENGTH_LONG).show();
        }

        final int val1 = n1;
        final int val2 = n2;

        // Trimite înapoi suma (Punctul 10)
        Button btnBack = findViewById(R.id.btnSendBack);
        btnBack.setOnClickListener(v -> {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("raspuns_mesaj", "Am calculat cu succes!");
            returnIntent.putExtra("suma", val1 + val2);

            setResult(RESULT_OK, returnIntent);
            finish(); // Închide fereastra și se întoarce la MainActivity2
        });
    }
}