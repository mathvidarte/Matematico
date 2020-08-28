package com.example.matematico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView operacion;
    private EditText respuesta;
    private Button responder;
    private TextView puntaje;
    private TextView numPuntaje;
    private TextView reloj;
    private Button restart;

    // Int
    private int puntajes = 0;
    private  int cont = 30;

    ArrayList <Pregunta> preguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacion = findViewById(R.id.operacion);
        respuesta = findViewById(R.id.respuesta);
        responder = findViewById(R.id.responder);
        puntaje = findViewById(R.id.puntaje);
        numPuntaje = findViewById(R.id.numPuntaje);
        reloj =  findViewById(R.id.reloj);
        restart = findViewById(R.id.restart);

        preguntas = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            preguntas.add(new Pregunta());
            preguntas.get(i).operaciones();
            operacion.setText(""+preguntas.get(i).getQuestion());
        }

        new Thread(
                () -> {
                    while (cont > 0) {
                        cont --;
                        runOnUiThread(() -> {
                            reloj.setText(""+cont);
                            if (cont > 0) {
                                restart.setVisibility(View.GONE);
                            } else {
                                restart.setVisibility(View.VISIBLE);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();

        responder.setOnClickListener(
                (view) -> {

                    String respuestas = respuesta.getText().toString();

                    for (int i = 0; i < preguntas.size(); i++) {
                        if (preguntas.get(i).getAnswer().equals(respuestas)) {
                            //Correcto
                            preguntas.get(i).operaciones();
                            operacion.setText(""+preguntas.get(i).getQuestion());
                            puntajes += 10;
                            numPuntaje.setText(""+puntajes);
                            respuesta.setText(" ");
                        } else {
                            //Incorrecto
                            

                        }
                       // Log.e("cuenta", ""+preguntas.get(i).getAnswer());
                    }



                }

        );

        restart.setOnClickListener(
                (view -> {

                    puntajes = 0;
                    cont = 30;

                    new Thread(
                            () -> {
                                while (cont > 0) {
                                    cont --;
                                    runOnUiThread(() -> {
                                        reloj.setText(""+cont);
                                        if (cont > 0) {
                                            restart.setVisibility(View.GONE);
                                        } else {
                                            restart.setVisibility(View.VISIBLE);
                                        }
                                    });
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }


                    ).start();

                    String respuestas = respuesta.getText().toString();

                    for (int i = 0; i < preguntas.size(); i++) {

                            preguntas.get(i).operaciones();
                            operacion.setText("" + preguntas.get(i).getQuestion());
                        }

                    numPuntaje.setText(""+puntajes);
                    respuesta.setText(" ");




                })
        );






    }



}