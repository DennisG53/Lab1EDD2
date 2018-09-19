package com.example.denni.lab1edd2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnLeer;
    Button btnBuscador;
    EditText txtPath;
    TextView txtvResultado;



    ListView Lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeer = (Button)findViewById(R.id.btnLeer);
        btnBuscador = (Button)findViewById(R.id.btnBuscador);
        txtPath = (EditText)findViewById(R.id.txtPath);
        txtvResultado = (TextView)findViewById(R.id.txtvResultado);

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CambiarActividad(view);
            }
        });

    }

    public void CambiarActividad(View view)
    {
        Intent ventana = new Intent(this,FileChooser.class);
        startActivity(ventana);
    }







}
