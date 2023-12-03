package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contadorPregunta;
    private TextView pregunta;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Button siguiente;




    private Preguntas[] preguntas = {
            new Preguntas("¿Cual es la capital de Francia? ", "Paris", "El Cairo", "Inflater", 1),
            new Preguntas("¿Qué es el titanic?", "Un barco", "Un señor", "Un plato de puchero", 1),
            new Preguntas("¿Donde se situa la estatua de la libertad?", "Marruecos", "Móstoles", "EEUU", 1),
            new Preguntas("¿Cual fue el primer Smartphone?", "Honda", "Apple", "Modas Paqui", 2),
            new Preguntas("¿Donde fue detonada la primera bomba atómica?", "En Madrid", "En el oceano", "En Japón", 2),
            new Preguntas("¿Que significa 'loop' en inglés?", "Hasta mañana", "Me duelen las extremidades", "Bucle", 3)

    };
    private int cont = 0;
    public int aciertos = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorPregunta = findViewById(R.id.contadorPregunta);
        pregunta = findViewById(R.id.pregunta);
        radioGroup = findViewById(R.id.grupoBoton);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        siguiente = findViewById(R.id.botonSiguiente);

        siguientePregunta();

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton1.isChecked()){
                    if (preguntas[cont].getPreguntaCorrecta()==1){
                        preguntas[cont].setCorrecta(true);
                        aciertos++;
                    }
                } else if (radioButton2.isChecked()) {
                    if (preguntas[cont].getPreguntaCorrecta()==2){
                        preguntas[cont].setCorrecta(true);
                        aciertos++;
                    }

                } else if (radioButton3.isChecked()) {
                    if (preguntas[cont].getPreguntaCorrecta()==3){
                        preguntas[cont].setCorrecta(true);
                        aciertos++;
                    }

                }

                    cont++;
                mostrarSiguientePregunta(v);


            }
        });

    }

    private void mostrarSiguientePregunta(View v){



        if (cont==preguntas.length-1){
            siguiente.setText("Resultados");

        }
        if (cont==preguntas.length){
            resultadoFinal(v);

        }else {
            siguientePregunta();
        }
    }

    private void siguientePregunta() {
        contadorPregunta.setText("Pregunta Num: " + (cont + 1)+" de "+preguntas.length );
        pregunta.setText(preguntas[cont].getPregunta());
        radioButton1.setText(preguntas[cont].getRespuesta1());
        radioButton2.setText(preguntas[cont].getRespuesta2());
        radioButton3.setText(preguntas[cont].getRespuesta3());
        radioGroup.clearCheck();



    }

    public void resultadoFinal(View view) {
        Intent i = new Intent(this, ResumenPreguntas.class);
        i.putExtra("result",aciertos);
        i.putExtra("contador",cont);
        i.putExtra("preguntasArray",preguntas);
        startActivity(i);

    }







}