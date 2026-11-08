package com.example.logger;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogIn extends AppCompatActivity {
    private static final String TAG = "CICLE_VIDA";

    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.userCredential);
        password = findViewById(R.id.passCredential);

        TextView error = findViewById(R.id.error);
        Button btnLog = findViewById(R.id.button);
        btnLog.setOnClickListener(v -> {

            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (user.isEmpty() || pass.isEmpty()) {
                error.setVisibility(VISIBLE); // aixo permet que sigui visible si els camps estan buits
                error.setText("Incorrect username or password");
            } else {
                Intent intent = new Intent(LogIn.this, Session.class);

                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    @Override  // resetejem els camps de username i password per a quan es torna a la pantalla principal
    protected void onResume() {
        super.onResume();

        username.setText("");
        password.setText("");
    }
}