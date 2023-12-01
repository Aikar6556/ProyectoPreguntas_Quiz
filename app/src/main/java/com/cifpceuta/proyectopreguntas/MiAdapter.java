package com.cifpceuta.proyectopreguntas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MiAdapter extends ArrayAdapter<Preguntas>{

    private Activity context;
    Preguntas[] preguntas;

    TextView pregunta;
    TextView respuesta;
    public MiAdapter(Activity c, Preguntas[] pr){
        super(c,R.layout.pregunta_respondida_layout,pr);
        this.context=c;
        this.preguntas=pr;
    }

    @SuppressLint("MissingInflatedId")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();


        View rowView = inflater.inflate(R.layout.pregunta_respondida_layout,parent,false);

        Preguntas preguntas = this.preguntas[position];



        pregunta=(TextView) rowView.findViewById(R.id.pregunta);
        respuesta=(TextView) rowView.findViewById(R.id.respuestaDada);
        pregunta.setText(preguntas.getPregunta());



        if (preguntas.isCorrecta()){
            respuesta.setText("Correcta");


        }else {
            respuesta.setText("Erronea");

        }


        return rowView;
    }


}
