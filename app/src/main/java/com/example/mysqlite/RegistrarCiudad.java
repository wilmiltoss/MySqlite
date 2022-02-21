package com.example.mysqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mysqlite.databinding.ActivityRegistrarCiudadBinding;

public class RegistrarCiudad extends AppCompatActivity {

    EditText CodCiudad, Nombre, Poblacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_ciudad);

        CodCiudad = findViewById(R.id.et_codCiudad);
        Nombre = findViewById(R.id.et_nombreCiudad);
        Poblacion = findViewById(R.id.et_poblacion);


    }

    private  void registrarCiudadsql(){
        ConexionSqlite conn = new ConexionSqlite(this, "prueba_android.sqlite",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        String insert = "insert into "+Utilidades.TABLA_CIUDAD
                +" ("+Utilidades.CAMPO_COD_CIUDAD+","+Utilidades.CAMPO_NOMBRE_CIUDAD+","+Utilidades.CAMPO_POBLACION+")" +
                "VALUES ("+CodCiudad.getText().toString()+",'"+Nombre.getText().toString()+"',"+Poblacion.getText().toString()+")";
        db.execSQL(insert);

        Toast.makeText(getApplicationContext(),"Ciudad registrada correctamente", Toast.LENGTH_LONG).show();


    }


    private void registrarCiudad(){

        ConexionSqlite conn = new ConexionSqlite(this, "prueba_android.sqlite ",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_COD_CIUDAD,CodCiudad.getText().toString() );
        values.put(Utilidades.CAMPO_NOMBRE_CIUDAD,Nombre.getText().toString() );
        values.put(Utilidades.CAMPO_POBLACION,Poblacion.getText().toString() );

        Long idResultante= db.insert(Utilidades.TABLA_CIUDAD,Utilidades.CAMPO_COD_CIUDAD,values);
        Toast.makeText(getApplicationContext(),"Id Resgistros"+idResultante, Toast.LENGTH_LONG).show();
        db.close();

    }

    public void onclick(View view) {
       // registrarCiudad();
        registrarCiudadsql();
    }
}