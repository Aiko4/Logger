package com.example.logger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Session extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.session);

        Button btn = findViewById(R.id.logOut);
        TextView welcome = findViewById(R.id.welcomeLayout);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String user = bundle.getString("user");
            welcome.setText("Welcome back, " + user);
        }

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(Session.this, LogOut.class);
            startActivity(intent);
            finish();
        });

    }
}
