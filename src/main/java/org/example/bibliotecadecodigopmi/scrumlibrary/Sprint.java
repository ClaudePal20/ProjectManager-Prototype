package org.example.bibliotecadecodigopmi.scrumlibrary;

import java.io.Serializable;

public abstract class Sprint implements Serializable,DatosGenerales{
    protected int numero;
    protected String objetivo;
    protected int duracionEnSemanas;
    protected String nombre;

    public Sprint(int numero, String objetivo, int duracionEnSemanas, String nombre) {
        this.numero = numero;
        this.objetivo = objetivo;
        this.duracionEnSemanas = duracionEnSemanas;
        this.nombre = nombre;
    }
    public int setSemanas(int duracionEnSemanas) {
        return this.duracionEnSemanas = duracionEnSemanas;
    }
    public int getSemanas() {
        return duracionEnSemanas;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }
    public String getNombre(){
        return nombre;
    }
    public String getObjetivo(){return objetivo;}
    public void setObjetivo(String objetivo){this.objetivo = objetivo;}
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}

