package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TareaTest {

    @Test
    public void testGetNombre() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        assertEquals(nombre, tarea.getNombre());
    }

    @Test
    public void testGetFechaDeInicio() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        assertEquals(fechaDeInicio, tarea.getFechaDeInicio());
    }

    @Test
    public void testGetFechaDeTerminado() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        assertEquals(fechaDeTerminado, tarea.getFechaDeTerminado());
    }

    @Test
    public void testSetResources() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        Recurso recurso = new Recurso("Recurso 1", 10.0);
        tarea.setResources(recurso);

        List<Recurso> recursos = tarea.getResources();
        assertTrue(recursos.contains(recurso));
    }

    @Test
    public void testToString() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        assertEquals(nombre, tarea.toString());
    }

    @Test
    public void testGetDescripcion() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        assertEquals(descripcion, tarea.getDescripcion());
    }

    @Test
    public void testSetNombre() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        String nuevoNombre = "Tarea 2";
        tarea.setNombre(nuevoNombre);

        assertEquals(nuevoNombre, tarea.getNombre());
    }

    @Test
    public void testSetFechaDeInicio() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        LocalDate nuevaFechaDeInicio = LocalDate.of(2023, 1, 2);
        tarea.setFechaDeInicio(nuevaFechaDeInicio);

        assertEquals(nuevaFechaDeInicio, tarea.getFechaDeInicio());
    }

    @Test
    public void testSetFechaDeTerminado() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        LocalDate nuevaFechaDeTerminado = LocalDate.of(2023, 1, 15);
        tarea.setFechaDeTerminado(nuevaFechaDeTerminado);

        assertEquals(nuevaFechaDeTerminado, tarea.getFechaDeTerminado());
    }

    @Test
    public void testSetDescripcion() {
        String nombre = "Tarea 1";
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaDeTerminado = LocalDate.of(2023, 1, 10);
        String descripcion = "Descripción de la tarea";

        Tarea tarea = new Tarea(nombre, fechaDeInicio, fechaDeTerminado, descripcion,false);

        String nuevaDescripcion = "Nueva descripción de la tarea";
        tarea.setDescripcion(nuevaDescripcion);

        assertEquals(nuevaDescripcion, tarea.getDescripcion());
    }
}
