package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SprintTest {

    @Test
    public void testSetSemanas() {
        int numero = 1;
        String objetivo = "Objetivo del sprint";
        int duracionEnSemanas = 2;
        String nombre = "Sprint 1";

        Sprint sprint = new SprintImpl(numero, objetivo, duracionEnSemanas, nombre);

        int nuevasSemanas = 3;
        int result = sprint.setSemanas(nuevasSemanas);

        assertEquals(nuevasSemanas, result);
        assertEquals(nuevasSemanas, sprint.getSemanas());
    }

    @Test
    public void testGetNumero() {
        int numero = 1;
        String objetivo = "Objetivo del sprint";
        int duracionEnSemanas = 2;
        String nombre = "Sprint 1";

        Sprint sprint = new SprintImpl(numero, objetivo, duracionEnSemanas, nombre);

        assertEquals(numero, sprint.getNumero());
    }

    @Test
    public void testGetNombre() {
        int numero = 1;
        String objetivo = "Objetivo del sprint";
        int duracionEnSemanas = 2;
        String nombre = "Sprint 1";

        Sprint sprint = new SprintImpl(numero, objetivo, duracionEnSemanas, nombre);

        assertEquals(nombre, sprint.getNombre());
    }

    @Test
    public void testGetObjetivo() {
        int numero = 1;
        String objetivo = "Objetivo del sprint";
        int duracionEnSemanas = 2;
        String nombre = "Sprint 1";

        Sprint sprint = new SprintImpl(numero, objetivo, duracionEnSemanas, nombre);

        assertEquals(objetivo, sprint.getObjetivo());
    }

    @Test
    public void testSetObjetivo() {
        int numero = 1;
        String objetivo = "Objetivo del sprint";
        int duracionEnSemanas = 2;
        String nombre = "Sprint 1";

        Sprint sprint = new SprintImpl(numero, objetivo, duracionEnSemanas, nombre);

        String nuevoObjetivo = "Nuevo objetivo del sprint";
        sprint.setObjetivo(nuevoObjetivo);

        assertEquals(nuevoObjetivo, sprint.getObjetivo());
    }

    @Test
    public void testSetNombre() {
        int numero = 1;
        String objetivo = "Objetivo del sprint";
        int duracionEnSemanas = 2;
        String nombre = "Sprint 1";

        Sprint sprint = new SprintImpl(numero, objetivo, duracionEnSemanas, nombre);

        String nuevoNombre = "Nuevo nombre del sprint";
        sprint.setNombre(nuevoNombre);

        assertEquals(nuevoNombre, sprint.getNombre());
    }

    private static class SprintImpl extends Sprint {
        public SprintImpl(int numero, String objetivo, int duracionEnSemanas, String nombre) {
            super(numero, objetivo, duracionEnSemanas, nombre);
        }
    }
}
