package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tarea1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tarea1);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etEdad = findViewById(R.id.etEdad);
        Button btnEnviarDatos = findViewById(R.id.btnEnviarDatos);

        btnEnviarDatos.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String edad = etEdad.getText().toString().trim();

            if (nombre.isEmpty()) {
                etNombre.setError("Por favor ingrese su nombre");
            } else if (edad.isEmpty()) {
                etEdad.setError("Por favor ingrese su edad");
            } else {
                Intent intent = new Intent(Tarea1.this, RecepciondeDatos.class);
                intent.putExtra("nombre_key", nombre);
                intent.putExtra("edad_key", edad);
                startActivity(intent);
            }
        });
    }
}
