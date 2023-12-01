package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class ResumenPreguntas extends AppCompatActivity {
    TextView result;
    private MiAdapter miAdapter;
    ListView lista;

    int resultado;
    int contador;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalizado_layout);
        result=(TextView) findViewById(R.id.tvResultado);

        Intent i = this.getIntent();

        resultado = i.getIntExtra("result",0);


        contador = i.getIntExtra("contador",0);

        Preguntas[] preguntas = (Preguntas[])getIntent().getSerializableExtra("preguntasArray");




        result.setText("Resultados: "+String.valueOf(resultado) + " de: " + contador);


        miAdapter = new MiAdapter(this,preguntas);

        lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(miAdapter);


        for (int j=0;j<preguntas.length;j++){
            Log.i("i: ",preguntas[j].getPregunta());
        }

    }
}