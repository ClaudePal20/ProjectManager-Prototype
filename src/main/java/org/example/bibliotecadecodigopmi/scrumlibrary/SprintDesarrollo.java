package org.example.bibliotecadecodigopmi.scrumlibrary;

import java.io.Serializable;

public class SprintDesarrollo extends Sprint implements Serializable {
    private int puntosDeHistoria;

    public SprintDesarrollo(int numero, String objetivo, int duracionEnSemanas, int puntosDeHistoria, String nombre) {
        super(numero, objetivo, duracionEnSemanas, nombre);
        this.puntosDeHistoria = puntosDeHistoria;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    public int getPuntosDeHistoria() {
        return puntosDeHistoria;
    }
    public void setPuntosDeHistoria(int puntosDeHistoria) {
        this.puntosDeHistoria = puntosDeHistoria;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public int getDuracionEnSemanas() {
        return duracionEnSemanas;
    }
    public void setDuracionEnSemanas(int duracionEnSemanas) {
        this.duracionEnSemanas = duracionEnSemanas;
    }

    public void ejecutar() {
        System.out.println("Ejecutando Sprint de Desarrollo...");
        // Implementación específica para Sprint de Desarrollo
    }
}
