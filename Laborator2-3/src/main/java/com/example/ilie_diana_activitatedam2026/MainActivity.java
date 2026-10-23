package com.example.ilie_diana_activitatedam2026;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.v(TAG, "onCreate: Activitatea a fost creata (Verbose)");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Activitatea devine vizibila pe ecran (Info)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activitatea este interactiva si in prim-plan (Debug)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause: Activitatea este intrerupta (Warning)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: Activitatea nu mai este vizibila (Error)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy: Activitatea este distrusa complet (Verbose)");
    }
}