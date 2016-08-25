package com.example.estudiante.leccionhander_ordonez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IniciarJuego (View view){

        Intent intent = new Intent(MainActivity.this, Juego.class);
        EditText NombreM = (EditText) findViewById(R.id.name);
        EditText ApellidoM = (EditText) findViewById(R.id.lastname);


        intent.putExtra("NAME", NombreM.getText().toString());
        intent.putExtra("LastName", ApellidoM.getText().toString());
        startActivity(intent);

    }
}
