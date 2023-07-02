package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SprintDesarrolloTest {

    @Test
    public void testGetPuntosDeHistoria() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        int puntosDeHistoria = 10;
        String nombre = "Sprint 1";
        SprintDesarrollo sprintDesarrollo = new SprintDesarrollo(numero, objetivo, duracionEnSemanas, puntosDeHistoria, nombre);
        assertEquals(puntosDeHistoria, sprintDesarrollo.getPuntosDeHistoria());
    }

    @Test
    public void testSetPuntosDeHistoria() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        int puntosDeHistoria = 10;
        String nombre = "Sprint 1";
        SprintDesarrollo sprintDesarrollo = new SprintDesarrollo(numero, objetivo, duracionEnSemanas, puntosDeHistoria, nombre);

        int newPuntosDeHistoria = 20;
        sprintDesarrollo.setPuntosDeHistoria(newPuntosDeHistoria);
        assertEquals(newPuntosDeHistoria, sprintDesarrollo.getPuntosDeHistoria());
    }

    @Test
    public void testEjecutar() {
        int numero = 1;
        String objetivo = "Objetivo 1";
        int duracionEnSemanas = 2;
        int puntosDeHistoria = 10;
        String nombre = "Sprint 1";
        SprintDesarrollo sprintDesarrollo = new SprintDesarrollo(numero, objetivo, duracionEnSemanas, puntosDeHistoria, nombre);

        assertDoesNotThrow(sprintDesarrollo::ejecutar);
    }
}
