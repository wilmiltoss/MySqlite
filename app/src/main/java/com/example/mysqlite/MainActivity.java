package com.example.mysqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = findViewById(R.id.btn_registrar);

        ConexionSqlite conn = new ConexionSqlite(this, "prueba_android.sqlite",null,1);

    }

    public void onclick(View view) {
        Intent miIntent = null;
        switch (view.getId()){
            case R.id.btn_registrar:
                miIntent=new Intent(MainActivity.this,RegistrarCiudad.class);
                startActivity(miIntent);
                break;
            case R.id.btn_listar_ciudad:
                miIntent=new Intent(MainActivity.this,ConsultarCiudad.class);
                startActivity(miIntent);
                break;
            case R.id.btn_consultar:
                miIntent=new Intent(MainActivity.this,ConsultarUnaCiudad.class);
                startActivity(miIntent);
                break;

        }
    }
}