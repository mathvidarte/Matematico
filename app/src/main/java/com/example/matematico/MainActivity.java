package com.example.matematico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView operacion;
    private EditText respuesta;
    private Button responder;
    //private String question;
    //private int answer;

    ArrayList <Pregunta> preguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacion = findViewById(R.id.operacion);
        respuesta = findViewById(R.id.respuesta);
        responder = findViewById(R.id.responder);

        preguntas = new ArrayList<>();
        for (int i = 0; i<20; i++) {
            preguntas.add(new Pregunta());
            preguntas.get(i).operacion();
            operacion.setText(""+preguntas.get(i).getQuestion());
        }

        responder.setOnClickListener(
                (view) -> {

                    String respuestas = respuesta.getText().toString();

                    for (int i = 0; i<20; i++) {
                        if (preguntas.get(i).getQuestion().equals(respuestas)) {
                            preguntas.get(i).operacion();
                            operacion.setText(""+preguntas.get(i).getQuestion());
                        } else {

                        }

                    }

                }
        );




    }



}