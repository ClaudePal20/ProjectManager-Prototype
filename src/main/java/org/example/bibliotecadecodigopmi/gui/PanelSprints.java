package org.example.bibliotecadecodigopmi.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.bibliotecadecodigopmi.scrumlibrary.Project;
import org.example.bibliotecadecodigopmi.scrumlibrary.SprintDesarrollo;
import org.example.bibliotecadecodigopmi.scrumlibrary.SprintPlanificacion;
import org.example.bibliotecadecodigopmi.scrumlibrary.SprintTesting;

import java.util.ArrayList;

public class PanelSprints {
    public static void SetupSprintsPanel(Project project, PieChart pieChart) {
        //Crear el panel
        Stage SprintsPanel = new Stage();
        SprintsPanel.setTitle("Sprints panel");
        //Crear tabla para cada tipo de sprint (desarrollo, planificacion, testing)
        TableView<SprintDesarrollo> tablaDesarrollo = new TableView<>();

        //Crear columnas para cada tipo de sprint
        TableColumn<SprintDesarrollo,String> numeroColumnaDesarrollo = new TableColumn<>("Numero");
        numeroColumnaDesarrollo.setCellValueFactory(new PropertyValueFactory<>("numero"));
        TableColumn<SprintDesarrollo, String> nombreColumnaDesarrollo = new TableColumn<>("Nombre");
        nombreColumnaDesarrollo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<SprintDesarrollo, String> objetivoColumnaDesarrollo = new TableColumn<>("Objetivo");
        objetivoColumnaDesarrollo.setCellValueFactory(new PropertyValueFactory<>("objetivo"));
        TableColumn<SprintDesarrollo, String> duracionEnSemanasColumnaDesarrollo = new TableColumn<>("Duracion en semanas");
        duracionEnSemanasColumnaDesarrollo.setCellValueFactory(new PropertyValueFactory<>("duracionEnSemanas"));
        TableColumn<SprintDesarrollo,String> puntosHistoriaColumnaDesarrollo = new TableColumn<>("Puntos de historia");
        puntosHistoriaColumnaDesarrollo.setCellValueFactory(new PropertyValueFactory<>("puntosDeHistoria"));
        //Columna para checkBox sprint completado


        //Agregar columnas a la tabla
        tablaDesarrollo.getColumns().addAll(numeroColumnaDesarrollo,nombreColumnaDesarrollo, objetivoColumnaDesarrollo,duracionEnSemanasColumnaDesarrollo,puntosHistoriaColumnaDesarrollo);

        //Crear tabla para cada tipo de sprint (desarrollo, planificacion, testing)
        TableView<SprintPlanificacion> tablaPlanificacion = new TableView<>();

        //Agregar columnas a la tabla
        TableColumn<SprintPlanificacion,String> numeroColumnaPlanificacion = new TableColumn<>("Numero");
        numeroColumnaPlanificacion.setCellValueFactory(new PropertyValueFactory<>("numero"));
        TableColumn<SprintPlanificacion, String> nombreColumnaPlanificacion = new TableColumn<>("Nombre");
        nombreColumnaPlanificacion.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<SprintPlanificacion,String> ObjetivoColumnaPlanificacion= new TableColumn<>("Objetivo");
        ObjetivoColumnaPlanificacion.setCellValueFactory(new PropertyValueFactory<>("objetivo"));
        TableColumn<SprintPlanificacion,String> duracionEnSemanas = new TableColumn<>("Duracion en semanas");
        duracionEnSemanas.setCellValueFactory(new PropertyValueFactory<>("duracionEnSemanas"));
        TableColumn<SprintPlanificacion,String> entregables = new TableColumn<>("Entregables");
        entregables.setCellValueFactory(new PropertyValueFactory<>("entregables"));
        //Columna para checkBox sprint completado

        //Agregar columnas a la tabla
        tablaPlanificacion.getColumns().addAll(numeroColumnaPlanificacion,nombreColumnaPlanificacion, ObjetivoColumnaPlanificacion, duracionEnSemanas, entregables);

        //Crear tabla para cada tipo de sprint (desarrollo, planificacion, testing)
        TableView<SprintTesting> tablaTesting = new TableView<>();

        //Crear columnas para cada tipo de sprint
        TableColumn<SprintTesting, String> numero = new TableColumn<>("Numero");
        numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        TableColumn<SprintTesting, String> nombreColumnaTesting = new TableColumn<>("Nombre");
        nombreColumnaTesting.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<SprintTesting, String> ObjetivoColumnaTesting= new TableColumn<>("Objetivo");
        ObjetivoColumnaTesting.setCellValueFactory(new PropertyValueFactory<>("objetivo"));
        TableColumn<SprintTesting, String> duracionEnSemanasTesting = new TableColumn<>("Duracion en semanas");
        duracionEnSemanasTesting.setCellValueFactory(new PropertyValueFactory<>("duracionEnSemanas"));
        TableColumn<SprintTesting, String> casosDePrueba = new TableColumn<>("Casos de prueba");
        casosDePrueba.setCellValueFactory(new PropertyValueFactory<>("casosDePrueba"));
        //Columna para checkBox sprint completado

        //Agregar columnas a la tabla
        tablaTesting.getColumns().addAll(numero,nombreColumnaTesting, ObjetivoColumnaTesting, duracionEnSemanasTesting, casosDePrueba);

        //Agregar informacion de los sprints a las tablas
        for (SprintDesarrollo sprintDesarrollo : project.getSprintsDesarrollo()) {
            tablaDesarrollo.getItems().add(sprintDesarrollo);
        }
        for(SprintPlanificacion sprintPlanificacion : project.getSprintsPlanificacion()){
            tablaPlanificacion.getItems().add(sprintPlanificacion);
        }
        for(SprintTesting sprintTesting : project.getSprintsTesting()){
            tablaTesting.getItems().add(sprintTesting);
        }

        //Crear botones para cada tipo de sprint
        Button botonAgregarDesarrollo = new Button("Agregar");
        Button botonEditarDesarrollo = new Button("Editar");
        Button botonEliminarDesarrollo = new Button("Eliminar");
        Button botonAgregarPlanificacion = new Button("Agregar");
        Button botonEditarPlanificacion = new Button("Editar");
        Button botonEliminarPlanificacion = new Button("Eliminar");
        Button botonAgregarTesting = new Button("Agregar");
        Button botonEditarTesting = new Button("Editar");
        Button botonEliminarTesting = new Button("Eliminar");
        Button botonGuardar = new Button("Guardar");
        Button botonGuardar2 = new Button("Guardar");
        Button botonGuardar3 = new Button("Guardar");
        //Agregar funcionalidad a los botones
        botonAgregarDesarrollo.setOnAction(event -> {
            SprintDesarrollo sprintDesarrollo = mostrarPanelAgregarSprintDesarrollo(project.numSprints);
            tablaDesarrollo.getItems().add(sprintDesarrollo);
            project.numSprints++;
        });
        botonEditarDesarrollo.setOnAction(event -> {
            SprintDesarrollo sprintDesarrolloSeleccionado = tablaDesarrollo.getSelectionModel().getSelectedItem();
            mostrarPanelEditarSprintDesarrollo(sprintDesarrolloSeleccionado);
            //Actualizar item de la tabla
            tablaDesarrollo.getItems().set(tablaDesarrollo.getSelectionModel().getSelectedIndex(),sprintDesarrolloSeleccionado);
            tablaDesarrollo.refresh();
        });
        botonEliminarDesarrollo.setOnAction(event -> {
            SprintDesarrollo sprintDesarrolloSeleccionado = tablaDesarrollo.getSelectionModel().getSelectedItem();
            tablaDesarrollo.getItems().remove(sprintDesarrolloSeleccionado);
            if(project.numSprints>0){
                project.numSprints--;
            }
        });
        botonAgregarPlanificacion.setOnAction(event -> {
            SprintPlanificacion sprintPlanificacion = mostrarPanelAgregarSprintPlanificacion(project.numSprints);
            tablaPlanificacion.getItems().add(sprintPlanificacion);
            project.numSprints++;
        });
        botonEditarPlanificacion.setOnAction(event -> {
            SprintPlanificacion sprintPlanificacionSeleccionado = tablaPlanificacion.getSelectionModel().getSelectedItem();
            if (sprintPlanificacionSeleccionado != null) {
                mostrarPanelEditarSprintPlanificacion(sprintPlanificacionSeleccionado);
                tablaPlanificacion.getItems().set(tablaPlanificacion.getSelectionModel().getSelectedIndex(), sprintPlanificacionSeleccionado);
                tablaPlanificacion.refresh();
            }
        });
        botonEliminarPlanificacion.setOnAction(event -> {
            SprintPlanificacion sprintPlanificacionSeleccionado = tablaPlanificacion.getSelectionModel().getSelectedItem();
            if (sprintPlanificacionSeleccionado != null) {
                tablaPlanificacion.getItems().remove(sprintPlanificacionSeleccionado);
            }
            if(project.numSprints>0){
                project.numSprints--;
            }
        });
        botonAgregarTesting.setOnAction(event -> {
            SprintTesting sprintTesting = mostrarPanelAgregarSprintTesting(project.numSprints);
            tablaTesting.getItems().add(sprintTesting);
            project.numSprints++;
        });
        botonEditarTesting.setOnAction(event -> {
            SprintTesting sprintTestingSeleccionado = tablaTesting.getSelectionModel().getSelectedItem();
            if (sprintTestingSeleccionado != null) {
                mostrarPanelEditarSprintTesting(sprintTestingSeleccionado);
                tablaTesting.getItems().set(tablaTesting.getSelectionModel().getSelectedIndex(), sprintTestingSeleccionado);
                tablaTesting.refresh();
            }
        });
        botonEliminarTesting.setOnAction(event -> {
            SprintTesting sprintTestingSeleccionado = tablaTesting.getSelectionModel().getSelectedItem();
            if (sprintTestingSeleccionado != null) {
                tablaTesting.getItems().remove(sprintTestingSeleccionado);
            }
            if(project.numSprints>0){
                project.numSprints--;
            }
        });
        botonGuardar.setOnAction(event -> {
            //Agregar todos los datos al proyecto
            ArrayList<SprintDesarrollo> sprintsDesarrollo = new ArrayList<>(tablaDesarrollo.getItems());
            ArrayList<SprintTesting> sprintsTesting = new ArrayList<>(tablaTesting.getItems());
            ArrayList<SprintPlanificacion> sprintsPlanificacion = new ArrayList<>(tablaPlanificacion.getItems());
            project.setSprintsDesarrollo(sprintsDesarrollo);
            project.setSprintsTesting(sprintsTesting);
            project.setSprintsPlanificacion(sprintsPlanificacion);
            SprintsPanel.close();
        });
        botonGuardar2.setOnAction(event -> {
            //Agregar todos los datos al proyecto
            //Convertir observables a arrayList
            ArrayList<SprintDesarrollo> sprintsDesarrollo = new ArrayList<>(tablaDesarrollo.getItems());
            ArrayList<SprintTesting> sprintsTesting = new ArrayList<>(tablaTesting.getItems());
            ArrayList<SprintPlanificacion> sprintsPlanificacion = new ArrayList<>(tablaPlanificacion.getItems());
            project.setSprintsDesarrollo(sprintsDesarrollo);
            project.setSprintsTesting(sprintsTesting);
            project.setSprintsPlanificacion(sprintsPlanificacion);
            SprintsPanel.close();
        });
        botonGuardar3.setOnAction(event -> {
            //Agregar todos los datos al proyecto
            ArrayList<SprintDesarrollo> sprintsDesarrollo = new ArrayList<>(tablaDesarrollo.getItems());
            ArrayList<SprintTesting> sprintsTesting = new ArrayList<>(tablaTesting.getItems());
            ArrayList<SprintPlanificacion> sprintsPlanificacion = new ArrayList<>(tablaPlanificacion.getItems());
            project.setSprintsDesarrollo(sprintsDesarrollo);
            project.setSprintsTesting(sprintsTesting);
            project.setSprintsPlanificacion(sprintsPlanificacion);
            SprintsPanel.close();
        });

        //Crear contenedor para cada tipo de sprint y posicionarlo debidamente
        VBox contenedorDesarrollo = new VBox();
        contenedorDesarrollo.setAlignment(Pos.CENTER);
        contenedorDesarrollo.setSpacing(10);
        contenedorDesarrollo.getChildren().addAll(tablaDesarrollo, botonAgregarDesarrollo, botonEditarDesarrollo, botonEliminarDesarrollo,botonGuardar);

        VBox contenedorPlanificacion = new VBox();
        contenedorPlanificacion.setAlignment(Pos.CENTER);
        contenedorPlanificacion.setSpacing(10);
        contenedorPlanificacion.getChildren().addAll(tablaPlanificacion, botonAgregarPlanificacion, botonEditarPlanificacion, botonEliminarPlanificacion,botonGuardar2);

        VBox contenedorTesting = new VBox();
        contenedorTesting.setAlignment(Pos.CENTER);
        contenedorTesting.setSpacing(10);
        contenedorTesting.getChildren().addAll(tablaTesting, botonAgregarTesting, botonEditarTesting, botonEliminarTesting, botonGuardar3);

        //Crear pestañas para cada tipo de sprint
        Tab tabDesarrollo = new Tab("Desarrollo", contenedorDesarrollo);
        tabDesarrollo.setClosable(false);
        Tab tabPlanificacion = new Tab("Planificacion", contenedorPlanificacion);
        tabPlanificacion.setClosable(false);
        Tab tabTesting = new Tab("Testing", contenedorTesting);
        tabTesting.setClosable(false);


        //Agregar pestañas a la ventana
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(tabDesarrollo, tabPlanificacion, tabTesting);

        //Crear escena
        Scene scene = new Scene(tabPane, 1000, 600);

        //Mostrar ventana
        SprintsPanel.setScene(scene);
        SprintsPanel.show();
    }

