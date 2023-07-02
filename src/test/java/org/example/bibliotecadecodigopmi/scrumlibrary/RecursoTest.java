package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursoTest {

    @Test
    public void testGetName() {
        String name = "Resource 1";
        double costPerHour = 10.5;
        Recurso recurso = new Recurso(name, costPerHour);
        assertEquals(name, recurso.getName());
    }

    @Test
    public void testGetCostPerHour() {
        String name = "Resource 1";
        double costPerHour = 10.5;
        Recurso recurso = new Recurso(name, costPerHour);
        assertEquals(costPerHour, recurso.getCostPerHour(), 0.01);
    }
}
