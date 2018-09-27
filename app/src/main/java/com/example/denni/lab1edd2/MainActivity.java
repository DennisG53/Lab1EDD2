package com.example.denni.lab1edd2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_STORAGE = 1000;
    private static final int READ_REQUEST_CODE = 42;

    //ListView Lista;
    Button btnCargar;
    Button btnDescompresion;
    TextView tvLectura;
    TextView tvDescompresion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pidiendo permiso para manejar almacenamiento externo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_STORAGE);
        }

        btnCargar = (Button) findViewById(R.id.btnCargar);
        tvLectura = (TextView) findViewById(R.id.tvLectura);


        tvDescompresion = (TextView) findViewById(R.id.tvDescompresion);

        String prueba = "wabbawabba";
        lzw.Compresion(prueba);
        List<Integer> p= new ArrayList<Integer>();
        p=lzw.Compresion(prueba);
        String h= p.toString();
        int x=0;

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performFileSearch(); //1

            }
        });



       // lzw.Compresion(readText(tvLectura));
        int a=0;
    }

    //Con esto se lee el contenido del archivo seleccionado
    private String readText(String input)
    {


        //FileReader f = new FileReader(input);
        File file = new File(input);
        StringBuilder text = new StringBuilder();
        int a=0;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine())!=null)
            {
                text.append(line);
                text.append("\n");
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return text.toString();

    }

    //Seleccionar los archivos desde el storage
    private void performFileSearch() //2
    {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent,READ_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            if (data != null)
            {
                Uri uri = data.getData();
                String path = uri.getPath();
                path = path.substring(path.indexOf(":") + 1);
                Toast.makeText(this,""+path,Toast.LENGTH_SHORT).show();



                String texto=readText(path);
                lzw.Compresion(texto);
                List<Integer> p= new ArrayList<Integer>();
                p=lzw.Compresion(texto);
                String resultadoCompresion= p.toString();
                //char a[] = resultadoCompresion.toCharArray();

                tvLectura.setText(resultadoCompresion);

                List<Integer> lista= new ArrayList<Integer>();
                lista=lzw.Compresion(texto);
                String resultadoDescompresion= p.toString();
                lzw.Descompresion(p);
                tvDescompresion.setText(resultadoCompresion);


            }
        }
    }

    //permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_STORAGE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"Permiso Otorgado",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Permiso Denegado",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