    private static void mostrarPanelEditarSprintTesting(SprintTesting sprintTestingSeleccionado) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Editar Sprint Testing");

        //Crear contenedor
        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setHgap(10);
        contenedor.setVgap(10);

        //Crear campos de texto
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");
        TextField campoObjetivo = new TextField();
        campoObjetivo.setPromptText("Objetivo");
        Spinner<Integer> spinnerDuracion = new Spinner<>(1, 100, 1);
        spinnerDuracion.setEditable(true);
        Spinner<Integer> spinnerCasosDePrueba = new Spinner<>(1, 100, 1);
        spinnerCasosDePrueba.setEditable(true);


        //Agregar campos de texto al contenedor
        contenedor.add(campoNombre, 0, 0);
        contenedor.add(campoObjetivo, 0, 1);
        contenedor.add(spinnerDuracion, 0, 2);
        contenedor.add(spinnerCasosDePrueba, 0, 3);

        //Crear botones
        Button botonGuardar = new Button("Guardar");
        Button botonCancelar = new Button("Cancelar");
        //Agregar botones al contenedor
        contenedor.add(botonGuardar, 0, 5);
        contenedor.add(botonCancelar, 1, 5);
        //Crear escena
        Scene scene = new Scene(contenedor, 400, 300);

        botonGuardar.setOnAction(event -> {
            sprintTestingSeleccionado.setNumero(0);
            sprintTestingSeleccionado.setNombre(campoNombre.getText());
            sprintTestingSeleccionado.setObjetivo(campoObjetivo.getText());
            sprintTestingSeleccionado.setSemanas(spinnerDuracion.getValue());
            sprintTestingSeleccionado.setCasosDePrueba(spinnerCasosDePrueba.getValue());
            primaryStage.close();
        });
        botonCancelar.setOnAction(event -> primaryStage.close());
        //Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static SprintTesting mostrarPanelAgregarSprintTesting(int numSprint) {
        Stage primaryStage = new Stage();
        SprintTesting sprintTesting = new SprintTesting(0, null, 0, 0, null);
        primaryStage.setTitle("Agregar Sprint Testing");

