package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SprintPlanificacionTest {

    @Test
    public void testGetEntregables() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        ArrayList<String> entregables = new ArrayList<>();
        entregables.add("Entregable 1");
        entregables.add("Entregable 2");
        String nombre = "Sprint 1";

        SprintPlanificacion sprintPlanificacion = new SprintPlanificacion(numero, objetivo, duracionEnSemanas, entregables, nombre);

        assertEquals(entregables, sprintPlanificacion.getEntregables());
    }

    @Test
    public void testAddEntregable() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        ArrayList<String> entregables = new ArrayList<>();
        String nombre = "Sprint 1";

        SprintPlanificacion sprintPlanificacion = new SprintPlanificacion(numero, objetivo, duracionEnSemanas, entregables, nombre);

        String nuevoEntregable = "Nuevo Entregable";
        sprintPlanificacion.addEntregable(nuevoEntregable);

        assertTrue(sprintPlanificacion.getEntregables().contains(nuevoEntregable));
    }

    @Test
    public void testSetEntregables() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        ArrayList<String> entregables = new ArrayList<>();
        String nombre = "Sprint 1";

        SprintPlanificacion sprintPlanificacion = new SprintPlanificacion(numero, objetivo, duracionEnSemanas, entregables, nombre);

        ArrayList<String> nuevosEntregables = new ArrayList<>();
        nuevosEntregables.add("Entregable 1");
        nuevosEntregables.add("Entregable 2");

        sprintPlanificacion.setEntregables(nuevosEntregables);

        assertEquals(nuevosEntregables, sprintPlanificacion.getEntregables());
    }

    @Test
    public void testEjecutar() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        ArrayList<String> entregables = new ArrayList<>();
        String nombre = "Sprint 1";

        SprintPlanificacion sprintPlanificacion = new SprintPlanificacion(numero, objetivo, duracionEnSemanas, entregables, nombre);

        assertDoesNotThrow(sprintPlanificacion::ejecutar);
    }
}
