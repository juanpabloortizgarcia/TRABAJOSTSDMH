package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class enviodatos extends AppCompatActivity {

    private EditText etNombre, etEdad;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enviodatos);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String edad = etEdad.getText().toString().trim();

            if (nombre.isEmpty()) {
                etNombre.setError("Por favor ingresa tu nombre");
            } else if (edad.isEmpty()) {
                etEdad.setError("Por favor ingresa tu edad");
            } else {
                String mensaje = "Bienvenido " + nombre + ", Edad: " + edad;
                Toast.makeText(enviodatos.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}
