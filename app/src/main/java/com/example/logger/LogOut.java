package com.example.logger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LogOut extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.log_out);

        Button btn = findViewById(R.id.login);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(LogOut.this, LogIn.class);
            startActivity(intent);
        });
    }
}
