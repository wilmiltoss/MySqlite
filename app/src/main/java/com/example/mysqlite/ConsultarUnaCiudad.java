package com.example.mysqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

import com.example.mysqlite.databinding.ActivityConsultarUnaCiudadBinding;

public class ConsultarUnaCiudad extends AppCompatActivity {
    EditText codCiudad_c, nombreCiudad_c,poblacion_c;
    ConexionSqlite conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_una_ciudad);

        conn=new ConexionSqlite(getApplicationContext(),"prueba_android.sqlite",null,1);

        codCiudad_c = findViewById(R.id.et_codCiudad_c);
        nombreCiudad_c = findViewById(R.id.et_nombreCiudad_c);
        poblacion_c = findViewById(R.id.et_poblacion_c);


    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.btn_consultar_c:
                consultarCiudad();
                break;
            case R.id.btn_actualizar_c:
                actualizarCiudad();
                break;
            case R.id.btn_eliminar_c:
                eliminarCiudad();
                break;

        }
    }

    private void eliminarCiudad() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {codCiudad_c.getText().toString()};
;
        db.delete(Utilidades.TABLA_CIUDAD, Utilidades.CAMPO_COD_CIUDAD+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se elimino la ciudad",Toast.LENGTH_SHORT).show();
        limpiar();
        db.close();
    }

    private void actualizarCiudad() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {codCiudad_c.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(Utilidades.CAMPO_NOMBRE_CIUDAD,nombreCiudad_c.getText().toString());
        valores.put(Utilidades.CAMPO_POBLACION,poblacion_c.getText().toString());
        db.update(Utilidades.TABLA_CIUDAD,valores, Utilidades.CAMPO_COD_CIUDAD+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se actualizo la ciudad",Toast.LENGTH_SHORT).show();
        db.close();

    }

    private void consultarCiudad() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {codCiudad_c.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE_CIUDAD, Utilidades.CAMPO_POBLACION};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_CIUDAD, campos, Utilidades.CAMPO_COD_CIUDAD + "=?", parametros, null, null, null);
            cursor.moveToFirst();

            nombreCiudad_c.setText(cursor.getString(0));
            poblacion_c.setText(cursor.getString(1));
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El codigo no existe", Toast.LENGTH_LONG).show();
           limpiar();
        }



    }

    private void limpiar() {
        codCiudad_c.setText("");
        nombreCiudad_c.setText("");
        poblacion_c.setText("");
    }
}