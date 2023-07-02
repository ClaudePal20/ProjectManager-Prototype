package org.example.bibliotecadecodigopmi.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.bibliotecadecodigopmi.scrumlibrary.Project;
import org.example.bibliotecadecodigopmi.scrumlibrary.ProjectManager;
import org.example.bibliotecadecodigopmi.scrumlibrary.Tarea;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PestañaPrincipal {
    private VBox projectDetailsLayout;
    private ObservableList<Project> observableProjects;
    private ProjectManager projectManager = new ProjectManager();
    public void start(Stage primaryStage){
        setupUI(primaryStage);
    }

    private void setupButtons(ListView<Project> listaDeProyectos, BorderPane bordePrincipal, Stage primaryStage, ProjectManager projectManager){
        // Create the Agregar proyecto button
        Button agregarProyecto = new Button("Agregar proyecto");
        agregarProyecto.setOnAction(event -> agregarProyectoCuadro());

        // Create the Eliminar proyecto button
        Button eliminarProyecto = new Button("Eliminar proyecto");
        eliminarProyecto.setOnAction(event -> projectManager.eliminarProjecto(listaDeProyectos.getSelectionModel().getSelectedItem()));
        eliminarProyecto.setOnAction(event -> this.observableProjects.remove(listaDeProyectos.getSelectionModel().getSelectedItem()));

        // Create an HBox to hold the buttons
        HBox buttonsBox = new HBox(10, agregarProyecto, eliminarProyecto);
        buttonsBox.setAlignment(Pos.CENTER_LEFT);
        bordePrincipal.setBottom(buttonsBox);

        // Create the export button
        Button exportButton = new Button("Exportar proyectos a XML");
        exportButton.setOnAction(event -> {
            try {
                projectManager.exportToXML(projectManager.getProjects());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los proyectos se han exportado a XML correctamente");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al exportar proyectos a XML: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Create the scene
        Scene scene = new Scene(bordePrincipal);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create the export button for MPXJ
        Button exportButtonMPXJ = new Button("Exportar proyectos a MPXJ");
        exportButtonMPXJ.setOnAction(event -> {
            try {
                projectManager.exportToMPXJ(projectManager.getProjects());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los proyectos se han exportado a MPXJ correctamente");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al exportar proyectos a MPXJ: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Create the import button for MPXJ
        Button importButtonMPXJ = new Button("Importar proyectos desde MPXJ");
        importButtonMPXJ.setOnAction(event -> {
            try {
                //Crear un buscador de archivos
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccione un archivo MPXJ");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
                } else {
                    System.out.println("No Selection ");
                }
                //Importar desde MPXJ
                projectManager.importFromMPXJ(fileChooser.getSelectedFile().getAbsolutePath());
                this.observableProjects = FXCollections.observableList(projectManager.getProjects());
                listaDeProyectos.setItems(observableProjects);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los proyectos se han importado desde MPXJ correctamente");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al importar proyectos desde MPXJ: " + ex.getMessage());
                alert.showAndWait();
            }
        });
        //Crear boton para importar desde XML
        Button importButtonXML = new Button("Importar proyectos desde XML");
        importButtonXML.setOnAction(event ->{
            try{
                this.observableProjects = FXCollections.observableList(projectManager.importFromXML("proyectos2.xml"));
                listaDeProyectos.setItems(observableProjects);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los proyectos se han importado desde XML correctamente");
                alert.showAndWait();
            }catch(Exception ex){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al importar proyectos desde XML: " + ex.getMessage());
                alert.showAndWait();
            }
        });
        Button serializarProyectos = new Button("Serializar proyectos");
        serializarProyectos.setOnAction(event -> {
            try {
                projectManager.SerializarProyectos();
                //Agregarlos a la lista de observables
                this.observableProjects = FXCollections.observableList(projectManager.getProjects());
                listaDeProyectos.setItems(observableProjects);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los proyectos se han serializado correctamente");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al serializar proyectos: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        Button recuperarProyectos = new Button("Recuperar proyectos");
        recuperarProyectos.setOnAction(event -> {
            try {
                projectManager.RecuperarProyectos();
                this.observableProjects = FXCollections.observableList(projectManager.getProjects());
                listaDeProyectos.setItems(observableProjects);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Los proyectos se han recuperado correctamente");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al recuperar proyectos: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        HBox buttonsBox2 = new HBox(10, exportButtonMPXJ, exportButton, importButtonMPXJ, importButtonXML, serializarProyectos, recuperarProyectos);
        buttonsBox2.setAlignment(Pos.CENTER_LEFT);
        bordePrincipal.setTop(buttonsBox2);

    }

    private void setupUI(Stage primaryStage){
        // Create the main layout
        BorderPane bordePrincipal = new BorderPane();
        //Nuevo efecto
        Effect shadow = new DropShadow();
        bordePrincipal.setEffect(shadow);
        //bordeprincipal setstyle con un color claro cercano al amarillo
        bordePrincipal.setStyle("-fx-background-color: #FFFFE0;");
        bordePrincipal.setPadding(new Insets(10));
        bordePrincipal.setPrefSize(1200, 900);
        // Create the project list view
        ListView<Project> listaDeProyectos = new ListView<>();
        listaDeProyectos.setPrefWidth(150);
        observableProjects = FXCollections.observableList(projectManager.getProjects());
        listaDeProyectos.setItems(observableProjects);
        listaDeProyectos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarDetallesProjectos(newValue);
            }
        });
        bordePrincipal.setLeft(listaDeProyectos);
        // Create the project details layout
        projectDetailsLayout = new VBox(10);
        projectDetailsLayout.setAlignment(Pos.TOP_CENTER);
        projectDetailsLayout.setPadding(new Insets(10));
        bordePrincipal.setCenter(projectDetailsLayout);
        setupButtons(listaDeProyectos,bordePrincipal,primaryStage,projectManager);
        //Buscar archivo serializable
        //insertar codigo
        try{
            projectManager.RecuperarProyectos();
            this.observableProjects = FXCollections.observableList(projectManager.getProjects());
            listaDeProyectos.setItems(observableProjects);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se ha encontrado un archivo de serializacion \ny se han recuperado los proyectos");
            alert.showAndWait();
        }
        catch(Exception e){

        }
        //Si no encuentra un archivo ignorar avisos

        // Crear el segundo main layout
        // Llamar a la clase Documentacion y su método setupDocumentacion
        PestañaDocumentacion pestañaDocumentacion = new PestañaDocumentacion();
        BorderPane bordePrincipal2 = pestañaDocumentacion.setupDocumentacion();
        bordePrincipal2.setStyle("-fx-background-color: #FFFFE0;");

        //Pestaña de proyectos
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab();
        tab1.setText("Proyectos");
        tab1.setClosable(false);
        tab1.setContent(bordePrincipal);


        //Pestaña de documentacion
        Tab tab2 = new Tab();
        tab2.setText("Documentación");
        tab2.setClosable(false);
        tab2.setContent(bordePrincipal2);

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        Scene scene2 = new Scene(tabPane, 1200,900);
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    private void mostrarDetallesProjectos(Project project) {

        BorderPane borderPane = new BorderPane();
        // Create the project details section
        VBox cuadroDetallesDeProyecto = new VBox();
        Label tituloLabel = new Label("Detalles del proyecto");
        tituloLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
        Label nombreLabel = new Label(project.getNombre());
        nombreLabel.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold;");
        Label fechaDeInicioLabel = new Label("Fecha de inicio: " + project.getFechaDeInicio());
        fechaDeInicioLabel.setStyle("-fx-font-size: 14pt;");
        Label fechaDeTerminadoLabel = new Label("Fecha de terminado: " + project.getFechaDeTerminado());
        fechaDeTerminadoLabel.setStyle("-fx-font-size: 14pt;");
        Label presupuestoLabel = new Label("Presupuesto: $" + project.getPresupuesto());
        presupuestoLabel.setStyle("-fx-font-size: 14pt;");
        Label projectManagerLabel = new Label("Manager de proyecto: " + project.getManagerDeProyecto());
        projectManagerLabel.setStyle("-fx-font-size: 14pt;");


        cuadroDetallesDeProyecto.getChildren().addAll(tituloLabel,nombreLabel, fechaDeInicioLabel, fechaDeTerminadoLabel, presupuestoLabel, projectManagerLabel);
        cuadroDetallesDeProyecto.setSpacing(10);
        cuadroDetallesDeProyecto.setPadding(new Insets(10));
        cuadroDetallesDeProyecto.setAlignment(Pos.CENTER_LEFT);

        //PieChart para el progreso
        HBox cuadrosDeProgreso = new HBox();
        cuadrosDeProgreso.setSpacing(10);
        cuadrosDeProgreso.setPadding(new Insets(10));

        //PieChart para el progreso
        // Crear el gráfico de pastel
        PieChart pieChart = new PieChart();
        pieChart.setTitle("Tareas");
        pieChart.getData().add(new PieChart.Data("Completadas", 0));
        pieChart.getData().add(new PieChart.Data("Incompletas",0));
        VBox container = new VBox(pieChart);
        container.setSpacing(10);
        container.setPadding(new Insets(10));

        //PieChart para el progreso
        PieChart sprintsPieChart = new PieChart();
        sprintsPieChart.setTitle("Sprints");
        sprintsPieChart.getData().add(new PieChart.Data("Completados", 0));
        sprintsPieChart.getData().add(new PieChart.Data("No completados",0));
        VBox container2 = new VBox(sprintsPieChart);

        container2.setSpacing(10);
        container2.setPadding(new Insets(10));

        cuadrosDeProgreso.getChildren().addAll(container,container2);

        //Boton para revisar sprints
        Button Sprints = new Button("Sprints");
        Sprints.setOnAction(event -> {
            try {
                PanelSprints.SetupSprintsPanel(project, sprintsPieChart);
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al mostrar sprints");
                alert.setHeaderText(null);

                TextArea textArea = new TextArea(ex.getMessage());
                textArea.setEditable(false);
                textArea.setWrapText(true);
                textArea.setMaxWidth(Double.MAX_VALUE);
                textArea.setMaxHeight(Double.MAX_VALUE);

                GridPane.setVgrow(textArea, Priority.ALWAYS);
                GridPane.setHgrow(textArea, Priority.ALWAYS);

                GridPane contentPane = new GridPane();
                contentPane.setMaxWidth(Double.MAX_VALUE);
                contentPane.add(textArea, 0, 0);

                alert.getDialogPane().setExpandableContent(contentPane);
                alert.showAndWait();
            }
        });

        //Guardar el progreso de las tareas y los detalles de los sprints en un VBox
        HBox detallesDeProgreso = new HBox();
        detallesDeProgreso.setSpacing(10);
        detallesDeProgreso.setPadding(new Insets(10));
        detallesDeProgreso.getChildren().addAll(cuadroDetallesDeProyecto,cuadrosDeProgreso);

        borderPane.setTop(detallesDeProgreso);

        TableView<Tarea> tablaDeTareas = new TableView<>();
        tablaDeTareas.setEditable(true);

        TableColumn<Tarea, String> columnaDeNombres = new TableColumn<>("Nombre");
        columnaDeNombres.setEditable(true);
        columnaDeNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaDeNombres.setCellFactory(TextFieldTableCell.forTableColumn());
        columnaDeNombres.setOnEditCommit(event -> {
            Tarea tareaSeleccionada = event.getTableView().getSelectionModel().getSelectedItem();
            if (tareaSeleccionada != null) {
                tareaSeleccionada.setNombre(event.getNewValue());
            }
        });

        TableColumn<Tarea, LocalDate> fechaDeInicio = new TableColumn<>("Fecha de Inicio");
        fechaDeInicio.setEditable(true);
        fechaDeInicio.setCellValueFactory(new PropertyValueFactory<>("fechaDeInicio"));
        fechaDeInicio.setCellFactory(column -> new TableCell<Tarea, LocalDate>() {
            private final DatePicker datePicker = new DatePicker();

            {
                datePicker.setOnAction(event -> {
                    commitEdit(datePicker.getValue());
                    Tarea tareaSeleccionada = getTableView().getItems().get(getIndex());
                    tareaSeleccionada.setFechaDeInicio(datePicker.getValue());
                });
            }

            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    datePicker.setValue(item);
                    setGraphic(datePicker);
                }
            }
        });

        TableColumn<Tarea, LocalDate> fechaParaTerminar = new TableColumn<>("Fecha de Terminado");
        fechaParaTerminar.setEditable(true);
        fechaParaTerminar.setCellValueFactory(new PropertyValueFactory<>("fechaDeTerminado"));
        fechaParaTerminar.setCellFactory(column -> new TableCell<>() {
            private final DatePicker datePicker = new DatePicker();

            {
                datePicker.setOnAction(event -> {
                    commitEdit(datePicker.getValue());
                    Tarea tareaSeleccionada = getTableView().getItems().get(getIndex());
                    tareaSeleccionada.setFechaDeTerminado(datePicker.getValue());
                });
            }

            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    datePicker.setValue(item);
                    setGraphic(datePicker);
                }
            }
        });


        TableColumn<Tarea, String> Descripcion = new TableColumn<>("Descripcion");
        Descripcion.setEditable(true);
        Descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        Descripcion.setCellFactory(TextFieldTableCell.forTableColumn());
        Descripcion.setOnEditCommit(event -> {
            Tarea tareaSeleccionada = event.getTableView().getSelectionModel().getSelectedItem();
            if (tareaSeleccionada != null) {
                tareaSeleccionada.setDescripcion(event.getNewValue());
            }
        });

        TableColumn<Tarea, Boolean> completado = new TableColumn<>("Completado");
        completado.setEditable(true);
        completado.setCellValueFactory(new PropertyValueFactory<>("completado"));

        completado.setCellFactory(column -> {
            return new TableCell<Tarea, Boolean>() {
                private final CheckBox checkBox = new CheckBox();

                {
                    checkBox.setOnAction(event -> {
                        Tarea tareaSeleccionada = getTableRow().getItem();
                        if (tareaSeleccionada != null) {
                            tareaSeleccionada.setCompletado(checkBox.isSelected());
                            actualizarProgreso();


                        }
                    });
                }

                private void actualizarProgreso() {
                    //Actualizar el progreso de las tareas
                        int tareasCompletadas = 0;
                        int tareasIncompletas = 0;
                        for (Tarea tarea : tablaDeTareas.getItems()) {
                            if (tarea.getEstado()) {
                                tareasCompletadas++;
                            } else {
                                tareasIncompletas++;
                            }
                        }
                        ObservableList<PieChart.Data> datosPieChartTareas = pieChart.getData();
                        datosPieChartTareas.get(0).setPieValue(tareasCompletadas);
                        datosPieChartTareas.get(1).setPieValue(tareasIncompletas);
                }

                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);

                    if (!empty) {
                        Tarea tarea = getTableRow().getItem();
                        if (tarea != null) {
                            checkBox.setSelected(tarea.getCompletado());
                            setGraphic(checkBox);

                        } else {
                            setGraphic(null);
                        }
                    } else {
                        setGraphic(null);
                    }
                }
            };
        });



        tablaDeTareas.getColumns().addAll(columnaDeNombres, fechaDeInicio, fechaParaTerminar, Descripcion, completado);

        // Agregar las tareas a la vista de la tabla
        if (project.getTareas() == null) {
            project.setTareas(new ArrayList<>());
        }
        if(project.getTareas()!=null){
            ObservableList<Tarea> tareasObservables = FXCollections.observableList(project.getTareas());
            tablaDeTareas.setItems(tareasObservables);
        }
        // Crear el boton de agregar tareas
        Button botonAgregarTarea = new Button("Agregar tarea");
        botonAgregarTarea.setOnAction(event -> {
            Tarea nuevaTarea = mostrarCuadroAgregarTarea();
            tablaDeTareas.getItems().add(nuevaTarea);
        });
        Button botonEliminarTarea = new Button("Eliminar tarea");
        botonEliminarTarea.setOnAction(event -> {
            Tarea tareaSeleccionada = tablaDeTareas.getSelectionModel().getSelectedItem();
            if (tareaSeleccionada != null) {
                tablaDeTareas.getItems().remove(tareaSeleccionada);
            }
        });

        // Crear el panel
        VBox vbox = new VBox(detallesDeProgreso, Sprints, tablaDeTareas, botonAgregarTarea, botonEliminarTarea);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        borderPane.setCenter(vbox);
        projectDetailsLayout.getChildren().setAll(borderPane);
    }
    private void agregarProyectoCuadro() {
        Dialog<Project> AgregarProyectoCuadro = new Dialog<>();
        AgregarProyectoCuadro.setTitle("Agregar proyecto");
        // Set the dialog buttons
        ButtonType agregarBoton = new ButtonType("Agregar ", ButtonBar.ButtonData.OK_DONE);
        AgregarProyectoCuadro.getDialogPane().getButtonTypes().addAll(agregarBoton, ButtonType.CANCEL);
        // Create the dialog content
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        // Create the name field
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Escriba aqui");
        // Create the start date picker
        DatePicker fechaDeInicioPicker = new DatePicker();
        fechaDeInicioPicker.setValue(LocalDate.now());
        // Create the end date picker
        DatePicker fechaDeTerminadoPicker = new DatePicker();
        fechaDeTerminadoPicker.setPromptText("Escriba aqui");
        fechaDeTerminadoPicker.setValue(LocalDate.now());
        TextField campoPresupuesto = new TextField();
        campoPresupuesto.setPromptText("Escriba aqui");
        TextField campoManagerDeProyecto = new TextField();
        campoManagerDeProyecto.setPromptText("Escriba aqui");
        gridPane.add(new Label("Nombre:"), 0, 0);
        gridPane.add(campoNombre, 1, 0);
        gridPane.add(new Label("Fecha de inicio:"), 0, 1);
        gridPane.add(fechaDeInicioPicker, 1, 1);
        gridPane.add(new Label("Fecha de terminado:"), 0, 2);
        gridPane.add(fechaDeTerminadoPicker, 1, 2);
        gridPane.add(new Label("Presupuesto:"), 0, 3);
        gridPane.add(campoPresupuesto, 1, 3);
        gridPane.add(new Label("Manager de proyecto:"), 0, 4);
        gridPane.add(campoManagerDeProyecto, 1, 4);
        AgregarProyectoCuadro.getDialogPane().setContent(gridPane);
        AgregarProyectoCuadro.setResultConverter(buttonType -> {
            if (buttonType == agregarBoton) {
                //Convertir las fechas a LocalDate
                LocalDate fechaDeInicio = fechaDeInicioPicker.getValue();
                LocalDate fechaDeTerminado = fechaDeTerminadoPicker.getValue();
                Project project = new Project(campoNombre.getText(),fechaDeInicio,fechaDeTerminado,null,campoPresupuesto.getText(), campoManagerDeProyecto.getText());
                observableProjects.add(project);
                return project;
            }
            return null;
        });
        AgregarProyectoCuadro.showAndWait();
    }
    private Tarea mostrarCuadroAgregarTarea(){
        Dialog<Tarea> cuadroAgregarTarea = new Dialog<>();
        cuadroAgregarTarea.setTitle("Agregar tarea");
        // Set the dialog buttons
        ButtonType agregarBoton = new ButtonType("Agregar ", ButtonBar.ButtonData.OK_DONE);
        cuadroAgregarTarea.getDialogPane().getButtonTypes().addAll(agregarBoton, ButtonType.CANCEL);
        // Create the name field
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Tarea");
        //Crear campo de descripcion
        TextField campoDescripcion = new TextField();
        campoDescripcion.setPromptText("Descripcion");
        // Create the start date field
        DatePicker fechaDeInicioPicker = new DatePicker();
        fechaDeInicioPicker.setValue(LocalDate.now());
        fechaDeInicioPicker.setPromptText("Fecha de inicio");
        // Create the end date field
        DatePicker fechaDeTerminadoPicker = new DatePicker();
        fechaDeTerminadoPicker.setValue(LocalDate.now());
        fechaDeTerminadoPicker.setPromptText("Fecha de terminado");
        // Create the dialog layout
        GridPane dialogLayout = new GridPane();
        dialogLayout.setHgap(10);
        dialogLayout.setVgap(10);
        dialogLayout.setAlignment(Pos.CENTER);
        dialogLayout.add(new Label("Tarea:"), 0, 0);
        dialogLayout.add(campoNombre, 1, 0);
        dialogLayout.add(new Label("Fecha de inicio:"), 0, 1);
        dialogLayout.add(fechaDeInicioPicker, 1, 1);
        dialogLayout.add(new Label("Fecha de terminado:"), 0, 2);
        dialogLayout.add(fechaDeTerminadoPicker, 1, 2);
        dialogLayout.add(new Label("Descripcion:"), 0, 3);
        dialogLayout.add(campoDescripcion, 1, 3);
        cuadroAgregarTarea.getDialogPane().setContent(dialogLayout);
        // Convert the result to a Tarea object
        cuadroAgregarTarea.setResultConverter(dialogButton -> {
            if (dialogButton == agregarBoton) {
                return new Tarea(campoNombre.getText(),fechaDeInicioPicker.getValue(),fechaDeTerminadoPicker.getValue(),campoDescripcion.getText(),false);
            }
            return null;
        });
        Optional<Tarea> result = cuadroAgregarTarea.showAndWait();
        return result.orElse(null);
    }
}