        //Crear contenedor
        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setHgap(10);
        contenedor.setVgap(10);

        //Crear campos de texto
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");
        TextField campoObjetivo = new TextField();
        campoObjetivo.setPromptText("Objetivo");
        Spinner<Integer> spinnerDuracion = new Spinner<>(1, 100, 1);
        spinnerDuracion.setEditable(true);
        Spinner<Integer> spinnerCasosDePrueba = new Spinner<>(1, 100, 1);
        spinnerCasosDePrueba.setEditable(true);


        //Agregar campos de texto al contenedor
        contenedor.add(campoNombre, 0, 0);
        contenedor.add(campoObjetivo, 0, 1);
        contenedor.add(spinnerDuracion, 0, 2);
        contenedor.add(spinnerCasosDePrueba, 0, 3);

        //Crear botones
        Button botonGuardar = new Button("Guardar");
        Button botonCancelar = new Button("Cancelar");

        //Agregar botones al contenedor
        contenedor.add(botonGuardar, 0, 5);
        contenedor.add(botonCancelar, 1, 5);

        //Crear escena
        Scene scene = new Scene(contenedor, 400, 300);

        //Acciones de los botones
        botonGuardar.setOnAction(event -> {
            sprintTesting.setNumero(numSprint);
            sprintTesting.setNombre(campoNombre.getText());
            sprintTesting.setObjetivo(campoObjetivo.getText());
            sprintTesting.setSemanas(spinnerDuracion.getValue());
            sprintTesting.setCasosDePrueba(spinnerCasosDePrueba.getValue());
            primaryStage.close();
        });
        botonCancelar.setOnAction(event -> primaryStage.close());

