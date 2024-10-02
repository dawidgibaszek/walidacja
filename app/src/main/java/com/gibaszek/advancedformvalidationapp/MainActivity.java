package com.gibaszek.advancedformvalidationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        EditText mail = findViewById(R.id.mail);
        EditText pass = findViewById(R.id.password);
        EditText repass = findViewById(R.id.retypepass);
        EditText phone = findViewById(R.id.phone);
        Button btn = findViewById(R.id.submit);

        btn.setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || surname.getText().toString().isEmpty()) {
                Toast.makeText(this, "Uzupełnij imie i nazwisko", Toast.LENGTH_LONG).show();
            }
            if (mail.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches()) {
                Toast.makeText(this, "Niepoprawny adres email", Toast.LENGTH_LONG).show();
            }
            if (phone.getText().toString().isEmpty() || phone.getText().toString().length() < 9) {
                Toast.makeText(this, "Niepoprawny numer telefonu", Toast.LENGTH_LONG).show();
            }
            if (pass.getText().toString().isEmpty() || pass.getText().length() < 6) {
                Toast.makeText(this, "Niepoprawna dlugosc hasla", Toast.LENGTH_LONG).show();
            }
            if(!pass.getText().toString().equals(repass.getText().toString())) {
                Toast.makeText(this, "Hasla nie sa takie same", Toast.LENGTH_LONG).show();
            }
        });

    }
}