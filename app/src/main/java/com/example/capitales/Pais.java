package com.example.capitales;

public class Pais {

    private String continente;
    private String nombre;
    private String capital;
    private String bandera;
    public Pais(String continente, String nombre, String capital)
    {
        this.continente = continente;
        this.nombre = nombre;
        this.capital = capital;
    }
    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

}
