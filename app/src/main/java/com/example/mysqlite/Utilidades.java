package com.example.mysqlite;

public class Utilidades {
    public static final String TABLA_CIUDAD = "ciudad";
    public static final String CAMPO_COD_CIUDAD = "codCiudad";
    public static final String CAMPO_NOMBRE_CIUDAD = "nombreCiudad";
    public static final String CAMPO_POBLACION = "poblacion";


    public static final   String CREAR_TABLA_CIUDAD = "CREATE TABLE "+TABLA_CIUDAD+" ("+CAMPO_COD_CIUDAD+" INTEGER, "+CAMPO_NOMBRE_CIUDAD+" TEXT, "+CAMPO_POBLACION+" TEXT)";
}
