package com.example.matematico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
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
    private boolean btnPressed = false;

     Pregunta preguntas;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar
        operacion = findViewById(R.id.operacion);
        respuesta = findViewById(R.id.respuesta);
        responder = findViewById(R.id.responder);
        puntaje = findViewById(R.id.puntaje);
        numPuntaje = findViewById(R.id.numPuntaje);
        reloj =  findViewById(R.id.reloj);
        restart = findViewById(R.id.restart);



            preguntas = new Pregunta();
            preguntas.operaciones();
            operacion.setText(""+preguntas.getQuestion());


            //Hilo donde manejo el cronometro
        new Thread(
                () -> {
                    while (cont > 0) {
                        cont --;
                        //que lo corra en el hilo principal
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

        /*Se pinta pero como que no me daja leer el onClickListener :c
        responder.setOnTouchListener(
                (view, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:

                            responder.setBackgroundColor(Color.rgb(29,119,179));


                            break;

                        case MotionEvent.ACTION_UP:
                            responder.setBackgroundColor( Color.rgb(22, 92, 138));
                            break;
                    }
                    return true;
                }
        ); */



        //Boton de responder
        responder.setOnClickListener(
                (view) -> {

                    String respuestas = respuesta.getText().toString();

                 //Validación respuesta
                        if (preguntas.getAnswer().equals(respuestas)) {
                            //Correcto
                            preguntas.operaciones();
                            operacion.setText(""+preguntas.getQuestion());
                            puntajes += 10;
                            numPuntaje.setText(""+puntajes);

                        } else {
                            //Incorrecto
                            if (puntajes > 0) {
                                puntajes -= 10;
                                numPuntaje.setText(""+puntajes);
                            }


                        }


                    respuesta.setText("");



                }

        );






        //Boton Volver a intentar
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



                            preguntas.operaciones();
                            operacion.setText("" + preguntas.getQuestion());



                    numPuntaje.setText(""+puntajes);
                    respuesta.setText(" ");




                })
        );






    }



}