package org.example.bibliotecadecodigopmi.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PestañaMenuPrincipal {
    private PestañaPrincipal pestañaPrincipal;

    public void setupMenu(Stage primaryStage) {

    //Menu de inicio
    BorderPane menuLayout = new BorderPane();
    menuLayout.setPrefSize(800, 600);
    menuLayout.setPadding(new javafx.geometry.Insets(10));

    //Titulo
    VBox title = new VBox();
    title.setSpacing(10);
    title.setPadding(new javafx.geometry.Insets(10));
    title.setAlignment(javafx.geometry.Pos.CENTER);
    javafx.scene.text.Text titleText = new javafx.scene.text.Text("Bienvenido");
    titleText.setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 20));
    title.getChildren().add(titleText);

    //Opciones del menu
    VBox menuOptions = new VBox();
    menuOptions.setSpacing(10);
    menuOptions.setPadding(new javafx.geometry.Insets(10));
    menuOptions.setAlignment(javafx.geometry.Pos.CENTER);

    //Area de proyectos
    Button projectArea = new Button("Proyectos");

    //Tamanio de letra y boton
    projectArea.setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 20));
    projectArea.setPrefSize(200, 100);
    projectArea.setOnAction((event) -> {
        primaryStage.setTitle("Libreria para gestion de desarrollo de software");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        pestañaPrincipal = new PestañaPrincipal();
        pestañaPrincipal.start(primaryStage);
    });

    //Agregamos boton al menu opciones
    menuOptions.getChildren().addAll(projectArea);

    //Agregamos todos los componentes al layout principal
    menuLayout.setTop(title);
    menuLayout.setCenter(menuOptions);

    Scene scene = new Scene(menuLayout, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
}
