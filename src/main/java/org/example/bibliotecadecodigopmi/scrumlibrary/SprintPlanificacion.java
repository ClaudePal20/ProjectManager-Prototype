package org.example.bibliotecadecodigopmi.scrumlibrary;
import java.io.Serializable;
import java.util.ArrayList;
public class SprintPlanificacion extends Sprint implements Serializable {

    //Aqui van los productos a entregar al final o bien las funcionalidades o requerimientos
    //a crear
    private ArrayList<String> entregables;

    public SprintPlanificacion(int numero, String objetivo, int duracionEnSemanas, ArrayList<String> entregables, String nombre) {
        super(numero, objetivo, duracionEnSemanas, nombre);
        this.entregables = entregables;
    }
    public ArrayList<String> getEntregables() {
        return entregables;
    }
    public void setEntregables(ArrayList<String> entregables) {
        this.entregables = entregables;
    }
    public void addEntregable(String entregable){
        entregables.add(entregable);
    }

    public void setDuracionEnSemanas(int duracionEnSemanas) {
        this.duracionEnSemanas = duracionEnSemanas;
    }
    public int getDuracionEnSemanas() {
        return duracionEnSemanas;
    }


    public void ejecutar() {
        System.out.println("Ejecutando Sprint de Planificacion...");
        // Implementación específica para Sprint de Planificacion
    }
}
