package com.example.estudiante.leccionhander_ordonez;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Juego extends AppCompatActivity {

    String Nombre, Apellido ;
    TextView Puntaje, NombreCompleto , tres ,meta;
    Handler handler ;
    static int puntuacion =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        //ApellidoM.setTranslationY(ApellidoM.getY()+20);

        Nombre = getIntent().getStringExtra("NAME").toString();
        Apellido =getIntent().getStringExtra("LastName").toString();
        handler = new Handler();
        meta =  (TextView)findViewById(R.id.Meta);
       NombreCompleto = (TextView)findViewById(R.id.textView);
        NombreCompleto.setText(Nombre+Apellido);
        Puntaje = (TextView)findViewById(R.id.textPuntaje);
        tres = (TextView)findViewById(R.id.tres);


        final Thread thread = new Thread(){
            boolean puede = true ;
            @Override
            public void run() {
                for (int i = 0 ; i <20 ; i++){
                    try {
                        Thread.sleep(100);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (puede){
                                tres.setTranslationY(tres.getY()+5);
                                System.out.println("Se esta moviendo ");
                                if (tres.getY()> meta.getY() ){
                                    puntuacion = puntuacion+1;

                                    Puntaje.setText(""+puntuacion);
                                  puede = false;
                                    System.out.println(" "+tres.getY() + ""+meta.getY() );

                                }}

                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        };
        //sonido= MediaPlayer.create(EjecutarSonido.this, R.raw.nextel);
        //sonido.start();

        thread.start();
        //System.out.println(" "+tres.getY() + ""+meta.getY() );




    }


}
