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

public class Pract5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pract5);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etEdad = findViewById(R.id.etEdad);
        EditText etCorreo = findViewById(R.id.etCorreo);
        Button btnEnviarDatos = findViewById(R.id.btnEnviarDatos);

        btnEnviarDatos.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String edad = etEdad.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();

            if (nombre.isEmpty()) {
                etNombre.setError("Ingresa tu nombre");
            } else if (edad.isEmpty()) {
                etEdad.setError("Ingresa tu edad");
            } else if (correo.isEmpty()) {
                etCorreo.setError("Ingresa tu correo");
            } else {
                // Crear objeto Parcelable y enviarlo a RecepDatos
                UsuarioParcelable usuario = new UsuarioParcelable(nombre, edad, correo);

                Intent intent = new Intent(Pract5.this, RecepDatos.class);
                intent.putExtra("usuario_parcelable", usuario);
                startActivity(intent);
            }
        });
    }
}
