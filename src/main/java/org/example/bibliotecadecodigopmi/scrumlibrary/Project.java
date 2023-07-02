package org.example.bibliotecadecodigopmi.scrumlibrary;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Project implements Serializable {
    private String nombre;
    private LocalDate FechaDeInicio;
    private LocalDate FechaDeTerminado;
    private String presupuesto;
    private String ManagerDeProyecto;
    private List<Tarea> tareas;
    private List<SprintDesarrollo> sprintsDesarrollo;
    private List<SprintPlanificacion> sprintsPlanificacion;
    private List<SprintTesting> sprintsTesting;
    public int numSprints=0;
    public Project(String nombre, LocalDate FechaDeInicio, LocalDate FechaDeTerminado, List<Tarea> tareas, String presupuesto, String ManagerDeProyecto) {
        this.nombre = nombre;
        this.FechaDeInicio = FechaDeInicio;
        this.FechaDeTerminado = FechaDeTerminado;
        this.tareas = tareas != null ? tareas : new ArrayList<>();
        this.presupuesto = presupuesto;
        this.ManagerDeProyecto = ManagerDeProyecto;
        this.sprintsPlanificacion = new ArrayList<>();
        this.sprintsTesting = new ArrayList<>();
        this.sprintsDesarrollo = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setFechaDeInicio(LocalDate FechaDeInicio) {
        this.FechaDeInicio = FechaDeInicio;
    }
    public void setFechaDeTerminado(LocalDate FechaDeTerminado) {
        this.FechaDeTerminado = FechaDeTerminado;
    }
    public Date getFechaDeInicio() {
        //default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //creating the instance of LocalDate using the day, month, year info
        LocalDate localDate = this.FechaDeInicio;
        //local date + atStartOfDay() + default time zone + toInstant() = Date
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }
    public Date getFechaDeTerminado() {
        //default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //creating the instance of LocalDate using the day, month, year info
        LocalDate localDate = this.FechaDeTerminado;
        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        return date;
    }
    public void createTarea(String nombre, LocalDate FechaDeInicio, LocalDate FechaDeTerminado, String Descripcion, Boolean completado) {
        Tarea tarea = new Tarea(nombre, FechaDeInicio, FechaDeTerminado, Descripcion,completado);
        this.tareas.add(tarea);
    }
    public List<Tarea> getTareas() {
        return tareas;
    }
    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    public void addTarea(Tarea tarea) {
        this.tareas.add(tarea);
    }
    public void removeTarea(Tarea tarea) {
        this.tareas.remove(tarea);
    }

    public String getPresupuesto() {
        return presupuesto;
    }
    public String getManagerDeProyecto() {
        return ManagerDeProyecto;
    }
    @Override
    public String toString() {
        return nombre;
    }

    public void agregarTarea(Tarea task) {
        this.tareas.add(task);
    }
    public List<SprintDesarrollo> getSprintsDesarrollo(){
        return this.sprintsDesarrollo;
    }
    public List<SprintPlanificacion> getSprintsPlanificacion(){
        return this.sprintsPlanificacion;
    }
    public List<SprintTesting> getSprintsTesting(){
        return this.sprintsTesting;
    }
    public void setSprintsDesarrollo(List<SprintDesarrollo> sprintsDesarrollo){
        this.sprintsDesarrollo = sprintsDesarrollo;
    }
    public void setSprintsPlanificacion(List<SprintPlanificacion> sprintsPlanificacion){
        this.sprintsPlanificacion = sprintsPlanificacion;
    }
    public void setSprintsTesting(List<SprintTesting> sprintsTesting){
        this.sprintsTesting = sprintsTesting;
    }
    //removers y geters para cada tipo de sprint
    public void addSprintDesarrollo(SprintDesarrollo sprint){
        this.sprintsDesarrollo.add(sprint);
    }
    public void removeSprintDesarrollo(SprintDesarrollo sprint){
        this.sprintsDesarrollo.remove(sprint);
    }
    public void addSprintPlanificacion(SprintPlanificacion sprint){
        this.sprintsPlanificacion.add(sprint);
    }
    public void removeSprintPlanificacion(SprintPlanificacion sprint){
        this.sprintsPlanificacion.remove(sprint);
    }
    public void addSprintTesting(SprintTesting sprint){
        this.sprintsTesting.add(sprint);
    }
    public void removeSprintTesting(SprintTesting sprint){
        this.sprintsTesting.remove(sprint);
    }
}
