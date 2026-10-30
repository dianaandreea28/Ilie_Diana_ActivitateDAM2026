package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AfisareAdidas extends AppCompatActivity {

    private ArrayList<Adidas> lista;
    private ArrayAdapter<Adidas> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_adidas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lvAfisare = findViewById(R.id.lvAfisare);

        lista = (ArrayList<Adidas>) getIntent().getSerializableExtra("lista_adidas");

        if (lista != null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            lvAfisare.setAdapter(adapter);

            lvAfisare.setOnItemClickListener((parent, view, position, id) -> {
                Adidas adidasSelectat = lista.get(position);
                Toast.makeText(this, adidasSelectat.toString(), Toast.LENGTH_SHORT).show();
            });

            lvAfisare.setOnItemLongClickListener((parent, view, position, id) -> {
                Adidas adidasSters = lista.remove(position);
                adapter.notifyDataSetChanged();

                Intent intentReturn = new Intent();
                intentReturn.putExtra("lista_actualizata", lista);
                setResult(RESULT_OK, intentReturn);

                Toast.makeText(this, "A fost șters produsul: " + adidasSters.getModel(), Toast.LENGTH_SHORT).show();
                return true;
            });
        }
    }
}