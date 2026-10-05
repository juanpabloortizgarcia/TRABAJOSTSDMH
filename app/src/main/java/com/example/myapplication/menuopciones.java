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

public class menuopciones extends AppCompatActivity {

    private EditText etNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menuopciones);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Recibir parámetro si viene de otra actividad
        String nombreParam = getIntent().getStringExtra("nombre_param");
        if (nombreParam != null && !nombreParam.isEmpty()) {
            etNombre.setText(nombreParam);
        }

        btnEnviar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                etNombre.setError("Por favor ingresa tu nombre");
            } else {
                String mensaje = "Bienvenido " + nombre;
                Toast.makeText(menuopciones.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}
