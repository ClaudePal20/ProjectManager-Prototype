package org.example.bibliotecadecodigopmi.scrumlibrary;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Tarea implements Serializable {
    private String Nombre;
    private LocalDate FechaDeInicio;
    private LocalDate FechaDeTerminado;
    private String Descripcion;
    private List<Recurso> recursos;
    private Boolean completado;
    public Tarea(String Nombre, LocalDate FechaDeInicio, LocalDate FechaDeTerminado, String Descripcion, Boolean completado) {
        this.Nombre = Nombre;
        this.FechaDeInicio = FechaDeInicio;
        this.FechaDeTerminado = FechaDeTerminado;
        this.Descripcion= Descripcion;
        this.recursos = new ArrayList<>();
        this.completado = completado;
    }
    public String getNombre() {
        return Nombre;
    }
    public LocalDate getFechaDeInicio() {
        return this.FechaDeInicio;
    }
    public LocalDate getFechaDeTerminado() {
        return this.FechaDeTerminado;
    }
    public void setResources(Recurso recurso) {
        this.recursos.add(recurso);
    }
    public List<Recurso> getResources() {
        return recursos;
    }

    @Override
    public String toString() {
        return Nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setNombre(String text) {
        this.Nombre = text;
    }
    public void setFechaDeInicio(LocalDate value) {
        this.FechaDeInicio = value;
    }
    public void setFechaDeTerminado(LocalDate value) {
        this.FechaDeTerminado = value;
    }
    public void setDescripcion(String text) {
        this.Descripcion = text;
    }
    public void setCompletado(boolean value) {
        this.completado = value;
    }
    public boolean getCompletado() {
        return completado;
    }

    public boolean getEstado() {
        return completado;
    }
}

