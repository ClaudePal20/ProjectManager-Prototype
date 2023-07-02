package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SprintTestingTest {

    @Test
    public void testGetCasosDePrueba() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        int casosDePrueba = 10;
        String nombre = "Sprint 1";

        SprintTesting sprintTesting = new SprintTesting(numero, objetivo, duracionEnSemanas, casosDePrueba, nombre);

        assertEquals(casosDePrueba, sprintTesting.getCasosDePrueba());
    }

    @Test
    public void testSetCasosDePrueba() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        int casosDePrueba = 10;
        String nombre = "Sprint 1";

        SprintTesting sprintTesting = new SprintTesting(numero, objetivo, duracionEnSemanas, casosDePrueba, nombre);

        int nuevosCasosDePrueba = 15;
        sprintTesting.setCasosDePrueba(nuevosCasosDePrueba);

        assertEquals(nuevosCasosDePrueba, sprintTesting.getCasosDePrueba());
    }

    @Test
    public void testEjecutar() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        int casosDePrueba = 10;
        String nombre = "Sprint 1";

        SprintTesting sprintTesting = new SprintTesting(numero, objetivo, duracionEnSemanas, casosDePrueba, nombre);

        assertDoesNotThrow(sprintTesting::ejecutar);
    }
}
