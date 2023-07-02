package org.example.bibliotecadecodigopmi.scrumlibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
    private Project project;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    public void setUp() {
        project = new Project(null, null, null, null, null, null);
        this.startDate = LocalDate.of(2023, 1, 1);
        this.endDate = LocalDate.of(2023, 12, 31);
        List<Tarea> tareas = new ArrayList<>();
        this.project = new Project("Test Project", startDate, endDate, tareas, "Budget", "Manager");
    }

    @Test
    public void testGetPresupuesto() {
        assertEquals("Budget", project.getPresupuesto());
    }

    @Test
    public void testGetManagerDeProyecto() {
        assertEquals("Manager", project.getManagerDeProyecto());
    }

    @Test
    public void testAgregarTarea() {
        Tarea tarea = new Tarea("Task 1", startDate, endDate, "Task Description",true);
        project.agregarTarea(tarea);
        assertTrue(project.getTareas().contains(tarea));
    }

    @Test
    public void testGetSprintsDesarrollo() {
        List<SprintDesarrollo> sprintsDesarrollo = new ArrayList<>();
        //Crear datos para sprint1
        String nombre = "Sprint 1";
        String objetivo = "Objetivo 1";
        int numero = 1;
        int duracionSemanas = 2;
        int puntos = 10;
        //Crear datos para sprint2
        String nombre2 = "Sprint 2";
        String objetivo2 = "Objetivo 2";
        int numero2 = 2;
        int duracionSemanas2 = 3;
        int puntos2 = 20;
        SprintDesarrollo sprint1 = new SprintDesarrollo(numero, objetivo, duracionSemanas, puntos, nombre );
        SprintDesarrollo sprint2 = new SprintDesarrollo(numero2, objetivo2, duracionSemanas2, puntos2, nombre2);
        sprintsDesarrollo.add(sprint1);
        sprintsDesarrollo.add(sprint2);
        project.setSprintsDesarrollo(sprintsDesarrollo);
        assertEquals(sprintsDesarrollo, project.getSprintsDesarrollo());
    }

    @Test
    public void testGetSprintsPlanificacion() {
        List<SprintPlanificacion> sprintsPlanificacion = new ArrayList<>();
        //Crear datos para sprint1
        String nombre = "Sprint 1";
        String objetivo = "Objetivo 1";
        int numero = 1;
        int duracionSemanas = 2;
        //Crear datos para sprint2
        String nombre2 = "Sprint 2";
        String objetivo2 = "Objetivo 2";
        int numero2 = 2;
        int duracionSemanas2 = 3;
        ArrayList<String> entregables = new ArrayList<>();
        entregables.add("Entregable 1");
        entregables.add("Entregable 2");
        ArrayList<String> entregables2 = new ArrayList<>();
        entregables2.add("Entregable 3");
        entregables2.add("Entregable 4");
        SprintPlanificacion sprint1 = new SprintPlanificacion(numero, objetivo, duracionSemanas, entregables, nombre);
        SprintPlanificacion sprint2 = new SprintPlanificacion(numero2, objetivo2, duracionSemanas2, entregables2, nombre2);
        sprintsPlanificacion.add(sprint1);
        sprintsPlanificacion.add(sprint2);
        //Crear proyecto
        //Crear datos para proyecto
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Task 1", startDate, endDate, "Task Description",true));
        tareas.add(new Tarea("Task 2", startDate, endDate, "Task Description",true));
        Project project = new Project("Test Project", startDate, endDate, tareas, "Budget", "Manager");
        project.setSprintsPlanificacion(sprintsPlanificacion);
        assertEquals(sprintsPlanificacion, project.getSprintsPlanificacion());
    }

    @Test
    public void testGetSprintsTesting() {
        List<SprintTesting> sprintsTesting = new ArrayList<>();
        //Crear datos para sprint1
        String nombre = "Sprint 1";
        String objetivo = "Objetivo 1";
        int numero = 1;
        int duracionSemanas = 2;
        int casosPrueba = 10;
        //Crear datos para sprint2
        String nombre2 = "Sprint 2";
        String objetivo2 = "Objetivo 2";
        int numero2 = 2;
        int duracionSemanas2 = 3;
        int casosPrueba2 = 20;
        SprintTesting sprint1 = new SprintTesting(numero, objetivo, duracionSemanas, casosPrueba, nombre);
        SprintTesting sprint2 = new SprintTesting(numero2, objetivo2, duracionSemanas2, casosPrueba2, nombre2);
        sprintsTesting.add(sprint1);
        sprintsTesting.add(sprint2);
        //Crear proyecto
        //Crear datos para proyecto
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Task 1", startDate, endDate, "Task Description",true));
        tareas.add(new Tarea("Task 2", startDate, endDate, "Task Description",true));
        Project project = new Project("Test Project", startDate, endDate, tareas, "Budget", "Manager");
        project.setSprintsTesting(sprintsTesting);
        assertEquals(sprintsTesting, project.getSprintsTesting());
    }

    @Test
    public void testAddAndRemoveSprintDesarrollo() {
        //Crear datos para sprint
        String nombre = "Sprint 1";
        String objetivo = "Objetivo 1";
        int numero = 1;
        int duracionSemanas = 2;
        int puntos = 10;
        SprintDesarrollo sprint = new SprintDesarrollo(numero, objetivo, duracionSemanas, puntos, nombre);
        project.addSprintDesarrollo(sprint);
        assertTrue(project.getSprintsDesarrollo().contains(sprint));
        project.removeSprintDesarrollo(sprint);
        assertFalse(project.getSprintsDesarrollo().contains(sprint));
    }

    @Test
    public void testAddAndRemoveSprintPlanificacion() {
        //Crear datos para sprint
        String nombre = "Sprint 1";
        String objetivo = "Objetivo 1";
        int numero = 1;
        int duracionSemanas = 2;
        //Crear array de entregables
        ArrayList<String> entregables = new ArrayList<>();
        entregables.add("Entregable 1");
        entregables.add("Entregable 2");
        SprintPlanificacion sprint = new SprintPlanificacion(numero, objetivo, duracionSemanas, entregables, nombre);
        project.addSprintPlanificacion(sprint);
        assertTrue(project.getSprintsPlanificacion().contains(sprint));
        project.removeSprintPlanificacion(sprint);
        assertFalse(project.getSprintsPlanificacion().contains(sprint));
    }

    @Test
    public void testAddAndRemoveSprintTesting() {
        //Crear datos para sprint1
        String nombre = "Sprint 1";
        String objetivo = "Objetivo 1";
        int numero = 1;
        int duracionSemanas = 2;
        int casosPrueba = 10;
        SprintTesting sprint = new SprintTesting(numero, objetivo, duracionSemanas, casosPrueba, nombre);
        project.addSprintTesting(sprint);
        assertTrue(project.getSprintsTesting().contains(sprint));
        project.removeSprintTesting(sprint);
        assertFalse(project.getSprintsTesting().contains(sprint));
    }

    // Add more test cases as needed

}
