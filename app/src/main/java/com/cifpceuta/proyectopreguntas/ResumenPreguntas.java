package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ResumenPreguntas extends AppCompatActivity {
    TextView result;
    private MiAdapter miAdapter;
    ListView lista;

    int resultado;
    int contador;

    private ImageButton volver;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalizado_layout);
        result=(TextView) findViewById(R.id.tvResultado);
        volver = findViewById(R.id.volver);

        Intent i = this.getIntent();

        resultado = i.getIntExtra("result",0);


        contador = i.getIntExtra("contador",0);

        Preguntas[] preguntas = (Preguntas[])getIntent().getSerializableExtra("preguntasArray");

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    // Código para cambiar a otra actividad al presionar el botón
                    Intent intent = new Intent(ResumenPreguntas.this, MainActivity.class);
                    startActivity(intent);

            }
        });




        result.setText("Resultados: "+String.valueOf(resultado) + " de: " + contador);


        miAdapter = new MiAdapter(this,preguntas);

        lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(miAdapter);


        for (int j=0;j<preguntas.length;j++){
            Log.i("i: ",preguntas[j].getPregunta());
        }

    }
}