        //Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
        return sprintTesting;
    }

    private static void mostrarPanelEditarSprintPlanificacion(SprintPlanificacion sprintPlanificacionSeleccionado) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Agregar Sprint Planificación");
        // Crear contenedor
        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setHgap(10);
        contenedor.setVgap(10);

        // Crear campos de texto
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");
        TextField campoObjetivo = new TextField();
        campoObjetivo.setPromptText("Objetivo");
        Spinner<Integer> spinnerDuracion = new Spinner<>(1, 100, 1);
        spinnerDuracion.setEditable(true);

        //Crear campo para los entregables
        TextField campoEntregables = new TextField();
        campoEntregables.setPromptText("Entregables");
        //Crear boton para agregar entregables
        Button agregarEntregableBoton = new Button("Agregar Entregable");
        //Crear combobox para los entregables
        ComboBox<String> comboEntregables = new ComboBox<>();
        comboEntregables.setPromptText("Entregables");
        //Crear boton para eliminar entregables
        Button eliminarEntregableBoton = new Button("Eliminar Entregable");
        //Accion para cuando se presiona el boton de agregar entregables
        agregarEntregableBoton.setOnAction(event -> {
            comboEntregables.getItems().add(campoEntregables.getText());
            campoEntregables.clear();
        });
        //Accion para cuando se presiona el boton de eliminar entregables
        eliminarEntregableBoton.setOnAction(event -> comboEntregables.getItems().remove(comboEntregables.getValue()));

        // Agregar campos de texto al contenedor
        contenedor.add(campoNombre, 0, 0);
        contenedor.add(campoObjetivo, 0, 1);
        contenedor.add(spinnerDuracion, 0, 2);
        contenedor.add(campoEntregables, 0, 3);
        contenedor.add(agregarEntregableBoton, 1, 3);
        contenedor.add(comboEntregables, 0, 4);
        contenedor.add(eliminarEntregableBoton, 1, 4);

        // Crear botones
        Button botonGuardar = new Button("Guardar");
        Button botonCancelar = new Button("Cancelar");

        // Agregar botones al contenedor
        contenedor.add(botonGuardar, 0, 5);
        contenedor.add(botonCancelar, 1, 5);

        // Crear escena
        Scene scene = new Scene(contenedor, 400, 300);

        botonGuardar.setOnAction(event -> {
            sprintPlanificacionSeleccionado.setNombre(campoNombre.getText());
            sprintPlanificacionSeleccionado.setObjetivo(campoObjetivo.getText());
            sprintPlanificacionSeleccionado.setDuracionEnSemanas(spinnerDuracion.getValue());
            sprintPlanificacionSeleccionado.setEntregables(new ArrayList<>(comboEntregables.getItems()));

            primaryStage.close();
        });

        botonCancelar.setOnAction(event -> primaryStage.close());

        // Agregar evento para agregar entregables
        comboEntregables.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                comboEntregables.getItems().add(comboEntregables.getEditor().getText());
                comboEntregables.getEditor().clear();
            }
        });

        // Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    private static SprintPlanificacion mostrarPanelAgregarSprintPlanificacion(int numSprint) {
        SprintPlanificacion sprintPlanificacion = new SprintPlanificacion(0, null, 0, null, null);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Agregar Sprint Planificación");

        // Crear contenedor
        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setHgap(10);
        contenedor.setVgap(10);

        // Crear campos de texto
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");
        TextField campoObjetivo = new TextField();
        campoObjetivo.setPromptText("Objetivo");
        Spinner<Integer> spinnerDuracion = new Spinner<>(1, 100, 1);
        spinnerDuracion.setEditable(true);

        //Crear campo para los entregables
        TextField campoEntregables = new TextField();
        campoEntregables.setPromptText("Entregables");
        //Crear boton para agregar entregables
        Button agregarEntregableBoton = new Button("Agregar Entregable");
        //Crear combobox para los entregables
        ComboBox<String> comboEntregables = new ComboBox<>();
        comboEntregables.setPromptText("Entregables");
        //Crear boton para eliminar entregables
        Button eliminarEntregableBoton = new Button("Eliminar Entregable");
        //Accion para cuando se presiona el boton de agregar entregables
        agregarEntregableBoton.setOnAction(event -> {
            comboEntregables.getItems().add(campoEntregables.getText());
            campoEntregables.clear();
        });
        //Accion para cuando se presiona el boton de eliminar entregables
        eliminarEntregableBoton.setOnAction(event -> comboEntregables.getItems().remove(comboEntregables.getValue()));

        // Agregar campos de texto al contenedor
        contenedor.add(campoNombre, 0, 0);
        contenedor.add(campoObjetivo, 0, 1);
        contenedor.add(spinnerDuracion, 0, 2);
        contenedor.add(campoEntregables, 0, 3);
        contenedor.add(agregarEntregableBoton, 1, 3);
        contenedor.add(comboEntregables, 0, 4);
        contenedor.add(eliminarEntregableBoton, 1, 4);

        // Crear botones
        Button botonGuardar = new Button("Guardar");
        Button botonCancelar = new Button("Cancelar");

        // Agregar botones al contenedor
        contenedor.add(botonGuardar, 0, 5);
        contenedor.add(botonCancelar, 1, 5);

        // Crear escena
        Scene scene = new Scene(contenedor, 400, 300);

        botonGuardar.setOnAction(event -> {
            sprintPlanificacion.setNumero(numSprint);
            sprintPlanificacion.setNombre(campoNombre.getText());
            sprintPlanificacion.setObjetivo(campoObjetivo.getText());
            sprintPlanificacion.setDuracionEnSemanas(spinnerDuracion.getValue());
            sprintPlanificacion.setEntregables(new ArrayList<>(comboEntregables.getItems()));

            primaryStage.close();
        });

        botonCancelar.setOnAction(event -> primaryStage.close());

        // Agregar evento para agregar entregables
        comboEntregables.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                comboEntregables.getItems().add(comboEntregables.getEditor().getText());
                comboEntregables.getEditor().clear();
            }
        });

        // Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

        return sprintPlanificacion;
    }

    private static void mostrarPanelEditarSprintDesarrollo(SprintDesarrollo sprintDesarrolloSeleccionado) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Editar Sprint Desarrollo");

        //Crear contenedor
        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setHgap(10);
        contenedor.setVgap(10);

        //Crear campos de texto
        TextField campoObjetivo = new TextField();
        campoObjetivo.setPromptText("Objetivo");
        Spinner<Integer> spinnerDuracion = new Spinner<>(1, 100, 1);
        spinnerDuracion.setEditable(true);
        Spinner<Integer> spinnerPuntosDeHistoria = new Spinner<>(1, 100, 1);
        spinnerPuntosDeHistoria.setEditable(true);
        //TextField para un arreglo de strings
        TextField campoEntregables = new TextField();
        campoEntregables.setPromptText("Entregables");
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");

        //Agregar campos de texto al contenedor
        contenedor.add(campoNombre, 0, 0);
        contenedor.add(campoObjetivo, 0, 1);
        contenedor.add(spinnerDuracion, 0, 2);
        contenedor.add(spinnerPuntosDeHistoria, 0, 3);

        //Crear botones
        Button botonGuardar = new Button("Guardar");
        Button botonCancelar = new Button("Cancelar");

        //Agregar botones al contenedor
        contenedor.add(botonGuardar, 0, 5);
        contenedor.add(botonCancelar, 1, 5);

        //Crear escena
        Scene scene = new Scene(contenedor, 400, 300);
        botonGuardar.setOnAction(event -> {
            sprintDesarrolloSeleccionado.setNombre(campoNombre.getText());
            sprintDesarrolloSeleccionado.setObjetivo(campoObjetivo.getText());
            sprintDesarrolloSeleccionado.setDuracionEnSemanas(spinnerDuracion.getValue());
            sprintDesarrolloSeleccionado.setPuntosDeHistoria(spinnerPuntosDeHistoria.getValue());
            primaryStage.close();
        });
        botonCancelar.setOnAction(event -> primaryStage.close());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static SprintDesarrollo mostrarPanelAgregarSprintDesarrollo(int numSprint) {
        SprintDesarrollo sprintDesarrollo = new SprintDesarrollo(0,null,0,0,null);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Agregar Sprint Desarrollo");

        //Crear contenedor
        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setHgap(10);
        contenedor.setVgap(10);

        //Crear campos de texto
        TextField campoObjetivo = new TextField();
        campoObjetivo.setPromptText("Objetivo");
        Spinner<Integer> spinnerDuracion = new Spinner<>(1, 100, 1);
        spinnerDuracion.setEditable(true);
        Spinner<Integer> spinnerPuntosDeHistoria = new Spinner<>(1, 100, 1);
        spinnerPuntosDeHistoria.setEditable(true);
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");

        //Agregar campos de texto al contenedor
        contenedor.add(campoNombre, 0, 0);
        contenedor.add(campoObjetivo, 0, 1);
        contenedor.add(spinnerDuracion, 0, 2);
        contenedor.add(spinnerPuntosDeHistoria, 0, 3);

        //Crear botones
        Button botonAceptar = new Button("Guardar");
        Button botonCancelar = new Button("Cancelar");

        //Agregar botones al contenedor
        contenedor.add(botonAceptar, 0, 5);
        contenedor.add(botonCancelar, 1, 5);

        //Crear escena
        Scene scene = new Scene(contenedor, 400, 300);
        //Agregar eventos
        botonAceptar.setOnAction(event -> {
            sprintDesarrollo.setNumero(numSprint);
            sprintDesarrollo.setNombre(campoNombre.getText());
            sprintDesarrollo.setObjetivo(campoObjetivo.getText());
            sprintDesarrollo.setDuracionEnSemanas(spinnerDuracion.getValue());
            sprintDesarrollo.setPuntosDeHistoria(spinnerPuntosDeHistoria.getValue());
            primaryStage.close();
        });
        botonCancelar.setOnAction(event -> primaryStage.close());
        //Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

        return sprintDesarrollo;
    }
}
