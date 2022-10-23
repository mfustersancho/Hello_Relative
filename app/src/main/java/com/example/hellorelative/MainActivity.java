package com.example.hellorelative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "actual_count";

    private Button btnCount;
    private Button btnToast;
    private TextView txtCount;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCount = findViewById(R.id.button_count);
        btnToast = findViewById(R.id.button_toast);
        txtCount = findViewById(R.id.show_count);

        btnCount.setOnClickListener(e -> { upCount(); });
        btnToast.setOnClickListener(e -> { showToast(); });

        if(savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT);
        }

        updateCounter();
    }

    @Override
    protected void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putInt(KEY_COUNT, count);
    }

    private void upCount() {
        if(++count > 9) {
            count = 0;
        }
        updateCounter();
    }

    private void updateCounter() {
        txtCount.setText(String.valueOf(count));
    }

    private void showToast() {
        Toast
                .makeText(this, "Contador: " + String.valueOf(count), Toast.LENGTH_SHORT)
                .show();
    }

}