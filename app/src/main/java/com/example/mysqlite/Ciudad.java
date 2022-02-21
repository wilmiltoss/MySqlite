package com.example.mysqlite;

public class Ciudad {

    private Integer CodCiudad;
    private String NombreCiudad;
    private Integer Poblacion;

    public Ciudad(Integer codCiudad, String nombreCiudad, Integer poblacion) {
        CodCiudad = codCiudad;
        NombreCiudad = nombreCiudad;
        Poblacion = poblacion;
    }

    public Integer getCodCiudad() {
        return CodCiudad;
    }

    public void setCodCiudad(Integer codCiudad) {
        CodCiudad = codCiudad;
    }

    public String getNombreCiudad() {
        return NombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        NombreCiudad = nombreCiudad;
    }

    public Integer getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        Poblacion = poblacion;
    }
}
