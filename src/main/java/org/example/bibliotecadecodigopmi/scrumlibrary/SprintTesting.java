package org.example.bibliotecadecodigopmi.scrumlibrary;

import java.io.Serializable;

public class SprintTesting extends Sprint implements Serializable {
    private int casosDePrueba;

    public SprintTesting(int numero, String objetivo, int duracionEnSemanas, int casosDePrueba, String nombre) {
        super(numero, objetivo, duracionEnSemanas, nombre);
        this.casosDePrueba = casosDePrueba;
    }
    public void setCasosDePrueba(int casosDePrueba){
        this.casosDePrueba=casosDePrueba;
    }
    public int getCasosDePrueba(){
        return casosDePrueba;
    }
    public void setDuracionEnSemanas(int duracionEnSemanas) {
        this.duracionEnSemanas = duracionEnSemanas;
    }
    public int getDuracionEnSemanas() {
        return duracionEnSemanas;
    }
    public void ejecutar() {
        System.out.println("Ejecutando Sprint de Testing...");
        // Implementación específica para Sprint de Testing
    }
}
