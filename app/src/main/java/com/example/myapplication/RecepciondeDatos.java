package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecepciondeDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recepcionde_datos);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvEdad = findViewById(R.id.tvEdad);
        TextView tvMensaje = findViewById(R.id.tvMensaje);

        // Recibir los datos enviados desde Tarea1
        String nombre = getIntent().getStringExtra("nombre_key");
        String edadStr = getIntent().getStringExtra("edad_key");

        if (nombre != null) {
            tvNombre.setText("El nombre proporcionado es: " + nombre);
        } else {
            tvNombre.setText("El nombre proporcionado es: Desconocido");
        }

        if (edadStr != null && !edadStr.isEmpty()) {
            tvEdad.setText("Edad: " + edadStr);
            try {
                int edad = Integer.parseInt(edadStr);
                if (edad < 18) {
                    tvMensaje.setText("eres menor de edad");
                } else {
                    tvMensaje.setText("eres mayor de edad bienvenido");
                }
            } catch (NumberFormatException e) {
                tvMensaje.setText("Edad no válida");
            }
        } else {
            tvEdad.setText("Edad: No proporcionada");
            tvMensaje.setText("");
        }
    }
}
