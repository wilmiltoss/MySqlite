package com.example.mysqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mysqlite.databinding.ActivityConsultarCiudadBinding;

public class ConsultarCiudad extends AppCompatActivity {

    ConexionSqlite conn;
    private ListView textViewPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_ciudad);

        conn = new ConexionSqlite(getApplicationContext(), "prueba_android.sqlite", null, 1);
        textViewPanel = (ListView) findViewById(R.id.textViewPanel);
        llenaListView();


    }

    public void llenaListView(){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylistado,cargar());//myListado =cambio manual del tamaño list
        textViewPanel.setAdapter(adapter);
    }

    public String []cargar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT "+Utilidades.CAMPO_COD_CIUDAD+","+
                        Utilidades.CAMPO_NOMBRE_CIUDAD + ", " +
                        Utilidades.CAMPO_POBLACION
                        + " FROM " + Utilidades.TABLA_CIUDAD
                , null);
        String[] listado = new String[cursor.getCount()];//arreglo string que trae el listado
        int post = 0;
        if (cursor.moveToFirst()) {//si tenemo al menos 1 reg lo recorremos
            do {
                String codCiudad = cursor.getString(0);
                String NombreCiudad = cursor.getString(1);
                String Poblacion = cursor.getString(2);
                listado[post] =codCiudad +"-"+ NombreCiudad + " - "+Poblacion;
                post++;

            } while (cursor.moveToNext());
        }
        return listado;
    }
}