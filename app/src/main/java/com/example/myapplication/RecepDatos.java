package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecepDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recep_datos);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvEdad = findViewById(R.id.tvEdad);
        TextView tvCorreo = findViewById(R.id.tvCorreo);

        // Recibir el objeto Parcelable enviado desde Pract5
        UsuarioParcelable usuario = getIntent().getParcelableExtra("usuario_parcelable");
        if (usuario != null) {
            tvNombre.setText("Nombre: " + usuario.getNombre());
            tvEdad.setText("Edad: " + usuario.getEdad());
            tvCorreo.setText("Correo: " + usuario.getCorreo());
        } else {
            tvNombre.setText("Nombre: No disponible");
            tvEdad.setText("Edad: No disponible");
            tvCorreo.setText("Correo: No disponible");
        }
    }
}
